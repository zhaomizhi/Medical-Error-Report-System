###Medical Adverse Events Reporting Systems
----
###Background:
####Problem:
Medical errors are responsive for many death and injuries world-wide. Government and hospitals need find a way to deal with them, reduce them. 

####Solution -- Medical errors report system
####Features of this system
* Anonymity of reporter
* Easily to check the status of reports
* Feedback
* Save data for user`s convenience
* Verified reports guarantee factual data
* Statistic reports help government and hospital to make protective steps 

----
###Code example
##### OOP - Inheritance & Polymorphism
I organized classes using inheritance to avoid duplication and reduce redundancy. As there are many kind of roles of user using this system. I make Role class abstract and every different role will extend Role class.

![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/package%201.png "package") 
######Abstract Class
	public abstract class Role {
    
    public abstract JPanel fetchPanel(JPanel container,UserAccount ua,
    Organization org,Enterprise enterprise,EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName(); 
      }
	}   	
    
    
    
###### Subclass
	public class DoctorRole extends Role{

    @Override
    public JPanel fetchPanel(JPanel container, UserAccount ua, 
    Organization org, Enterprise enterprise,EcoSystem business) {          
           DoctorHomepageAreaJPanel doctorWorkareaJPanel=new DoctorHomepageAreaJPanel(container,ua,org,enterprise,business);
            return doctorWorkareaJPanel;
   		 }
	}





Another example of using inheritance. Based on my design, this system will allow different kind people login and the data will be saved in different organization and departments. These organizations share many commosns, for example, every organization has its own name, user account directory, work queue and so on. So I created a Abstract class named Organization, subclass which represents different organization extends this class. This approach has greatly reduced my work while I do not need to create the same variable and method for each class over and over again. 

 ![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/package%202.png "package") 


######Abstract class 
	
	public abstract class Organization {

    private String orgName;
    private EmployeeDirectory employeeDirectory;
    private WorkQueue workQueue;
    private UserAccountDirectory userAccountDirectory;
    private PatientDirectory patientDirectory;
    private DoctorDirectory doctorDirectory;
    private ServicerDirectory servicerDirectory;
    private GovEmployeeDirectory ged;



    public enum Type {

        Admin("Admin Department"), Doctor("Doctor Department")
        ,Service("Service center"),Patient("Patient Organization"),HealtheCareAdministration("Healthcare Administration")
        ,SecretaryOrganization("Secretary Organization");
        private String value;

        private Type(String value) {
            this.value = value;
        }
      }
   
	//construtor
    public Organization(String name) {

        this.orgName = name;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
      
        workQueue = new WorkQueue();
        patientDirectory = new PatientDirectory();
        doctorDirectory = new DoctorDirectory();
        servicerDirectory = new ServicerDirectory();
        ged = new GovEmployeeDirectory();
    }

    @Override
    public String toString() {
        return orgName; //To change body of generated methods, choose Tools | Templates.
    	}
	}

######subclass

	public class SecretaryOrganization extends Organization {

    public SecretaryOrganization() {
        super(Organization.Type.SecretaryOrganization.getValue());
    }

    @Override   
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roleList = new ArrayList();
        roleList.add(new SecretaryRole());
        return roleList;    
 	   }

	}	
	
#####The "instanceof" Operator
"instanceof" operator used for check whether a class is one specific subclass or not.
For example, when creating user account for different people, the user information should be save based on what kind of organization they belong to.


    private void createEmployee() {
        Organization org = (Organization) jComboBox1.getSelectedItem();

        if (org instanceof DoctorOrganization) {
            String name = jTextField1.getText();
            org.getDoctorDirectory().createDoctor(name);
        }
        if (org instanceof PatientOrganization) {
            String name = jTextField1.getText();
            org.getPatientDirectory().createPtient(name);

        }
        if (org instanceof ServiceOrganization) {
            String name = jTextField1.getText();
            org.getServicerDirectory().createServicer(name);

        }if(org instanceof SecretaryOrganization || org instanceof HAdminstration){
            String name = jTextField1.getText();
            org.getGed().createGovEmployee(name);
        }
    }

---
###Class Diagram ( System Architecture )

![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/class%20diagram.png) 

---
### Work Flow
![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/work%20flow.png) 


----

###UI presentation: 
All the UI are presented via JAVA Swing.
 
#####Report panel, The system will help you to find the right place to report. 
![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/panel.png) 

 
#####Report panel. System will check whether you has make all the required choice on this page.
![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/report%20panel.png) 


 
#####It is easy to check the status of reports.
![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/status.png) 
 
#####Based on the data gathered from various report, several charts will be generate automatically. It will show the result of medical error intuitively.
![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/charts.png) 
 
##### Reports based on analyized data will  public.
#####This will help hospitals be aware of the potential problems and medial errors in the future.
![package](https://raw.githubusercontent.com/zhaomizhi/Medical-Error-Report-System/master/images/statistic%20report.png) 

----




