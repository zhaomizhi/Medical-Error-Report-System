/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.ServiceRole;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class ServiceOrganization extends Organization{
 
    public ServiceOrganization() {
        super(Organization.Type.Service.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
     ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new ServiceRole());
        return roleList;
        
        
        //return null;// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
