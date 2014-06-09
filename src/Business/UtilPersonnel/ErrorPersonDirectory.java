/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UtilPersonnel;

import Business.UtilPersonnel.ErrorPerson.ErrorPersonType;
import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class ErrorPersonDirectory {

    private ArrayList<ErrorPerson> errorpersonlist;

    public ErrorPersonDirectory() {
        errorpersonlist = new ArrayList<>();
    }

    public ArrayList<ErrorPerson> getErrorpersonlist() {
        return errorpersonlist;
    }

    public void setErrorpersonlist(ArrayList<ErrorPerson> errorpersonlist) {
        this.errorpersonlist = errorpersonlist;
    }

    public ErrorPerson createPersonnel(ErrorPersonType ept) {
        if (ept.equals(ErrorPerson.ErrorPersonType.ADMINSTRATION)) {
            ErrorPerson ep = new AdminstrationErrorPerson();
            errorpersonlist.add(ep);
            return ep;

        }
        if (ept.equals(ErrorPerson.ErrorPersonType.NURESE)) {
            ErrorPerson ep = new NurseErrorPerson();
            errorpersonlist.add(ep);
            return ep;
        }
        if (ept.equals(ErrorPerson.ErrorPersonType.PATHOLOGIST)) {
            ErrorPerson ep = new PathologistriceErrorPerson();
            errorpersonlist.add(ep);
            return ep;
        }
        if (ept.equals(ErrorPerson.ErrorPersonType.PHARMACIST)) {
            ErrorPerson ep = new PharmacistErrorPerson();
            errorpersonlist.add(ep);
            return ep;
        }
        if (ept.equals(ErrorPerson.ErrorPersonType.PHYSICIAN)) {
            ErrorPerson ep = new PhysicianErrorPerson();
            errorpersonlist.add(ep);
            return ep;
        }
        if (ept.equals(ErrorPerson.ErrorPersonType.SURGEON)) {
            ErrorPerson ep = new SurgeonErrorPerson();
            errorpersonlist.add(ep);
            return ep;
        }
        return null;
    }

}
