/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    //validate User Account
    public UserAccount validateUserAccount(String userName, String password) {
        for (UserAccount u : userAccountList) {
            if (u.getUserName().equalsIgnoreCase(userName) && u.getPassword().equalsIgnoreCase(password)) {
                return u;
            }
        }
        return null;
    }

    //create UserAccount
    public UserAccount createUserAccount() {
        UserAccount ua = new UserAccount();
        userAccountList.add(ua);
        return ua;
    }

    public UserAccount createUserAccount(String username, String password, Employee employee, Role role) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }

    public String checkExit(String name,Enterprise enterpirse) {
          for(UserAccount ua:enterpirse.getUserAccountDirectory().getUserAccountList()){
              if(ua.getUserName().equals(name)){
                  return "";             
              }
          }
        return null;
    }

    
    public String checkExit(String name,Organization org) {
          for(UserAccount ua:org.getUserAccountDirectory().getUserAccountList()){
              if(ua.getUserName().equals(name)){
                  return "";             
              }
          }
        return null;
    }     
}
