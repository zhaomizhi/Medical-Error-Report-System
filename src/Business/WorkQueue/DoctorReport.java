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
public class DoctorReport extends WorkRequest{
    private String test;
    private int id;
    private static int count = 1;

    public DoctorReport(){
         id = count;
        count++;
    }
            

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
