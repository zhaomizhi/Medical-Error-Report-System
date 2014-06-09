/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RegisterReport;

import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class RegisterReportDirectory {

    private ArrayList<RegisterReport> registerReportList;

    public RegisterReportDirectory() {
        registerReportList = new ArrayList<>();
    }

    public ArrayList<RegisterReport> getRegisterReportList() {
        return registerReportList;
    }

    public void setRegisterReportList(ArrayList<RegisterReport> registerReportList) {
        this.registerReportList = registerReportList;
    }

    public RegisterReport createRegisterReport() {
        RegisterReport registerReport = new RegisterReport();
        registerReportList.add(registerReport);
        return registerReport;
    }

}
