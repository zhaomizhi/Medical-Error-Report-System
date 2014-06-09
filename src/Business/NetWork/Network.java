/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.NetWork;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Aki
 */
public class Network {
    private String name;
    private EnterpriseDirectory ed;
    //private NetworkType networkType;
    
    public Network(){
      
        ed = new EnterpriseDirectory();
    }
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEd() {
        return ed;
    }

    public void setEd(EnterpriseDirectory ed) {
        this.ed = ed;
    }
    
    
    @Override
    public String toString(){
        return name;
    }

   
    
}
