/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

/**
 *
 * @author Aki
 */
public class PatientReport extends WorkRequest{
    
     private int id;
    private static int count = 1;
    
    public PatientReport(){
          id = count;
        count++;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
