/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterfaces.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class SystemAdminRole extends Role {

    @Override
    public JPanel fetchPanel(JPanel container, UserAccount ua, Organization org,Enterprise enterprise, EcoSystem ecoSystem) {
        
        return new SystemAdminWorkAreaJPanel (container, ecoSystem);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
