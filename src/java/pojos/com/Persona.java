package pojos.com;
// Generated 20/05/2016 09:28:53 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer idPersona;
     private String nombre;
     private String edad;
     private Character sexo;
     private String documento;
     private boolean habilitado;
     private Set direccioneses = new HashSet(0);
     private Set correoselectronicoses = new HashSet(0);
     private Set telefonoses = new HashSet(0);

    public Persona() {
    }

	
    public Persona(String nombre, String documento, boolean habilitado) {
        this.nombre = nombre;
        this.documento = documento;
        this.habilitado = habilitado;
    }
    public Persona(String nombre, String edad, Character sexo, String documento, boolean habilitado, Set direccioneses, Set correoselectronicoses, Set telefonoses) {
       this.nombre = nombre;
       this.edad = edad;
       this.sexo = sexo;
       this.documento = documento;
       this.habilitado = habilitado;
       this.direccioneses = direccioneses;
       this.correoselectronicoses = correoselectronicoses;
       this.telefonoses = telefonoses;
    }
   
    public Integer getIdPersona() {
        return this.idPersona;
    }
    
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEdad() {
        return this.edad;
    }
    
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public Character getSexo() {
        return this.sexo;
    }
    
    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
    public String getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public boolean isHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    public Set getDireccioneses() {
        return this.direccioneses;
    }
    
    public void setDireccioneses(Set direccioneses) {
        this.direccioneses = direccioneses;
    }
    public Set getCorreoselectronicoses() {
        return this.correoselectronicoses;
    }
    
    public void setCorreoselectronicoses(Set correoselectronicoses) {
        this.correoselectronicoses = correoselectronicoses;
    }
    public Set getTelefonoses() {
        return this.telefonoses;
    }
    
    public void setTelefonoses(Set telefonoses) {
        this.telefonoses = telefonoses;
    }




}

