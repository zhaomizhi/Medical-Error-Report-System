/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaces.SecretaryRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.NetWork.Network;
import Business.Organization.HAdminstration;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.UtilPersonnel.ErrorPerson;
import Business.WorkQueue.SecretaryReport;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aki
 */
public class ViewDetialJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewDetialJPanel
     */
    JPanel container;
    WorkRequest workRequest;
    EcoSystem ecoSystem;
    UserAccount ua;
    Organization orgg;

    public ViewDetialJPanel(JPanel container, WorkRequest workRequest, EcoSystem ecoSystem1, UserAccount ua,Organization org) {
        initComponents();
        this.container = container;
        this.workRequest = workRequest;
        ecoSystem = ecoSystem1;
        this.ua = ua;
        this.orgg = org;
        populateText();
        populatePersonnel();

    }

    private void createSecretaryReport() {
        SecretaryReport secretaryReport = new SecretaryReport();
        secretaryReport.setDoctorreporter(workRequest.getDoctorreporter());
        secretaryReport.setLevel1(workRequest.getLevel1());
        secretaryReport.setLevel2(workRequest.getLevel2());
        secretaryReport.setSource(workRequest.getSource());
        secretaryReport.setEpd(workRequest.getEpd());
        //secretaryReport.setPersonnel(workRequest.getPersonnel());
        secretaryReport.setStatus("Pending");
        secretaryReport.setInvestigationresule(workRequest.getInvestigationresule());
        secretaryReport.setReportdate(workRequest.getReportdate());
        secretaryReport.setSender(ua);
        secretaryReport.setSenderEnterprise(workRequest.getSenderEnterprise());
        secretaryReport.setSatisfylevel(workRequest.getSatisfylevel());
        secretaryReport.setDateoferror(workRequest.getDateoferror());
        secretaryReport.setLocation(workRequest.getLocation());

        //at this point allow the workrequest set to sender's enterprise
        //has already done this below
        //Enterprise en = workRequest.getSenderEnterprise();
        // en.getWorkQueue().getWorkRequestList().add(secretaryReport);
        secretaryReport.setBloodstage(workRequest.getBloodstage());
        secretaryReport.setBloodtyep(workRequest.getBloodtyep());

        secretaryReport.setDevicecause(workRequest.getDevicecause());
        secretaryReport.setDeviceerror(workRequest.getDeviceerror());

        secretaryReport.setFalldoing(workRequest.getFalldoing());
        secretaryReport.setCauseoffall(workRequest.getCauseoffall());
        secretaryReport.setAssisted(workRequest.getAssisted());

        secretaryReport.setMedicationtype(workRequest.getMedicationtype());
        secretaryReport.setCharacterizesofme(workRequest.getCharacterizesofme());

        secretaryReport.setComplication(workRequest.getComplication());
        secretaryReport.setSurgeryevent(workRequest.getSurgeryevent());
        secretaryReport.setCharaofsurgery(workRequest.getCharaofsurgery());

        //this step is to add the secretaryReport to goverment adminstration organization
        //and to add the secretaryReport to the enterprise which send this report
        //this is for the Hadminstration organization to access the enterprise which send the report
        for (Network n : ecoSystem.getNetworkList()) {
            if (n.equals(workRequest.getSenderNetwork())) {
                for (Enterprise e : n.getEd().getEnterprisesList()) {
                    if (e.getEnterpriseType().equals(EnterpriseType.Government)) {
                        for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                            if (org instanceof HAdminstration) {
                                if (secretaryReport.getInvestigationresule().equals("app")) {
                                    org.getWorkQueue().getWorkRequestList().add(secretaryReport);
                                    workRequest.getSenderEnterprise().getWorkQueue().getWorkRequestList().add(secretaryReport);
                                }

                            }
                        }
                    }
                }
            }
        }

    }

    private void populateText() {

        if (workRequest.getDoctorreporter() != null) {
            namejTextField6.setText(workRequest.getDoctorreporter().getUserName());
            phonejTextField10.setText(String.valueOf(workRequest.getDoctorreporter().getDoctor().getPhone()));
            emailjTextField4.setText(workRequest.getDoctorreporter().getDoctor().getEmail());
        }

        if (workRequest.getPatientreporter() != null) {
            namejTextField6.setText(workRequest.getPatientreporter().getUserName());
            phonejTextField10.setText(String.valueOf(workRequest.getPatientreporter().getPatient().getPatientPhone()));
            emailjTextField4.setText(workRequest.getPatientreporter().getPatient().getPatientEmail());

        }
        locationjTextField1.setText(workRequest.getLocation());
        dateoferrorjTextField7.setText(workRequest.getDateoferror().toString());
        level1jTextField2.setText(workRequest.getLevel1());
        level2jTextField3.setText(workRequest.getLevel2());
        sourcejTextField1.setText(workRequest.getSource());
        if (workRequest.getSatisfylevel() != null) {
            if (workRequest.getSatisfylevel().equals("YES")) {
                satisjTextField9.setText(workRequest.getSatisfylevel());
            } else {
                satisjTextField9.setText(workRequest.getSatisfylevel());
                satisjTextField9.setForeground(Color.red);
            }

        } else {
            satisjTextField9.setText("Not evaluated");
        }

        hospitaljTextField1.setText(workRequest.getSenderEnterprise().getOrgName());

        // personneljTextField8.setText(workRequest.getPersonnel());
    }

    private void populatePersonnel() {
        DefaultTableModel model = (DefaultTableModel) personneljTable1.getModel();
        model.setRowCount(0);

        for (ErrorPerson errorPerson : workRequest.getEpd().getErrorpersonlist()) {
            Object[] row = new Object[1];
            row[0] = errorPerson;
            model.addRow(row);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        hospitaljTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        level1jTextField2 = new javax.swing.JTextField();
        level2jTextField3 = new javax.swing.JTextField();
        emailjTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        namejTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateoferrorjTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        satisjTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        phonejTextField10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        notappjButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        appjButton3 = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personneljTable1 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        sourcejTextField1 = new javax.swing.JTextField();
        locationjTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Report Detail");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 233, -1));
        add(hospitaljTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, -1));
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 122, -1, -1));

        jLabel4.setText("General error:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel5.setText("Specific error:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Report Info");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel7.setText("Hospital name:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        add(level1jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 240, -1));
        add(level2jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 240, -1));
        add(emailjTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 240, -1));

        jLabel8.setText("Username:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));
        add(namejTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 240, -1));

        jLabel9.setText("Related Personnel");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));
        add(dateoferrorjTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 190, -1));

        jLabel11.setText("Email:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, -1, -1));
        add(satisjTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 240, -1));
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, -1));

        jLabel12.setText("Satisifation:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        add(phonejTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 230, -1));

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel14.setText("Investigation");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 150, -1));

        notappjButton1.setText("NOT Applicable");
        notappjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notappjButton1ActionPerformed(evt);
            }
        });
        add(notappjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, -1, -1));

        jLabel15.setText("Phone:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, -1, -1));

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel16.setText("Contact Info");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        appjButton3.setText("Applicable and Send to Adminstration");
        appjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appjButton3ActionPerformed(evt);
            }
        });
        add(appjButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, -1, -1));

        backjButton1.setText("back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel17.setText("Result:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, -1, -1));

        personneljTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Personnel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(personneljTable1);
        if (personneljTable1.getColumnModel().getColumnCount() > 0) {
            personneljTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 190, 160));

        jLabel18.setText("Location:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jLabel19.setText("Date of Medical Error:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));
        add(sourcejTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 230, -1));
        add(locationjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 220, -1));

        jLabel20.setText("Source:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void notappjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notappjButton1ActionPerformed
        // TODO add your handling code here:
            
      
       
        
        workRequest.setInvestigationresule("notapp");

    }//GEN-LAST:event_notappjButton1ActionPerformed

    private void appjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appjButton3ActionPerformed
        // TODO add your handling code here:
        workRequest.setInvestigationresule("app");
        workRequest.setStatus("Send to Administration Dept");

        createSecretaryReport();


    }//GEN-LAST:event_appjButton3ActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout cl = (CardLayout) container.getLayout();
        cl.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appjButton3;
    private javax.swing.JButton backjButton1;
    private javax.swing.JTextField dateoferrorjTextField7;
    private javax.swing.JTextField emailjTextField4;
    private javax.swing.JTextField hospitaljTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField level1jTextField2;
    private javax.swing.JTextField level2jTextField3;
    private javax.swing.JTextField locationjTextField1;
    private javax.swing.JTextField namejTextField6;
    private javax.swing.JButton notappjButton1;
    private javax.swing.JTable personneljTable1;
    private javax.swing.JTextField phonejTextField10;
    private javax.swing.JTextField satisjTextField9;
    private javax.swing.JTextField sourcejTextField1;
    // End of variables declaration//GEN-END:variables
}
