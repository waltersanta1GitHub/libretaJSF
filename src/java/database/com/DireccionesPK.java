/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.com;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Developer
 */
@Embeddable
public class DireccionesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idDirecciones")
    private int idDirecciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Persona_idPersona")
    private int personaidPersona;

    public DireccionesPK() {
    }

    public DireccionesPK(int idDirecciones, int personaidPersona) {
        this.idDirecciones = idDirecciones;
        this.personaidPersona = personaidPersona;
    }

    public int getIdDirecciones() {
        return idDirecciones;
    }

    public void setIdDirecciones(int idDirecciones) {
        this.idDirecciones = idDirecciones;
    }

    public int getPersonaidPersona() {
        return personaidPersona;
    }

    public void setPersonaidPersona(int personaidPersona) {
        this.personaidPersona = personaidPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDirecciones;
        hash += (int) personaidPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionesPK)) {
            return false;
        }
        DireccionesPK other = (DireccionesPK) object;
        if (this.idDirecciones != other.idDirecciones) {
            return false;
        }
        if (this.personaidPersona != other.personaidPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.com.DireccionesPK[ idDirecciones=" + idDirecciones + ", personaidPersona=" + personaidPersona + " ]";
    }
    
}
