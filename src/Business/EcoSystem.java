/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.NetWork.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class EcoSystem  extends Organization{
    private static EcoSystem ecoSystem;
    private ArrayList<Network> networkList;
    
  public static EcoSystem getInstance(){
      if(ecoSystem == null){
          ecoSystem = new EcoSystem();
      }
        return ecoSystem;
  }
  private EcoSystem(){
      super(Organization.Type.Admin.getValue());
      networkList  = new ArrayList<>();
  }

    public static EcoSystem getBusiness() {
        return ecoSystem;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.ecoSystem = business;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
  
    public Network createAndAddNetwork(){
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList <Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


