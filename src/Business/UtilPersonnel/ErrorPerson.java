/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UtilPersonnel;

/**
 *
 * @author Aki
 */
public abstract class ErrorPerson {
    
    private ErrorPersonType ept;

    public ErrorPerson(ErrorPersonType errorType) {
        this.ept=errorType;
    }
    
    

    public enum ErrorPersonType {

        PHYSICIAN("Physician"), NURESE("Nurse"),SURGEON("Surgeon"), PHARMACIST("Pharmacist"),
        PATHOLOGIST("Pathologist"), ADMINSTRATION("Adminstration");
        
         private String value;
         private ErrorPersonType(String value){
             this.value = value;          
         }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
         
 }

    public ErrorPersonType getEpt() {
        return ept;
    }

    public void setEpt(ErrorPersonType ept) {
        this.ept = ept;
    }
    
    @Override
   public String toString(){
       return ept.toString();
   }
    
    
}
