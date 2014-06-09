
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.NetWork.Network;
import Business.UserAccount.UserAccount;
import Business.UtilPersonnel.ErrorPersonDirectory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aki
 */
public abstract class WorkRequest {

    private String message;
    private String respond;
    private UserAccount sender;
    private UserAccount receiver;
    private UserAccount Doctorreporter;
    private UserAccount Patientreporter;
    private String status;
    private String reportdate;
    private String level1;
    private String level2;
    private Enterprise senderEnterprise;
    private Network senderNetwork;
    private String source;
    private String satisfylevel;
    private String location;

    private String investigationresule;
    private ErrorPersonDirectory epd;
    private Date dateoferror;

    private String bloodtyep;
    private String bloodstage;

    private String devicecause;
    private String deviceerror;

    private String falldoing;
    private String assisted;
    private String causeoffall;

    private String medicationtype;
    private String characterizesofme;

    private String surgeryevent;
    private String complication;
    private String charaofsurgery;
    

    //private int id;
    //private static int count = 1;

    public WorkRequest() {
        epd = new ErrorPersonDirectory();
       // id = count;
       // count++;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSurgeryevent() {
        return surgeryevent;
    }

    public void setSurgeryevent(String surgeryevent) {
        this.surgeryevent = surgeryevent;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getCharaofsurgery() {
        return charaofsurgery;
    }

    public void setCharaofsurgery(String charaofsurgery) {
        this.charaofsurgery = charaofsurgery;
    }

    public String getMedicationtype() {
        return medicationtype;
    }

    public void setMedicationtype(String medicationtype) {
        this.medicationtype = medicationtype;
    }

    public String getCharacterizesofme() {
        return characterizesofme;
    }

    public void setCharacterizesofme(String characterizesofme) {
        this.characterizesofme = characterizesofme;
    }

    public String getCauseoffall() {
        return causeoffall;
    }

    public void setCauseoffall(String causeoffall) {
        this.causeoffall = causeoffall;
    }

    public String getFalldoing() {
        return falldoing;
    }

    public void setFalldoing(String falldoing) {
        this.falldoing = falldoing;
    }

    public String getAssisted() {
        return assisted;
    }

    public void setAssisted(String assisted) {
        this.assisted = assisted;
    }

    public String getDevicecause() {
        return devicecause;
    }

    public void setDevicecause(String devicecause) {
        this.devicecause = devicecause;
    }


    public String getBloodstage() {
        return bloodstage;
    }

    public void setBloodstage(String bloodstage) {
        this.bloodstage = bloodstage;
    }

    public String getBloodtyep() {
        return bloodtyep;
    }

    public void setBloodtyep(String bloodtyep) {
        this.bloodtyep = bloodtyep;
    }

    public String getDeviceerror() {
        return deviceerror;
    }

    public void setDeviceerror(String deviceerror) {
        this.deviceerror = deviceerror;
    }

    public Date getDateoferror() {
        return dateoferror;
    }

    public void setDateoferror(Date dateoferror) {
        this.dateoferror = dateoferror;
    }

  /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
*/
    public ErrorPersonDirectory getEpd() {
        return epd;
    }

    public void setEpd(ErrorPersonDirectory epd) {
        this.epd = epd;
    }

    public UserAccount getPatientreporter() {
        return Patientreporter;
    }

    public void setPatientreporter(UserAccount Patientreporter) {
        this.Patientreporter = Patientreporter;
    }

    public Network getSenderNetwork() {
        return senderNetwork;
    }

    public void setSenderNetwork(Network senderNetwork) {
        this.senderNetwork = senderNetwork;
    }

    public String getInvestigationresule() {
        return investigationresule;
    }

    public void setInvestigationresule(String investigationresule) {
        this.investigationresule = investigationresule;
    }

    public UserAccount getDoctorreporter() {
        return Doctorreporter;
    }

    public void setDoctorreporter(UserAccount Doctorreporter) {
        this.Doctorreporter = Doctorreporter;
    }

    public String getSatisfylevel() {
        return satisfylevel;
    }

    public void setSatisfylevel(String satisfylevel) {
        this.satisfylevel = satisfylevel;
    }

    //private Organization senderOrganization;
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Enterprise getSenderEnterprise() {
        return senderEnterprise;
    }

    public void setSenderEnterprise(Enterprise senderEnterprise) {
        this.senderEnterprise = senderEnterprise;

    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getRespond() {
        return respond;
    }

    public void setRespond(String respond) {
        this.respond = respond;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // @Override
    //public String toString() {
    //  return  message ;
    //}
    public void creatTime() throws ParseException {
        Date currentDate = new Date();

        reportdate = new SimpleDateFormat("dd/MM/yyyy/HH/mm").format(currentDate);
    }

    public String getReportdate() {
        return reportdate;
    }

    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }

    @Override
    public String toString() {
        return String.valueOf(reportdate);
    }

}
