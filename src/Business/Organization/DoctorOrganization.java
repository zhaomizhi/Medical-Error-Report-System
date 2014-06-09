/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class DoctorOrganization extends Organization{

    public DoctorOrganization() {
        super(Organization.Type.Doctor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
      ArrayList<Role> roleList=new ArrayList<>();//To change body of generated methods, choose Tools | Templates.
      roleList.add(new DoctorRole());
      return roleList;
    }
   
}
