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
@Table(name = "telefonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonos.findAll", query = "SELECT t FROM Telefonos t"),
    @NamedQuery(name = "Telefonos.findByIdTelefonos", query = "SELECT t FROM Telefonos t WHERE t.telefonosPK.idTelefonos = :idTelefonos"),
    @NamedQuery(name = "Telefonos.findByTelefono", query = "SELECT t FROM Telefonos t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Telefonos.findByUbicacion", query = "SELECT t FROM Telefonos t WHERE t.ubicacion = :ubicacion"),
    @NamedQuery(name = "Telefonos.findByPersonaidPersona", query = "SELECT t FROM Telefonos t WHERE t.telefonosPK.personaidPersona = :personaidPersona"),
    @NamedQuery(name = "Telefonos.findByHabilitado", query = "SELECT t FROM Telefonos t WHERE t.habilitado = :habilitado")})
public class Telefonos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefonosPK telefonosPK;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private boolean habilitado;
    @JoinColumn(name = "Persona_idPersona", referencedColumnName = "idPersona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Telefonos() {
    }

    public Telefonos(TelefonosPK telefonosPK) {
        this.telefonosPK = telefonosPK;
    }

    public Telefonos(TelefonosPK telefonosPK, boolean habilitado) {
        this.telefonosPK = telefonosPK;
        this.habilitado = habilitado;
    }

    public Telefonos(int idTelefonos, int personaidPersona) {
        this.telefonosPK = new TelefonosPK(idTelefonos, personaidPersona);
    }

    public TelefonosPK getTelefonosPK() {
        return telefonosPK;
    }

    public void setTelefonosPK(TelefonosPK telefonosPK) {
        this.telefonosPK = telefonosPK;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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
        hash += (telefonosPK != null ? telefonosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonos)) {
            return false;
        }
        Telefonos other = (Telefonos) object;
        if ((this.telefonosPK == null && other.telefonosPK != null) || (this.telefonosPK != null && !this.telefonosPK.equals(other.telefonosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.com.Telefonos[ telefonosPK=" + telefonosPK + " ]";
    }
    
}
