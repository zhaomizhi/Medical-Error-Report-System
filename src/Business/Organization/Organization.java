/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Doctor.DoctorDirectory;
import Business.Employee.EmployeeDirectory;
import Business.GovEmployee.GovEmployeeDirectory;

import Business.Patient.PatientDirectory;
import Business.Report.ReportToReporter;
import Business.Report.ReporttoEnterDir;
import Business.Role.Role;
import Business.Servicer.ServicerDirectory;
import Business.UserAccount.UserAccountDirectory;

import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public abstract class Organization {

 
    private String orgName;
    private EmployeeDirectory employeeDirectory;
    private WorkQueue workQueue;
    private UserAccountDirectory userAccountDirectory;
    private PatientDirectory patientDirectory;
    private DoctorDirectory doctorDirectory;
    private ServicerDirectory servicerDirectory;
    private GovEmployeeDirectory ged;
    private ReportToReporter report;
    private ReporttoEnterDir reporttoEnterDir;


    public enum Type {

        Admin("Admin Department"), Doctor("Doctor Department")
        ,Service("Service center"),Patient("Patient Organization"),HealtheCareAdministration("Healthcare Administration")
        ,SecretaryOrganization("Secretary Organization");
        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    //parameterized constructor

    public Organization(String name) {

        this.orgName = name;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
      
        workQueue = new WorkQueue();
        patientDirectory = new PatientDirectory();
        doctorDirectory = new DoctorDirectory();
        servicerDirectory = new ServicerDirectory();
        ged = new GovEmployeeDirectory();
        report = new ReportToReporter();
        reporttoEnterDir = new ReporttoEnterDir();
      

// reporttoEnter = new ReporttoEnter();
       // issuesWorkRequestList= new ArrayList();
       
    }

    /* public ArrayList<WorkRequest> getIssuesWorkRequestList() {
    return issuesWorkRequestList;
    }
    public void setIssuesWorkRequestList(ArrayList<WorkRequest> issuesWorkRequestList) {
    this.issuesWorkRequestList = issuesWorkRequestList;
    }
     */
  
    
    
    
    
    
    
    
    public ReporttoEnterDir getReporttoEnterDir() {
        return reporttoEnterDir;
    }

    public void setReporttoEnterDir(ReporttoEnterDir reporttoEnterDir) {  
        this.reporttoEnterDir = reporttoEnterDir;
    }
    
    
    
  
  
    
    
    
    public ReportToReporter getReport() {
        return report;
    }

    public void setReport(ReportToReporter report) {
        this.report = report;
    }

    
    
    
    public abstract ArrayList<Role> getSupportedRoles();

  

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public DoctorDirectory getDoctorDirectory() {
        return doctorDirectory;
    }

    public void setDoctorDirectory(DoctorDirectory doctorDirectory) {
        this.doctorDirectory = doctorDirectory;
    }

    public ServicerDirectory getServicerDirectory() {
        return servicerDirectory;
    }

    public void setServicerDirectory(ServicerDirectory servicerDirectory) {
        this.servicerDirectory = servicerDirectory;
    }

    public GovEmployeeDirectory getGed() {
        return ged;
    }

    public void setGed(GovEmployeeDirectory ged) {
        this.ged = ged;
    }

    
 



    
  

    
    
    @Override
    public String toString() {
        return orgName; //To change body of generated methods, choose Tools | Templates.
    }
}
