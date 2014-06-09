/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterfaces.Service.ServiceCenterWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class ServiceRole extends Role{

    @Override
    public JPanel fetchPanel(JPanel container, UserAccount ua, Organization org, Enterprise enterprise, EcoSystem ecoSystem) {
       return new ServiceCenterWorkAreaJPanel (container, ecoSystem,org,enterprise,ua);
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
