/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Doctor.Doctor;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.GovEmployee.GovEmployee;
import Business.NetWork.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.HAdminstrationRole;

import Business.Role.PatientRole;
import Business.Role.SecretaryRole;
import Business.Role.ServiceRole;
import Business.Role.SystemAdminRole;
import Business.Servicer.Servicer;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Aki
 */
public class ConfigureASystem {

    public static EcoSystem configureABusiness() {

        EcoSystem ecoSystem = EcoSystem.getInstance();

        Employee employee = ecoSystem.getEmployeeDirectory().createEmployee("Aki");

        UserAccount ua = ecoSystem.getUserAccountDirectory().createUserAccount("admin", "admin", employee, new SystemAdminRole());

        Network n1 = ecoSystem.createAndAddNetwork();

        n1.setName("USA");

        Enterprise e1 = n1.getEd().createEnterprise("Boston Public Clinic", Enterprise.EnterpriseType.Clinic);
        Employee e3 = e1.getEmployeeDirectory().createEmployee("Ross");
        UserAccount ua13 = e1.getUserAccountDirectory().createUserAccount();
        ua13.setUserName("ross");
        ua13.setPassword("ross");
        ua13.setRole(new AdminRole());

        Enterprise e2 = n1.getEd().createEnterprise("Glenn Medical Hospital", Enterprise.EnterpriseType.Hospital);
        Employee employee11 = e2.getEmployeeDirectory().createEmployee("Faye");
        UserAccount ua12 = e2.getUserAccountDirectory().createUserAccount();
        ua12.setEmployee(employee11);
        ua12.setUserName("faye");
        ua12.setPassword("faye");
        ua12.setRole(new AdminRole());
        
        
         Enterprise e8 = n1.getEd().createEnterprise("New York Hospital", Enterprise.EnterpriseType.Hospital);
        Employee employee15 = e8.getEmployeeDirectory().createEmployee("ny");
        UserAccount ua15 = e8.getUserAccountDirectory().createUserAccount();
        ua12.setEmployee(employee15);
        ua15.setUserName("nyadmin");
        ua15.setPassword("nyadmin");
        ua15.setRole(new AdminRole());
        
        
        
        
        Organization  nyorg = e8.getOrganizationDirectory().createOrganization(Organization.Type.Doctor);
        nyorg.setOrgName("Doctor Department");
        Doctor doctor3 = nyorg.getDoctorDirectory().createDoctor("Lvy");
        UserAccount ua20 = nyorg.getUserAccountDirectory().createUserAccount();
        ua20.setPassword("lvy");
        ua20.setUserName("lvy");
        ua20.setDoctor(doctor3);
        ua20.setRole(new DoctorRole());
        
        Organization  nyorg1 = e8.getOrganizationDirectory().createOrganization(Organization.Type.Patient);
        nyorg1.setOrgName("Patient Department");
        Patient patient6 = nyorg1.getPatientDirectory().createPtient("June");
        UserAccount ua21 = nyorg1.getUserAccountDirectory().createUserAccount();
        ua21.setPassword("june");
        ua21.setUserName("june");
        ua21.setPatient(patient6);
        ua21.setRole(new PatientRole());
        
         
        Organization  nyorg2 = e8.getOrganizationDirectory().createOrganization(Organization.Type.Service);
        nyorg2.setOrgName("Service Department");
        Servicer servicer = nyorg2.getServicerDirectory().createServicer("David");
        UserAccount ua22 = nyorg2.getUserAccountDirectory().createUserAccount();
        ua22.setPassword("david");
        ua22.setUserName("david");
        ua22.setServicer(servicer);
        ua22.setRole(new ServiceRole());
        
        
        
        
        
        
        
        
        
        
        
         Enterprise e9 = n1.getEd().createEnterprise("Chicago Hospital", Enterprise.EnterpriseType.Hospital);
        Employee employee16 = e9.getEmployeeDirectory().createEmployee("chi");
        UserAccount ua16 = e9.getUserAccountDirectory().createUserAccount();
        ua16.setEmployee(employee16);
        ua16.setUserName("cadmin");
        ua16.setPassword("cadmin");
        ua16.setRole(new AdminRole());
        
        
        
        
        
        

        // Enterprise e3 = n1.getEd().createEnterprise("USA Joint Health（NGO）", Enterprise.EnterpriseType.NGO);
        Enterprise e6 = n1.getEd().createEnterprise("USA Health and Human Service Center", Enterprise.EnterpriseType.Government);

        Employee employee10 = e6.getEmployeeDirectory().createEmployee("Faye");
        UserAccount ua10 = e6.getUserAccountDirectory().createUserAccount();
        ua10.setEmployee(employee10);
        ua10.setUserName("gadmin");
        ua10.setPassword("gadmin");
        ua10.setRole(new AdminRole());
        
        
        
        Network n2 = ecoSystem.createAndAddNetwork();
        n2.setName("CHINA");

        Enterprise e4 = n2.getEd().createEnterprise("China Xiehe hospital ", Enterprise.EnterpriseType.Hospital);
        Enterprise e5 = n2.getEd().createEnterprise("Ministry of health ", Enterprise.EnterpriseType.Government);

        
        Employee employee1 = e4.getEmployeeDirectory().createEmployee("dong");
        UserAccount ua18 = e4.getUserAccountDirectory().createUserAccount();
        ua18.setEmployee(employee1);
        ua18.setPassword("dong");
        ua18.setUserName("dong");
        ua18.setRole(new AdminRole());
        
        
        Employee employee13 = e5.getEmployeeDirectory().createEmployee("Yao");
        UserAccount ua14 = e5.getUserAccountDirectory().createUserAccount();
        ua14.setEmployee(employee13);
        ua14.setUserName("yao");
        ua14.setPassword("yao");
        ua14.setRole(new AdminRole());
        
       
        
        
        
      

        Organization org = e2.getOrganizationDirectory().createOrganization(Organization.Type.Doctor);
        org.setOrgName("Doctor Department");
        Doctor doctor2 = org.getDoctorDirectory().createDoctor("Monica");
        UserAccount ua1 = org.getUserAccountDirectory().createUserAccount();
        ua1.setPassword("monica");
        ua1.setUserName("monica");
        ua1.setDoctor(doctor2);
        ua1.setRole(new DoctorRole());
        
        
        Organization org111 = e2.getOrganizationDirectory().createOrganization(Organization.Type.Patient);
        org111.setOrgName("Patient Department");
        Patient patient4 = org111.getPatientDirectory().createPtient("Xiao");
        UserAccount ua55 = org111.getUserAccountDirectory().createUserAccount();
        ua55.setPassword("xiao");
        ua55.setUserName("xiao");
        ua55.setPatient(patient4);
        ua55.setRole(new PatientRole());
        
        Organization org112 = e2.getOrganizationDirectory().createOrganization(Organization.Type.Service);
        org112.setOrgName("Service Center");
        Servicer servicer3 = org112.getServicerDirectory().createServicer("sam");
        UserAccount ua50 = org112.getUserAccountDirectory().createUserAccount();
        ua50.setPassword("sam");
        ua50.setUserName("sam");
        ua50.setServicer(servicer3);
        ua50.setRole(new ServiceRole());
        
        
        
        
        

        Organization org1 = e1.getOrganizationDirectory().createOrganization(Organization.Type.Doctor);
        org1.setOrgName("Doctor Department");

        Doctor doctor = org1.getDoctorDirectory().createDoctor("Joey");
        //Employee employee2 = org1.getEmployeeDirectory().createEmployee("Joey");
        UserAccount ua2 = org1.getUserAccountDirectory().createUserAccount();
        ua2.setUserName("joey");
        ua2.setPassword("joey");
        ua2.setDoctor(doctor);
        ua2.setRole(new DoctorRole());

       // UserAccount ua2 = org1.getUserAccountDirectory().createUserAccount("joey", "joey", doctor, new DoctorRole());
        Organization org2 = e1.getOrganizationDirectory().createOrganization(Organization.Type.Patient);
        org2.setOrgName("Patient Department");

        Patient patient = org2.getPatientDirectory().createPtient("Rachel");
        UserAccount ua3 = org2.getUserAccountDirectory().createUserAccount();
        ua3.setPatient(patient);
        ua3.setUserName("rachel");
        ua3.setPassword("rachel");
        ua3.setRole(new PatientRole());
        

        //UserAccount ua3 = org2.getUserAccountDirectory().createUserAccount("rachel", "rachel", employee3, new PatientRole());
        Organization org3 = e1.getOrganizationDirectory().createOrganization(Organization.Type.Service);
        org3.setOrgName("Service Center");

        Servicer serivcer = org3.getServicerDirectory().createServicer("Richard");
        UserAccount ua4 = org3.getUserAccountDirectory().createUserAccount();
        ua4.setServicer(serivcer);
        ua4.setUserName("richard");
        ua4.setPassword("richard");
        ua4.setRole(new ServiceRole());
        //Employee employee4 = org3.getEmployeeDirectory().createEmployee("Richard");
        //UserAccount ua4 = org3.getUserAccountDirectory().createUserAccount("richard", "richard", employee4, new ServiceRole());

       // Employee employee5 = e3.getEmployeeDirectory().createEmployee("Tom");
        // UserAccount ua5 = e3.getUserAccountDirectory().createUserAccount("tom", "tom", employee5, new AdminRole());
        Organization org5 = e6.getOrganizationDirectory().createOrganization(Organization.Type.HealtheCareAdministration);
        Organization org6 = e6.getOrganizationDirectory().createOrganization(Organization.Type.SecretaryOrganization);

        org5.setOrgName("Healthcare Adminstration");
        org6.setOrgName("Secretary Department");
        GovEmployee ge = org5.getGed().createGovEmployee("Peter");
        UserAccount ua6 = org5.getUserAccountDirectory().createUserAccount();
        ua6.setGe(ge);
        ua6.setUserName("peter");
        ua6.setPassword("peter");
        ua6.setRole(new HAdminstrationRole());

        GovEmployee ge1 = org6.getGed().createGovEmployee("Cary");
        UserAccount ua9 = org6.getUserAccountDirectory().createUserAccount();
        ua9.setGe(ge1);
        ua9.setUserName("cary");
        ua9.setPassword("cary");
        ua9.setRole(new SecretaryRole());

        
        


        
        
        
        
        Organization org4 = e4.getOrganizationDirectory().createOrganization(Organization.Type.Doctor);
        org4.setOrgName("Doctor deparment");

        Doctor doctor1 = org4.getDoctorDirectory().createDoctor("Ming");
        UserAccount ua8 = org4.getUserAccountDirectory().createUserAccount();
        ua8.setDoctor(doctor1);
        ua8.setUserName("ming");
        ua8.setPassword("ming");
        ua8.setRole(new DoctorRole());

        Organization org0 = e4.getOrganizationDirectory().createOrganization(Organization.Type.Service);
        org0.setOrgName("Service Center(China)");
        Servicer s1 = org0.getServicerDirectory().createServicer("Li");
        UserAccount ua7 = org0.getUserAccountDirectory().createUserAccount();
        ua7.setServicer(s1);
        ua7.setPassword("li");
        ua7.setUserName("li");
        ua7.setRole(new ServiceRole());

        Organization org10 = e5.getOrganizationDirectory().createOrganization(Organization.Type.SecretaryOrganization);

        org10.setOrgName("Secretary Organization(China)");
        GovEmployee employee2 = org10.getGed().createGovEmployee("Hua");
        UserAccount ua11 = org10.getUserAccountDirectory().createUserAccount();
        ua11.setGe(employee2);
        ua11.setPassword("hua");
        ua11.setUserName("hua");
        ua11.setRole(new SecretaryRole());

        Organization org11 = e5.getOrganizationDirectory().createOrganization(Organization.Type.HealtheCareAdministration);
        org11.setOrgName("Health Adminstration(China)");
        GovEmployee employee3 = org11.getGed().createGovEmployee("xia");
        UserAccount ua5 = org11.getUserAccountDirectory().createUserAccount();
        ua5.setGe(employee3);
        ua5.setUserName("xia");
        ua5.setPassword("xia");
        ua5.setRole(new HAdminstrationRole());

        //Employee employee6 = org4.getEmployeeDirectory().createEmployee("Ming");
        // UserAccount ua6 = org4.getUserAccountDirectory().createUserAccount("ming", "ming", employee6, new DoctorRole());
        return ecoSystem;
    }
}
