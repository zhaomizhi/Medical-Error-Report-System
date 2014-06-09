/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterfaces.HAdministration.HealthAdministrationWorkAreajPanel;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class HAdminstrationRole extends Role{

    @Override
    public JPanel fetchPanel(JPanel container, UserAccount ua, Organization org, Enterprise enterprise, EcoSystem business) {
     HealthAdministrationWorkAreajPanel hap=new HealthAdministrationWorkAreajPanel(container,ua,org,enterprise,business);
            return hap;
       // return null;
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
