/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Doctor;

/**
 *
 * @author Aki
 */
public class Doctor {
    private String doctorname;
    private String email;
    private int phone;
  

 

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    
    

    
   /* public enum Gender{
        Male("Male"),Female("Female");
        
        private String valve;
        
        private Gender(String value){
            this.valve = value;
        }

        
        public String getValve() {
            return valve;
        }

        public void setValve(String valve) {
            this.valve = valve;
        }
        
       
        
      
     */   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    
    
    

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

   
    
    

    @Override
    public String toString(){
        return doctorname;
    }
       
   
    
}
