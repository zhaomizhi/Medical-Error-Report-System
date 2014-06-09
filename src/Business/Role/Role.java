/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public abstract class Role {
    
    public abstract JPanel fetchPanel(JPanel container,UserAccount ua,Organization org,Enterprise enterprise,EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
