/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SecretaryRole;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
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
