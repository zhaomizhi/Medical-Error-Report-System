/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
       //the tyoe of parameter decides which method in super class to be called
        super(Organization.Type.Admin.getValue());
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roleList=new ArrayList<>();
        roleList.add(new AdminRole());
        return roleList;
    }
    
}
