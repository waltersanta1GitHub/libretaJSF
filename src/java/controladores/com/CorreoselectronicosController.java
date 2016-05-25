package controladores.com;

import database.com.Correoselectronicos;
import controladores.com.util.JsfUtil;
import controladores.com.util.JsfUtil.PersistAction;
import fachadas.com.CorreoselectronicosFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "correoselectronicosController")
@SessionScoped
public class CorreoselectronicosController implements Serializable {

    @EJB
    private fachadas.com.CorreoselectronicosFacade ejbFacade;
    private List<Correoselectronicos> items = null;
    private Correoselectronicos selected;

    public CorreoselectronicosController() {
    }

    public Correoselectronicos getSelected() {
        return selected;
    }

    public void setSelected(Correoselectronicos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCorreoselectronicosPK().setPersonaidPersona(selected.getPersona().getIdPersona());
    }

    protected void initializeEmbeddableKey() {
        selected.setCorreoselectronicosPK(new database.com.CorreoselectronicosPK());
    }

    private CorreoselectronicosFacade getFacade() {
        return ejbFacade;
    }

    public Correoselectronicos prepareCreate() {
        selected = new Correoselectronicos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CorreoselectronicosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CorreoselectronicosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CorreoselectronicosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Correoselectronicos> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Correoselectronicos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Correoselectronicos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Correoselectronicos.class)
    public static class CorreoselectronicosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CorreoselectronicosController controller = (CorreoselectronicosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "correoselectronicosController");
            return controller.getFacade().find(getKey(value));
        }

        database.com.CorreoselectronicosPK getKey(String value) {
            database.com.CorreoselectronicosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new database.com.CorreoselectronicosPK();
            key.setIdCorreosElectronicos(Integer.parseInt(values[0]));
            key.setPersonaidPersona(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(database.com.CorreoselectronicosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCorreosElectronicos());
            sb.append(SEPARATOR);
            sb.append(value.getPersonaidPersona());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Correoselectronicos) {
                Correoselectronicos o = (Correoselectronicos) object;
                return getStringKey(o.getCorreoselectronicosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Correoselectronicos.class.getName()});
                return null;
            }
        }

    }

}
