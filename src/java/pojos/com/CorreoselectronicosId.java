package pojos.com;
// Generated 20/05/2016 09:28:53 PM by Hibernate Tools 4.3.1



/**
 * CorreoselectronicosId generated by hbm2java
 */
public class CorreoselectronicosId  implements java.io.Serializable {


     private int idCorreosElectronicos;
     private int personaIdPersona;

    public CorreoselectronicosId() {
    }

    public CorreoselectronicosId(int idCorreosElectronicos, int personaIdPersona) {
       this.idCorreosElectronicos = idCorreosElectronicos;
       this.personaIdPersona = personaIdPersona;
    }
   
    public int getIdCorreosElectronicos() {
        return this.idCorreosElectronicos;
    }
    
    public void setIdCorreosElectronicos(int idCorreosElectronicos) {
        this.idCorreosElectronicos = idCorreosElectronicos;
    }
    public int getPersonaIdPersona() {
        return this.personaIdPersona;
    }
    
    public void setPersonaIdPersona(int personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CorreoselectronicosId) ) return false;
		 CorreoselectronicosId castOther = ( CorreoselectronicosId ) other; 
         
		 return (this.getIdCorreosElectronicos()==castOther.getIdCorreosElectronicos())
 && (this.getPersonaIdPersona()==castOther.getPersonaIdPersona());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdCorreosElectronicos();
         result = 37 * result + this.getPersonaIdPersona();
         return result;
   }   


}


