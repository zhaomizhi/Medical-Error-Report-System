/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminRole;

import Business.Doctor.Doctor;
import Business.GovEmployee.GovEmployee;
import Business.Organization.DoctorOrganization;
import Business.Organization.HAdminstration;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.PatientOrganization;
import Business.Organization.SecretaryOrganization;
import Business.Organization.ServiceOrganization;
import Business.Patient.Patient;
import Business.Role.Role;
import Business.Servicer.Servicer;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aki
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    JPanel container;
    OrganizationDirectory organizationDirectory;

    public ManageUserAccountJPanel(JPanel container, OrganizationDirectory organizationDirectory) {
        initComponents();
        this.container = container;
        this.organizationDirectory = organizationDirectory;
        populateOrganization();
    }

    private void populateTable() {
        Organization org = (Organization) organizationjComboBox1.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
            Object[] row = new Object[2];
            row[0] = ua.getUserName();
            row[1] = ua.getRole();
            model.addRow(row);
        }
    }

    private void populateOrganization() {
        organizationjComboBox1.removeAllItems();
        for (Organization org : organizationDirectory.getOrganizationList()) {

            organizationjComboBox1.addItem(org);
        }

    }

    private void populateEmployee() {
        personjComboBox2.removeAllItems();
        Organization org = (Organization) organizationjComboBox1.getSelectedItem();

        if (org instanceof DoctorOrganization) {
            for (Doctor d : org.getDoctorDirectory().getDoctorList()) {
                personjComboBox2.addItem(d);
            }
        }
        if (org instanceof PatientOrganization) {
            for (Patient patient : org.getPatientDirectory().getPatientList()) {
                personjComboBox2.addItem(patient);
            }
        }
        if (org instanceof ServiceOrganization) {
            for (Servicer servicer : org.getServicerDirectory().getServicerList()) {
                personjComboBox2.addItem(servicer);
            }
        }
        if (org instanceof SecretaryOrganization || org instanceof HAdminstration) {
            for (GovEmployee govEmployee : org.getGed().getGovEmployeeList()) {
                personjComboBox2.addItem(govEmployee);
            }
        }
        // else {
        //   for (Employee e : org.getEmployeeDirectory().getEmployeeList()) {
        //     jComboBox2.addItem(e);
        //}

    }

    private void populateRoles() {
        rolejComboBox3.removeAllItems();
        Organization org = (Organization) organizationjComboBox1.getSelectedItem();
        for (Role rolo : org.getSupportedRoles()) {
            rolejComboBox3.addItem(rolo);
        }
    }

    private void createUserAccount() {
        Organization org = (Organization) organizationjComboBox1.getSelectedItem();

        if (org.getUserAccountDirectory().checkExit(jTextField1.getText(), org) == null) {
            UserAccount ua = org.getUserAccountDirectory().createUserAccount();
            ua.setUserName(jTextField1.getText());
            ua.setPassword(jTextField2.getText());
            if (org instanceof DoctorOrganization) {
                // if(org.getUserAccountDirectory().checkExit(jTextField1.getText(), org)==null){
                ua.setDoctor((Doctor) personjComboBox2.getSelectedItem());
                ua.setRole((Role) rolejComboBox3.getSelectedItem());
                populateTable();
                //}else{
                //    JOptionPane.showMessageDialog(null, "Sorry, this usename has already exist");
                //  }
            }
            if (org instanceof PatientOrganization) {
                ua.setPatient((Patient) personjComboBox2.getSelectedItem());
                ua.setRole((Role) rolejComboBox3.getSelectedItem());
                populateTable();
            }
            if (org instanceof ServiceOrganization) {
                ua.setServicer((Servicer) personjComboBox2.getSelectedItem());
                ua.setRole((Role) rolejComboBox3.getSelectedItem());
                populateTable();
            }
            if (org instanceof SecretaryOrganization || org instanceof HAdminstration) {
                ua.setGe((GovEmployee) personjComboBox2.getSelectedItem());
                ua.setRole((Role) rolejComboBox3.getSelectedItem());
                populateTable();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sorry, this usename has already exist");
        }

//else {
        //    ua.setEmployee((Employee) jComboBox2.getSelectedItem());
        //    ua.setRole((Role) jComboBox3.getSelectedItem());
        //    populateTable();
        //}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        organizationjComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        personjComboBox2 = new javax.swing.JComboBox();
        rolejComboBox3 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Role"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 35, 540, 194));

        organizationjComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationjComboBox1ActionPerformed(evt);
            }
        });
        add(organizationjComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 247, 210, -1));

        jLabel1.setText("Organization:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 251, 171, -1));

        jLabel2.setText("Person:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 314, 171, -1));

        add(personjComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 310, 210, -1));

        add(rolejComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 376, 210, -1));

        jLabel3.setText("Role:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 387, 60, -1));

        jLabel4.setText("User Name");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 433, -1, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 433, 210, -1));

        jLabel5.setText("Password:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 486, -1, -1));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 486, 210, -1));

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void organizationjComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationjComboBox1ActionPerformed
        populateEmployee();
        populateRoles();
        populateTable();
    }//GEN-LAST:event_organizationjComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createUserAccount();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        container.remove(this);
        CardLayout cl = (CardLayout) container.getLayout();
        cl.previous(container);
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox organizationjComboBox1;
    private javax.swing.JComboBox personjComboBox2;
    private javax.swing.JComboBox rolejComboBox3;
    // End of variables declaration//GEN-END:variables
}
