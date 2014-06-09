/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ServiceOrganization;
import Business.UserAccount.UserAccount;
import Business.Util.Location;
import Business.Util.Medication;
import Business.UtilPersonnel.ErrorPerson;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class Level2MedicationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Level2MedicationJPanel
     */
    
     JPanel container;
    WorkRequest workRequest;
    Enterprise e;
    UserAccount ua;
    Organization o;
    EcoSystem ecoSystem;
    public Level2MedicationJPanel(JPanel container, WorkRequest workRequest1, Enterprise e, UserAccount ua,Organization o,
            EcoSystem ecoSystem) {
        initComponents();
        this.container = container;
        this.workRequest = workRequest1;
        this.e = e;
        this.ua = ua;
          this.o = o;
        this.ecoSystem = ecoSystem;
    
        
        int progress = 100;
       jProgressBar1.setValue(progress);
        
        populateMedication();
        populateLocation();
    }
    
    
    
    private void populateLocation(){
        locationjComboBox1.removeAllItems();
        locationjComboBox1.addItem(Location.EMERGENCY);
        locationjComboBox1.addItem(Location.LABORATORY);
        locationjComboBox1.addItem(Location.OR);
        locationjComboBox1.addItem(Location.OUTPATIEN);
        locationjComboBox1.addItem(Location.PHARMACY);
        locationjComboBox1.addItem(Location.WARD);
    }
    
    private void populateMedication(){
        medicationtypejComboBox1.removeAllItems();
        medicationtypejComboBox1.addItem(Medication.BIOLOGICAL_PRODUCTS);
        medicationtypejComboBox1.addItem(Medication.CONTRAST_MEDICA);
        medicationtypejComboBox1.addItem(Medication.MEDICAL_GASES);
        medicationtypejComboBox1.addItem(Medication.MEDICATION);
        medicationtypejComboBox1.addItem(Medication.NUTRITIONAL_PRODUCTS);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        medicationtypejComboBox1 = new javax.swing.JComboBox();
        adminstrationjCheckBox1 = new javax.swing.JCheckBox();
        PhysiciansjCheckBox2 = new javax.swing.JCheckBox();
        phajCheckBox6 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        surgeonjCheckBox4 = new javax.swing.JCheckBox();
        pathologistjCheckBox5 = new javax.swing.JCheckBox();
        nursejCheckBox3 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        incorrectjCheckBox1 = new javax.swing.JCheckBox();
        unsafejCheckBox2 = new javax.swing.JCheckBox();
        adversejCheckBox3 = new javax.swing.JCheckBox();
        unknownjCheckBox4 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        locationjComboBox1 = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Medication or other substance");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 360, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("What type of medication was involved:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        add(medicationtypejComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 242, -1));

        adminstrationjCheckBox1.setText("Adminstration");
        adminstrationjCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminstrationjCheckBox1ActionPerformed(evt);
            }
        });
        add(adminstrationjCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

        PhysiciansjCheckBox2.setText("Physicians");
        PhysiciansjCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhysiciansjCheckBox2ActionPerformed(evt);
            }
        });
        add(PhysiciansjCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, -1, -1));

        phajCheckBox6.setText("Pharmacist");
        phajCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phajCheckBox6ActionPerformed(evt);
            }
        });
        add(phajCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel12.setText("Involved Personnel:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 184, -1));

        jButton1.setText("submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, -1, -1));

        surgeonjCheckBox4.setText("Surgeon");
        surgeonjCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surgeonjCheckBox4ActionPerformed(evt);
            }
        });
        add(surgeonjCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        pathologistjCheckBox5.setText("Pathologist");
        pathologistjCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathologistjCheckBox5ActionPerformed(evt);
            }
        });
        add(pathologistjCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, -1, -1));

        nursejCheckBox3.setText("Nurse");
        nursejCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nursejCheckBox3ActionPerformed(evt);
            }
        });
        add(nursejCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Which of the following best characterizes the event?");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        incorrectjCheckBox1.setText("Incorrect action");
        add(incorrectjCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        unsafejCheckBox2.setText("Unsafe condition");
        add(unsafejCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        adversejCheckBox3.setText("Adverse reaction ");
        add(adversejCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        unknownjCheckBox4.setText("Unknown");
        add(unknownjCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        jButton2.setText("back to homepage");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 150, -1));
        add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, -1, 20));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 690, -1));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 690, 10));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/PatientRole/Screen Shot 2013-12-10 at 6.17.30 PM.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 470, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel13.setText("This event occured at:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 210, -1));

        locationjComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationjComboBox1ActionPerformed(evt);
            }
        });
        add(locationjComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 210, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void adminstrationjCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminstrationjCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminstrationjCheckBox1ActionPerformed

    private void PhysiciansjCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhysiciansjCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhysiciansjCheckBox2ActionPerformed

    private void phajCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phajCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phajCheckBox6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (PhysiciansjCheckBox2.isSelected()) {
            ErrorPerson ep1 = workRequest.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.PHYSICIAN);
            // doctorReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (nursejCheckBox3.isSelected()) {
            ErrorPerson ep1 = workRequest.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.NURESE);
            //doctorReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (pathologistjCheckBox5.isSelected()) {
            ErrorPerson ep1 = workRequest.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.PATHOLOGIST);
            // doctorReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (phajCheckBox6.isSelected()) {
            ErrorPerson ep1 = workRequest.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.PHARMACIST);
            // doctorReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (adminstrationjCheckBox1.isSelected()) {
            ErrorPerson ep1 = workRequest.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.ADMINSTRATION);
            //doctorReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (surgeonjCheckBox4.isSelected()) {
            ErrorPerson ep1 = workRequest.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.SURGEON);
            // doctorReport.getEpd().getErrorpersonlist().add(ep1);
        }

       

       if(incorrectjCheckBox1.isSelected()){
           workRequest.setCharacterizesofme(Medication.INCORRECT_ACTION);      
       }if(unsafejCheckBox2.isSelected()){
           workRequest.setCharacterizesofme(Medication.UNSAFE_CONDITION);
       }if(unknownjCheckBox4.isSelected()){
           workRequest.setCharacterizesofme(Medication.UNKNOWN);
       }if(adversejCheckBox3.isSelected()){
           workRequest.setCharacterizesofme(Medication.ADVERSE_REACTION);
       }
       
       workRequest.setLocation((String) locationjComboBox1.getSelectedItem());
       workRequest.setMedicationtype((String) medicationtypejComboBox1.getSelectedItem());

        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof ServiceOrganization) {
                o.getWorkQueue().getWorkRequestList().add(workRequest);
            }
        }
        ua.getWorkQueue().getWorkRequestList().add(workRequest);
        JOptionPane.showMessageDialog(null, "The report has been submitted");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void surgeonjCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surgeonjCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surgeonjCheckBox4ActionPerformed

    private void pathologistjCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathologistjCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathologistjCheckBox5ActionPerformed

    private void nursejCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nursejCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nursejCheckBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PatientHomepageJPanel doctorReportMedicationJPanel = new PatientHomepageJPanel(container, ecoSystem,o,e,ua);
        CardLayout cl = (CardLayout) container.getLayout();
        container.add("doctorReportMedicationJPanel", doctorReportMedicationJPanel);
        cl.next(container);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void locationjComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationjComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationjComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox PhysiciansjCheckBox2;
    private javax.swing.JCheckBox adminstrationjCheckBox1;
    private javax.swing.JCheckBox adversejCheckBox3;
    private javax.swing.JCheckBox incorrectjCheckBox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JComboBox locationjComboBox1;
    private javax.swing.JComboBox medicationtypejComboBox1;
    private javax.swing.JCheckBox nursejCheckBox3;
    private javax.swing.JCheckBox pathologistjCheckBox5;
    private javax.swing.JCheckBox phajCheckBox6;
    private javax.swing.JCheckBox surgeonjCheckBox4;
    private javax.swing.JCheckBox unknownjCheckBox4;
    private javax.swing.JCheckBox unsafejCheckBox2;
    // End of variables declaration//GEN-END:variables
}
