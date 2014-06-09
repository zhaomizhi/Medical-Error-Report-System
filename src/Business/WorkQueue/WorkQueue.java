/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class WorkQueue {

    ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void setWorkRequestList(ArrayList<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }

    public void removeWorkQuest(WorkRequest w) {
        workRequestList.remove(w);

    }

    public WorkRequest searchByID(int id, UserAccount ua, Organization organization) {

        if (organization instanceof DoctorOrganization) {
            for (WorkRequest workRequest : ua.getWorkQueue().getWorkRequestList()) {
                if (((DoctorReport) workRequest).getId() == id) {
                    return workRequest;
                }
            }
        }
        if (organization instanceof PatientOrganization) {
            for (WorkRequest workRequest : ua.getWorkQueue().getWorkRequestList()) {
                if (((PatientReport) workRequest).getId() == id) {
                    return workRequest;
                }
            }
        }
        return null;
    }

}
