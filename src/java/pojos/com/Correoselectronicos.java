package pojos.com;
// Generated 20/05/2016 09:28:53 PM by Hibernate Tools 4.3.1



/**
 * Correoselectronicos generated by hbm2java
 */
public class Correoselectronicos  implements java.io.Serializable {


     private CorreoselectronicosId id;
     private Persona persona;
     private String correoElectronico;
     private boolean habilitado;

    public Correoselectronicos() {
    }

	
    public Correoselectronicos(CorreoselectronicosId id, Persona persona, boolean habilitado) {
        this.id = id;
        this.persona = persona;
        this.habilitado = habilitado;
    }
    public Correoselectronicos(CorreoselectronicosId id, Persona persona, String correoElectronico, boolean habilitado) {
       this.id = id;
       this.persona = persona;
       this.correoElectronico = correoElectronico;
       this.habilitado = habilitado;
    }
   
    public CorreoselectronicosId getId() {
        return this.id;
    }
    
    public void setId(CorreoselectronicosId id) {
        this.id = id;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public boolean isHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }




}


