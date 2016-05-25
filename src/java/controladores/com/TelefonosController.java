package controladores.com;

import database.com.Telefonos;
import controladores.com.util.JsfUtil;
import controladores.com.util.JsfUtil.PersistAction;
import fachadas.com.TelefonosFacade;

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

@ManagedBean(name = "telefonosController")
@SessionScoped
public class TelefonosController implements Serializable {

    @EJB
    private fachadas.com.TelefonosFacade ejbFacade;
    private List<Telefonos> items = null;
    private Telefonos selected;

    public TelefonosController() {
    }

    public Telefonos getSelected() {
        return selected;
    }

    public void setSelected(Telefonos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTelefonosPK().setPersonaidPersona(selected.getPersona().getIdPersona());
    }

    protected void initializeEmbeddableKey() {
        selected.setTelefonosPK(new database.com.TelefonosPK());
    }

    private TelefonosFacade getFacade() {
        return ejbFacade;
    }

    public Telefonos prepareCreate() {
        selected = new Telefonos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TelefonosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TelefonosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TelefonosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Telefonos> getItems() {
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

    public List<Telefonos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Telefonos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Telefonos.class)
    public static class TelefonosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TelefonosController controller = (TelefonosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "telefonosController");
            return controller.getFacade().find(getKey(value));
        }

        database.com.TelefonosPK getKey(String value) {
            database.com.TelefonosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new database.com.TelefonosPK();
            key.setIdTelefonos(Integer.parseInt(values[0]));
            key.setPersonaidPersona(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(database.com.TelefonosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdTelefonos());
            sb.append(SEPARATOR);
            sb.append(value.getPersonaidPersona());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Telefonos) {
                Telefonos o = (Telefonos) object;
                return getStringKey(o.getTelefonosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Telefonos.class.getName()});
                return null;
            }
        }

    }

}
