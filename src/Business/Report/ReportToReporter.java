/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Report;

import Business.UtilPersonnel.ErrorPerson;

/**
 *
 * @author Aki
 */
public class ReportToReporter {

    private int maxlevel1;
    private int minimumlevel1;
    private int maxlevel2;
    private int minimumlever2;
    private ErrorPerson maxErrorPersonl;
    private int yes;
    private int no;
    private int incidentnumber;
    private int unsafenumber;
    private int nearmissnumber;
    private int firsthandsource;
    private int secondhandsource;

    private int timeofadmin;
    private int timeofnurse;
    private int timeofpathology;
    private int timeofphar;
    private int timeofphysician;
    private int timeofsurgeon;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    

    public int getTimeofadmin() {
        return timeofadmin;
    }

    public void setTimeofadmin(int timeofadmin) {
        this.timeofadmin = timeofadmin;
    }

    public int getTimeofnurse() {
        return timeofnurse;
    }

    public void setTimeofnurse(int timeofnurse) {
        this.timeofnurse = timeofnurse;
    }

    public int getTimeofpathology() {
        return timeofpathology;
    }

    public void setTimeofpathology(int timeofpathology) {
        this.timeofpathology = timeofpathology;
    }

    public int getTimeofphar() {
        return timeofphar;
    }

    public void setTimeofphar(int timeofphar) {
        this.timeofphar = timeofphar;
    }

    public int getTimeofphysician() {
        return timeofphysician;
    }

    public void setTimeofphysician(int timeofphysician) {
        this.timeofphysician = timeofphysician;
    }

    public int getTimeofsurgeon() {
        return timeofsurgeon;
    }

    public void setTimeofsurgeon(int timeofsurgeon) {
        this.timeofsurgeon = timeofsurgeon;
    }
    
    
    

    public int getFirsthandsource() {
        return firsthandsource;
    }

    public void setFirsthandsource(int firsthandsource) {
        this.firsthandsource = firsthandsource;
    }

    public int getSecondhandsource() {
        return secondhandsource;
    }

    public void setSecondhandsource(int secondhandsource) {
        this.secondhandsource = secondhandsource;
    }

    public int getIncidentnumber() {
        return incidentnumber;
    }

    public void setIncidentnumber(int incidentnumber) {
        this.incidentnumber = incidentnumber;
    }

    public int getUnsafenumber() {
        return unsafenumber;
    }

    public void setUnsafenumber(int unsafenumber) {
        this.unsafenumber = unsafenumber;
    }

    public int getNearmissnumber() {
        return nearmissnumber;
    }

    public void setNearmissnumber(int nearmissnumber) {
        this.nearmissnumber = nearmissnumber;
    }


    

    public int getMaxlevel1() {
        return maxlevel1;
    }

    public void setMaxlevel1(int maxlevel1) {
        this.maxlevel1 = maxlevel1;
    }

    public int getMinimumlevel1() {
        return minimumlevel1;
    }

    public void setMinimumlevel1(int minimumlevel1) {
        this.minimumlevel1 = minimumlevel1;
    }

    public int getMaxlevel2() {
        return maxlevel2;
    }

    public void setMaxlevel2(int maxlevel2) {
        this.maxlevel2 = maxlevel2;
    }

    public int getMinimumlever2() {
        return minimumlever2;
    }

    public void setMinimumlever2(int minimumlever2) {
        this.minimumlever2 = minimumlever2;
    }

    public ErrorPerson getMaxErrorPersonl() {
        return maxErrorPersonl;
    }

    public void setMaxErrorPersonl(ErrorPerson maxErrorPersonl) {
        this.maxErrorPersonl = maxErrorPersonl;
    }

    public int getYes() {
        return yes;
    }

    public void setYes(int yes) {
        this.yes = yes;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

}
