/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.HAdminstrationRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class HAdminstration extends Organization {
    
     public HAdminstration() {
        super(Organization.Type.HealtheCareAdministration.getValue());
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roleList=new ArrayList<>();
      //因为每一个organization里面可以有很多个role，所以在这里给每一个organization里面加一个role
        roleList.add(new HAdminstrationRole());
        return roleList;
    }
}
