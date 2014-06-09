/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aki
 */
public class ReporttoEnter {
    
    private String respond;
    private String level2;
    private String textDate;
    
    
    private String mostLocation;
    private int maxofperson;
   
    private String errorperonstring;
    

    //BLOOD
    private String bloodtype;
    private String bloodstage;
    
    //DEVICE
    private String devicecause;
    private String devicetype;
    
    //FALL
    private String assistedornot;
    private String falldoing;
    private String falloutcome;
    
    //MEDICATION
    private String medtype;
    private String meddescrip;

    //SURGERY
    private String surgtype;
    private String surdescrip;
    private String surCom;

    public String getMostLocation() {
        return mostLocation;
    }

    public void setMostLocation(String mostLocation) {
        this.mostLocation = mostLocation;
    }

    
    
    
    public String getSurgtype() {
        return surgtype;
    }

    public void setSurgtype(String surgtype) {
        this.surgtype = surgtype;
    }

    public String getSurdescrip() {
        return surdescrip;
    }

    public void setSurdescrip(String surdescrip) {
        this.surdescrip = surdescrip;
    }

    public String getSurCom() {
        return surCom;
    }

    public void setSurCom(String surCom) {
        this.surCom = surCom;
    }
    
    
    
    
    public String getMedtype() {
        return medtype;
    }

    public void setMedtype(String medtype) {
        this.medtype = medtype;
    }

    public String getMeddescrip() {
        return meddescrip;
    }

    public void setMeddescrip(String meddescrip) {
        this.meddescrip = meddescrip;
    }
    
    
    
    
    private int second;
    private int first;

    public String getAssistedornot() {
        return assistedornot;
    }

    public void setAssistedornot(String assistedornot) {
        this.assistedornot = assistedornot;
    }

    public String getFalldoing() {
        return falldoing;
    }

    public void setFalldoing(String falldoing) {
        this.falldoing = falldoing;
    }

    public String getFalloutcome() {
        return falloutcome;
    }

    public void setFalloutcome(String falloutcome) {
        this.falloutcome = falloutcome;
    }


    

    public String getTextDate() {
        return textDate;
    }

    public void setTextDate(String textDate) {
        this.textDate = textDate;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public String getDevicecause() {
        return devicecause;
    }

    public void setDevicecause(String devicecause) {
        this.devicecause = devicecause;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }
    

    
    

    public String getErrorperonstring() {
        return errorperonstring;
    }

    public void setErrorperonstring(String errorperonstring) {
        this.errorperonstring = errorperonstring;
    }

    
    
    public String getRespond() {
        return respond;
    }

    
    public void setRespond(String respond) {
        this.respond = respond;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public int getMaxofperson() {
        return maxofperson;
    }

    public void setMaxofperson(int maxofperson) {
        this.maxofperson = maxofperson;
    }

   
    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getBloodstage() {
        return bloodstage;
    }

    public void setBloodstage(String bloodstage) {
        this.bloodstage = bloodstage;
    }

   
    
    
    
      public void creatTime()throws ParseException{
         Date currentDate = new Date();
         
         textDate= new SimpleDateFormat("dd/MM/yyyy/HH/mm").format(currentDate);
     }
      
      
      
     @Override
    public String toString(){
    return String.valueOf(textDate);   
   }
     
    
    
    
    
}
