/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.GovEmployee;

import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class GovEmployeeDirectory {
    
    private ArrayList<GovEmployee>govEmployeeList;
    
    public GovEmployeeDirectory(){
        govEmployeeList = new ArrayList();
    }

    public ArrayList<GovEmployee> getGovEmployeeList() {
        return govEmployeeList;
    }

    public void setGovEmployeeList(ArrayList<GovEmployee> GovEmployeeList) {
        this.govEmployeeList = GovEmployeeList;
    }
    
    public GovEmployee createGovEmployee(String name){
        GovEmployee  ge = new GovEmployee();
        ge.setName(name);
        govEmployeeList.add(ge);
        return ge;
    }
    
}
