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
import UserInterfaces.SecretaryRole.SecretaryWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class SecretaryRole extends Role{

    @Override
    public JPanel fetchPanel(JPanel container, UserAccount ua, Organization org, Enterprise enterprise, EcoSystem business) {
          
        SecretaryWorkAreaJPanel secretaryJPanel = new SecretaryWorkAreaJPanel(container,enterprise,business,ua,org);
        return secretaryJPanel;
          //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
