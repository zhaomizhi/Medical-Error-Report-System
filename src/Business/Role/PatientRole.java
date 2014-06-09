/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.PatientRole.PatientHomepageJPanel;

import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class PatientRole extends Role{

    @Override
    public JPanel fetchPanel(JPanel container, UserAccount ua, Organization org, Enterprise enterprise, EcoSystem business) {
   //return new DoctorHomepageAreaJPanel(container, ua, org, enterprise, business);
return new PatientHomepageJPanel (container,business,org,enterprise,ua);
    }
    
    
}
