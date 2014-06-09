/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import Business.Util.ErrorUtil;
import Business.WorkQueue.PatientReport;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class PatientReportWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientReportWorkAreaJPanel
     */
    JPanel container;
    UserAccount ua;
    PatientOrganization patientOrganization;
    EcoSystem business;
    Enterprise e;
    PatientReport patientWorkReuqest;

    public PatientReportWorkAreaJPanel(JPanel container, UserAccount ua, PatientOrganization patientOrganization, Enterprise enterprise, EcoSystem ecoSystem,WorkRequest workRequest) {
        initComponents();
        this.container = container;
        this.ua = ua;
        this.patientOrganization = patientOrganization;
        this.e = enterprise;
        this.business = ecoSystem;
        patientWorkReuqest = (PatientReport) workRequest;
       // populatelevel1();
       
        int progrss = 50;
       jProgressBar1.setValue(progrss);
       
      // if(patientWorkReuqest instanceof PatientReport){
           idjTextField2.setText(String.valueOf(patientWorkReuqest.getId()));
       //}
      

    }

   

  /*  private void populatelevel1() {

        level1jComboBox3.removeAllItems();
        level1jComboBox3.addItem(ErrorUtil.DIAGNOS_OR_TREATMENT_ERROR);
        level1jComboBox3.addItem(ErrorUtil.SURGICAL_OR_PROCEDURE_ERROR);
        level1jComboBox3.addItem(ErrorUtil.ADVERSE_MEDICATION_EVENT);

    }

    private void populatelevel2() {
        level2jComboBox2.removeAllItems();
        String level1 = (String) level1jComboBox3.getSelectedItem();
        if (level1.equals("Diagnos or Treatment Error")) {
            level2jComboBox2.addItem(ErrorUtil.LABORATARY_OR_PATHOLOGY);
            level2jComboBox2.addItem(ErrorUtil.DELAY_IN_DIAGNOS_OR_TREATMENT);
            level2jComboBox2.addItem(ErrorUtil.MISDIAGNOS);
            level2jComboBox2.addItem(ErrorUtil.TEST_RESULT_LOST_OR_MISPLACED);
            level2jComboBox2.addItem(ErrorUtil.MEDICAL_EQUIPMENT_PROBLEM);
        }
        if (level1.equals("Surgical or Procedure Error")) {
            level2jComboBox2.addItem(ErrorUtil.POST_OPERATION_INFECTION);
            level2jComboBox2.addItem(ErrorUtil.BLOOD_LOSS);
            level2jComboBox2.addItem(ErrorUtil.WRONG_PROCEDURE);
            level2jComboBox2.addItem(ErrorUtil.COMPLICATION);
        }
        if (level1.equals("Adverse Medication Event")) {
            level2jComboBox2.addItem(ErrorUtil.WRONG_MEDICATION);
            level2jComboBox2.addItem(ErrorUtil.WRONG_DOSAGE);
            level2jComboBox2.addItem(ErrorUtil.ALLERGIC);
            level2jComboBox2.addItem(ErrorUtil.MEDICATION_SHOULD_NOT_BE_GIVEN_TOGETHER);

        }
    }

    private void createReport() {
        PatientReport patientReport = new PatientReport();
        patientReport.setMessage(addinfojTextField1.getText());
        patientReport.setSender(ua);
        patientReport.setPatientreporter(ua);
        patientReport.setStatus("Pending");
        //patientReport.setPersonnel((String) personneljComboBox2.getSelectedItem());
        patientReport.setLevel1((String) level1jComboBox3.getSelectedItem());
        patientReport.setLevel2((String) level2jComboBox2.getSelectedItem());
        patientReport.setReportdate(null);
        Date date = jDateChooser1.getDate();
        patientReport.setDateoferror(date);
        
         if (PhysiciansjCheckBox2.isSelected()) {
            ErrorPerson ep1 = patientReport.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.PHYSICIAN);
            //patientReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (nursejCheckBox3.isSelected()) {
            ErrorPerson ep1 = patientReport.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.NURESE);
            //patientReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (pathologistjCheckBox5.isSelected()) {
            ErrorPerson ep1 = patientReport.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.PATHOLOGIST);
            //patientReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (phajCheckBox6.isSelected()) {
            ErrorPerson ep1 = patientReport.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.PHARMACIST);
            //patientReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (adminstrationjCheckBox1.isSelected()) {
            ErrorPerson ep1 = patientReport.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.ADMINSTRATION);
            //patientReport.getEpd().getErrorpersonlist().add(ep1);
        }
        if (surgeonjCheckBox4.isSelected()) {
            ErrorPerson ep1 = patientReport.getEpd().createPersonnel(ErrorPerson.ErrorPersonType.SURGEON);
         //   patientReport.getEpd().getErrorpersonlist().add(ep1);
        }

        
        patientReport.setSenderEnterprise(e);
        Enterprise en= patientReport.getSenderEnterprise();
        en.getIssuesWorkRequestList().add(patientReport);
        

        
        if (firstjCheckBox1.isSelected()) {
            patientReport.setSource("first hand");
        }
        if (secondjCheckBox3.isSelected()) {
            patientReport.setSource("second hand");
        }
        try {
            patientReport.creatTime();
        } catch (ParseException ex) {
            Logger.getLogger(PatientReportWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Organization o:e.getOrganizationDirectory().getOrganizationList()){
            if(o instanceof ServiceOrganization){
                o.getWorkQueue().getWorkRequestList().add(patientReport);
            }
            
        }
        ua.getWorkQueue().getWorkRequestList().add(patientReport);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        backjButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        incidentjButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        unsafejButton4 = new javax.swing.JButton();
        nearmissjButton3 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        idjTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backjButton4.setText("<<Back");
        backjButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton4ActionPerformed(evt);
            }
        });
        add(backjButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/PatientRole/Screen Shot 2013-12-10 at 5.01.59 PM.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 190, -1));

        incidentjButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        incidentjButton2.setText("Incident");
        incidentjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incidentjButton2ActionPerformed(evt);
            }
        });
        add(incidentjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 210, 121, 40));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("A patient safety event that did not reach the patient.");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 528, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("the probability of a patient safety event.");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 720, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("A patient safety event that reached the patient,");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 85, 892, 29));

        unsafejButton4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        unsafejButton4.setText("Unsafe Condition");
        unsafejButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unsafejButton4ActionPerformed(evt);
            }
        });
        add(unsafejButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, -1, 40));

        nearmissjButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        nearmissjButton3.setText("Near Miss");
        nearmissjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nearmissjButton3ActionPerformed(evt);
            }
        });
        add(nearmissjButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 411, 121, 40));
        add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 690, -1, -1));

        idjTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idjTextField2ActionPerformed(evt);
            }
        });
        add(idjTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 80, -1));

        jLabel5.setText("Report NO.");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 80, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 262, 780, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 780, 10));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText(" whether or not the patient was harmed.");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 892, 29));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 790, 10));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/PatientRole/Screen Shot 2013-12-10 at 4.49.21 PM.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 190, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setText("Any circumstance that increases");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 720, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/PatientRole/Screen Shot 2013-12-10 at 6.17.30 PM.png"))); // NOI18N
        jLabel9.setText("Level 1");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 470, -1));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 469, 770, 10));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/PatientRole/Screen Shot 2013-12-10 at 5.05.45 PM.png"))); // NOI18N
        jLabel10.setText("Report NO.");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, 200, 130));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton4ActionPerformed
        container.remove(this);
        CardLayout cl = (CardLayout) container.getLayout();
        cl.previous(container);
    }//GEN-LAST:event_backjButton4ActionPerformed

    private void incidentjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incidentjButton2ActionPerformed
        // TODO add your handling code here:

        patientWorkReuqest.setLevel1(ErrorUtil.INCIDENT);

        Level1IncidentJPanel level1IncidentJPanel = new Level1IncidentJPanel(container, patientWorkReuqest,e,ua,patientOrganization,business);
        CardLayout cl = (CardLayout) container.getLayout();
        container.add("level1IncidentJPanel", level1IncidentJPanel);
        cl.next(container);

    }//GEN-LAST:event_incidentjButton2ActionPerformed

    private void unsafejButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unsafejButton4ActionPerformed
        // TODO add your handling code here:
        patientWorkReuqest.setLevel1(ErrorUtil.UNSAFE_CONDITION);

        Level1UnsafeJPanel doctorReportError3JPanel = new Level1UnsafeJPanel(container, patientWorkReuqest,e,ua,patientOrganization,business);
        CardLayout cl = (CardLayout) container.getLayout();
        container.add("patientReportError2Panel", doctorReportError3JPanel);
        cl.next(container);

    }//GEN-LAST:event_unsafejButton4ActionPerformed

    private void nearmissjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nearmissjButton3ActionPerformed
        // TODO add your handling code here:

        patientWorkReuqest.setLevel1(ErrorUtil.NEAR_MISS);
        Level1NearMissPanel doctorReportError3JPanel = new Level1NearMissPanel(container, patientWorkReuqest,e,ua,patientOrganization,business);
        CardLayout cl = (CardLayout) container.getLayout();
        container.add("patientReportError2Panel", doctorReportError3JPanel);
        cl.next(container);
    }//GEN-LAST:event_nearmissjButton3ActionPerformed

    private void idjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idjTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton4;
    private javax.swing.JTextField idjTextField2;
    private javax.swing.JButton incidentjButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton nearmissjButton3;
    private javax.swing.JButton unsafejButton4;
    // End of variables declaration//GEN-END:variables
}
