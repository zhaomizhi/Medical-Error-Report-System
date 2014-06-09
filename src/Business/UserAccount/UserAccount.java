/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Doctor.Doctor;
import Business.Employee.Employee;
import Business.GovEmployee.GovEmployee;

import Business.Patient.Patient;
import Business.RegisterReport.RegisterReportDirectory;
import Business.Role.Role;
import Business.Servicer.Servicer;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Aki
 */
public class UserAccount {
    private String userName;
    private String password;
    private Role role;
    private Employee employee;
    private WorkQueue workQueue;
    private Doctor doctor;
    private Patient patient;
    private Servicer servicer;
    private GovEmployee ge;
    private RegisterReportDirectory registerReportDirectory;
   
  

    

    public RegisterReportDirectory getRegisterReportDirectory() {
        return registerReportDirectory;
    }

    public void setRegisterReportDirectory(RegisterReportDirectory registerReportDirectory) {
        this.registerReportDirectory = registerReportDirectory;
    }
    

    public UserAccount() {
        
        workQueue=new WorkQueue();
        registerReportDirectory = new RegisterReportDirectory();
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Servicer getServicer() {
        return servicer;
    }

    public void setServicer(Servicer servicer) {
        this.servicer = servicer;
    }

    public GovEmployee getGe() {
        return ge;
    }

    public void setGe(GovEmployee ge) {
        this.ge = ge;
    }
    


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

   
    
    
}
