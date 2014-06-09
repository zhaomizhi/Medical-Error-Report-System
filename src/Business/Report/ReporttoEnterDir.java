/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Report;

import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class ReporttoEnterDir {
    
    private ArrayList<ReporttoEnter> ReporttoEnterList;

    public ReporttoEnterDir() {
        ReporttoEnterList = new ArrayList<>();
    }

    public ArrayList<ReporttoEnter> getReporttoEnterList() {
        return ReporttoEnterList;
    }

    public void setReporttoEnterList(ArrayList<ReporttoEnter> ReporttoEnterList) {
        this.ReporttoEnterList = ReporttoEnterList;
    }

    
    
    

    public ReporttoEnter createReporttoEnter() {
        ReporttoEnter e = new ReporttoEnter();
       
        ReporttoEnterList.add(e);
        return e;
    }
    
    
    
    
}
