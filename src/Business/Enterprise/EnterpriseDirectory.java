/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Aki
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterprisesList;

    public EnterpriseDirectory() {
        enterprisesList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterprisesList() {
        return enterprisesList;
    }

    public void setEnterprisesList(ArrayList<Enterprise> enterprisesList) {
        this.enterprisesList = enterprisesList;
    }

    public Enterprise createEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Clinic) {
            enterprise = new ClinicEnterprise(name);
            enterprisesList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.Hospital) {
            enterprise = new HospitalEnterprise(name);
            enterprisesList.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.Government) {
            enterprise = new GovernmentEnterprise(name);
            enterprisesList.add(enterprise);
        }

        return enterprise;
    }
}
