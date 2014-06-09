/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Doctor;

import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class DoctorDirectory {
    
    private ArrayList<Doctor> doctorList;
    
    public DoctorDirectory(){
        doctorList = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }


     public Doctor createDoctor(String name) {
        Doctor d = new Doctor();
        d.setDoctorname(name);
        doctorList.add(d);
        return d;
    }
    
    
    
}
