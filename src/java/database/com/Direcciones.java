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
@Table(name = "direcciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d"),
    @NamedQuery(name = "Direcciones.findByIdDirecciones", query = "SELECT d FROM Direcciones d WHERE d.direccionesPK.idDirecciones = :idDirecciones"),
    @NamedQuery(name = "Direcciones.findByDireccion", query = "SELECT d FROM Direcciones d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Direcciones.findByPersonaidPersona", query = "SELECT d FROM Direcciones d WHERE d.direccionesPK.personaidPersona = :personaidPersona"),
    @NamedQuery(name = "Direcciones.findByHabilitado", query = "SELECT d FROM Direcciones d WHERE d.habilitado = :habilitado")})
public class Direcciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DireccionesPK direccionesPK;
    @Size(max = 150)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private boolean habilitado;
    @JoinColumn(name = "Persona_idPersona", referencedColumnName = "idPersona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Direcciones() {
    }

    public Direcciones(DireccionesPK direccionesPK) {
        this.direccionesPK = direccionesPK;
    }

    public Direcciones(DireccionesPK direccionesPK, boolean habilitado) {
        this.direccionesPK = direccionesPK;
        this.habilitado = habilitado;
    }

    public Direcciones(int idDirecciones, int personaidPersona) {
        this.direccionesPK = new DireccionesPK(idDirecciones, personaidPersona);
    }

    public DireccionesPK getDireccionesPK() {
        return direccionesPK;
    }

    public void setDireccionesPK(DireccionesPK direccionesPK) {
        this.direccionesPK = direccionesPK;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        hash += (direccionesPK != null ? direccionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.direccionesPK == null && other.direccionesPK != null) || (this.direccionesPK != null && !this.direccionesPK.equals(other.direccionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.com.Direcciones[ direccionesPK=" + direccionesPK + " ]";
    }
    
}
