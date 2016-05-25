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
public class TelefonosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTelefonos")
    private int idTelefonos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Persona_idPersona")
    private int personaidPersona;

    public TelefonosPK() {
    }

    public TelefonosPK(int idTelefonos, int personaidPersona) {
        this.idTelefonos = idTelefonos;
        this.personaidPersona = personaidPersona;
    }

    public int getIdTelefonos() {
        return idTelefonos;
    }

    public void setIdTelefonos(int idTelefonos) {
        this.idTelefonos = idTelefonos;
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
        hash += (int) idTelefonos;
        hash += (int) personaidPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonosPK)) {
            return false;
        }
        TelefonosPK other = (TelefonosPK) object;
        if (this.idTelefonos != other.idTelefonos) {
            return false;
        }
        if (this.personaidPersona != other.personaidPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.com.TelefonosPK[ idTelefonos=" + idTelefonos + ", personaidPersona=" + personaidPersona + " ]";
    }
    
}
