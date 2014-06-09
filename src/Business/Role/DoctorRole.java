/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DoctorRole.DoctorHomepageAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class DoctorRole extends Role{

    @Override
    public JPanel fetchPanel(JPanel container, UserAccount ua, Organization org, Enterprise enterprise,EcoSystem business) {
            DoctorHomepageAreaJPanel doctorWorkareaJPanel=new DoctorHomepageAreaJPanel(container,ua,org,enterprise,business);
            return doctorWorkareaJPanel;
    }
    
    
}
