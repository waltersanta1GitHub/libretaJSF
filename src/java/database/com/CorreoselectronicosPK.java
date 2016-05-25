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
public class CorreoselectronicosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idCorreosElectronicos")
    private int idCorreosElectronicos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Persona_idPersona")
    private int personaidPersona;

    public CorreoselectronicosPK() {
    }

    public CorreoselectronicosPK(int idCorreosElectronicos, int personaidPersona) {
        this.idCorreosElectronicos = idCorreosElectronicos;
        this.personaidPersona = personaidPersona;
    }

    public int getIdCorreosElectronicos() {
        return idCorreosElectronicos;
    }

    public void setIdCorreosElectronicos(int idCorreosElectronicos) {
        this.idCorreosElectronicos = idCorreosElectronicos;
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
        hash += (int) idCorreosElectronicos;
        hash += (int) personaidPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorreoselectronicosPK)) {
            return false;
        }
        CorreoselectronicosPK other = (CorreoselectronicosPK) object;
        if (this.idCorreosElectronicos != other.idCorreosElectronicos) {
            return false;
        }
        if (this.personaidPersona != other.personaidPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.com.CorreoselectronicosPK[ idCorreosElectronicos=" + idCorreosElectronicos + ", personaidPersona=" + personaidPersona + " ]";
    }
    
}
