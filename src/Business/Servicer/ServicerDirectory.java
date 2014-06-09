/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Servicer;

import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class ServicerDirectory {
    
    private ArrayList<Servicer> servicerList;
        
    public ServicerDirectory(){
          servicerList = new ArrayList<>();
}

    public ArrayList<Servicer> getServicerList() {
        return servicerList;
    }

    public void setServicerList(ArrayList<Servicer> servicerList) {
        this.servicerList = servicerList;
    }
   
    public Servicer createServicer(String name){
        Servicer servicer = new Servicer();
        servicer.setName(name);
        servicerList.add(servicer);
        return servicer;
        
    }
           
}
