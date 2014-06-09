/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class OrganizationDirectory {

    ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public Organization createOrganization(Type type) {
        if (type.equals(Organization.Type.Admin)) {   //Dynamic binding
            Organization org = new AdminOrganization();
            organizationList.add(org);
            return org;
        }
        if (type.equals(Organization.Type.Doctor)) {
            Organization org = new DoctorOrganization();
            organizationList.add(org);
            return org;
        }
       
        
         if (type.equals(Organization.Type.Service)) {
            Organization org = new ServiceOrganization();
            organizationList.add(org);
            return org;
        }
        if (type.equals(Organization.Type.Patient)) {
            Organization org = new PatientOrganization();
            organizationList.add(org);
            return org;
        }if(type.equals(Organization.Type.HealtheCareAdministration)){
            Organization org = new HAdminstration();
            organizationList.add(org);
            return org;
        }
        if(type.equals(Organization.Type.SecretaryOrganization)){
            Organization o = new SecretaryOrganization();
            organizationList.add(o);
            return o;  
        }
        return null;
    }
}
