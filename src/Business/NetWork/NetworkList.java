/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.NetWork;

import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class NetworkList {
    private ArrayList<Network> networklist;
    
    public NetworkList(){
        networklist = new ArrayList<>();
    }

    public ArrayList<Network> getNetworklist() {
        return networklist;
    }

    public void setNetworklist(ArrayList<Network> networklist) {
        this.networklist = networklist;
    }
    

}
