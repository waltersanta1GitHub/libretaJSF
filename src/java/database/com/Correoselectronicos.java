/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.com;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Developer
 */
@Entity
@Table(name = "correoselectronicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correoselectronicos.findAll", query = "SELECT c FROM Correoselectronicos c"),
    @NamedQuery(name = "Correoselectronicos.findByIdCorreosElectronicos", query = "SELECT c FROM Correoselectronicos c WHERE c.correoselectronicosPK.idCorreosElectronicos = :idCorreosElectronicos"),
    @NamedQuery(name = "Correoselectronicos.findByCorreoElectronico", query = "SELECT c FROM Correoselectronicos c WHERE c.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Correoselectronicos.findByPersonaidPersona", query = "SELECT c FROM Correoselectronicos c WHERE c.correoselectronicosPK.personaidPersona = :personaidPersona"),
    @NamedQuery(name = "Correoselectronicos.findByHabilitado", query = "SELECT c FROM Correoselectronicos c WHERE c.habilitado = :habilitado")})
public class Correoselectronicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CorreoselectronicosPK correoselectronicosPK;
    @Size(max = 45)
    @Column(name = "CorreoElectronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private boolean habilitado;
    @JoinColumn(name = "Persona_idPersona", referencedColumnName = "idPersona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Correoselectronicos() {
    }

    public Correoselectronicos(CorreoselectronicosPK correoselectronicosPK) {
        this.correoselectronicosPK = correoselectronicosPK;
    }

    public Correoselectronicos(CorreoselectronicosPK correoselectronicosPK, boolean habilitado) {
        this.correoselectronicosPK = correoselectronicosPK;
        this.habilitado = habilitado;
    }

    public Correoselectronicos(int idCorreosElectronicos, int personaidPersona) {
        this.correoselectronicosPK = new CorreoselectronicosPK(idCorreosElectronicos, personaidPersona);
    }

    public CorreoselectronicosPK getCorreoselectronicosPK() {
        return correoselectronicosPK;
    }

    public void setCorreoselectronicosPK(CorreoselectronicosPK correoselectronicosPK) {
        this.correoselectronicosPK = correoselectronicosPK;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correoselectronicosPK != null ? correoselectronicosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correoselectronicos)) {
            return false;
        }
        Correoselectronicos other = (Correoselectronicos) object;
        if ((this.correoselectronicosPK == null && other.correoselectronicosPK != null) || (this.correoselectronicosPK != null && !this.correoselectronicosPK.equals(other.correoselectronicosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.com.Correoselectronicos[ correoselectronicosPK=" + correoselectronicosPK + " ]";
    }
    
}
