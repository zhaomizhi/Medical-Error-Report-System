/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.RegisterReport.RegisterReport;
import Business.UserAccount.UserAccount;
import UserInterface.AdminRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class AdminRole extends Role{
    
 

    @Override
    public JPanel fetchPanel(JPanel container, UserAccount ua, Organization org,Enterprise enterprise, EcoSystem business) {
       AdminWorkAreaJPanel adminWorkAreaJPanel=new AdminWorkAreaJPanel(container, enterprise,ua);
       return adminWorkAreaJPanel;
    }
    
}
