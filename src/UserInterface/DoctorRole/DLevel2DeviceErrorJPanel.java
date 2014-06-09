/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ServiceOrganization;
import Business.UserAccount.UserAccount;
import Business.Util.Device;
import Business.Util.Location;

import Business.UtilPersonnel.ErrorPerson;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class DLevel2DeviceErrorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorReportError5JPanel
     */
    JPanel container;
    WorkRequest workRequest;
    Enterprise e;
    UserAccount ua;
     Organization o;
    EcoSystem ecoSystem;

    public DLevel2DeviceErrorJPanel(JPanel container, WorkRequest workRequest1,Enterprise e,UserAccount ua,Organization o,EcoSystem ecoSystem) {
        initComponents();
         this.container = container;
        this.workRequest = workRequest1;
        this.e = e;
        this.ua = ua;
        this.o = o;
        this.ecoSystem = ecoSystem;
        populateDevice();
        
        int progress = 100;
       jProgressBar1.setValue(progress);
        
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
    
    
    
     private void populateDevice(){
          
        devicejComboBox3.removeAllItems();
        devicejComboBox3.addItem(Device.HIT_DEVICE);
        devicejComboBox3.addItem(Device.IMPLANTABLE_DEVICE);
        devicejComboBox3.addItem(Device.MEDICALT_SURGICAL_SUPPLY);
        devicejComboBox3.addItem(Device.MEDICAL_EQUIMENT);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        devicejCheckBox1 = new javax.swing.JCheckBox();
        useerrorjCheckBox2 = new javax.swing.JCheckBox();
        combinationjCheckBox3 = new javax.swing.JCheckBox();
        unknownjCheckBox4 = new javax.swing.JCheckBox();
        devicejComboBox3 = new javax.swing.JComboBox();
        nursejCheckBox3 = new javax.swing.JCheckBox();
        surgeonjCheckBox4 = new javax.swing.JCheckBox();
        pathologistjCheckBox5 = new javax.swing.JCheckBox();
        phajCheckBox6 = new javax.swing.JCheckBox();
        adminstrationjCheckBox1 = new javax.swing.JCheckBox();
        PhysiciansjCheckBox2 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        locationjComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        devicejCheckBox1.setText("Device defect or failure");
        devicejCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devicejCheckBox1ActionPerformed(evt);
            }
        });
        add(devicejCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        useerrorjCheckBox2.setText("Use error");
        useerrorjCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useerrorjCheckBox2ActionPerformed(evt);
            }
        });
        add(useerrorjCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        combinationjCheckBox3.setText("Combination or interaction of device defect or failure and use error");
        add(combinationjCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        unknownjCheckBox4.setText("Unknown");
        unknownjCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unknownjCheckBox4ActionPerformed(evt);
            }
        });
        add(unknownjCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        devicejComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devicejComboBox3ActionPerformed(evt);
            }
        });
        add(devicejComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 422, -1));

        nursejCheckBox3.setText("Nurse");
        nursejCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nursejCheckBox3ActionPerformed(evt);
            }
        });
        add(nursejCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        surgeonjCheckBox4.setText("Surgeon");
        surgeonjCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surgeonjCheckBox4ActionPerformed(evt);
            }
        });
        add(surgeonjCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        pathologistjCheckBox5.setText("Pathologist");
        pathologistjCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathologistjCheckBox5ActionPerformed(evt);
            }
        });
        add(pathologistjCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        phajCheckBox6.setText("Pharmacist");
        phajCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phajCheckBox6ActionPerformed(evt);
            }
        });
        add(phajCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        adminstrationjCheckBox1.setText("Adminstration");
        adminstrationjCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminstrationjCheckBox1ActionPerformed(evt);
            }
        });
        add(adminstrationjCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        PhysiciansjCheckBox2.setText("Physicians");
        PhysiciansjCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhysiciansjCheckBox2ActionPerformed(evt);
            }
        });
        add(PhysiciansjCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jButton1.setText("submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, -1, -1));

        jButton2.setText("back to homepage");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));
        add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 660, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/PatientRole/Screen Shot 2013-12-10 at 6.17.30 PM.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 470, 40));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, 690, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Medical Device");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 220, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Which of of the following best describe the situcation of this event");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 600, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setText("What type of device was involved in the event or unsafe condition?");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 630, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel12.setText("Involved Personnel:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 200, -1));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 690, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel13.setText("This event occured at:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 210, -1));

        locationjComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationjComboBox1ActionPerformed(evt);
            }
        });
        add(locationjComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 210, -1));

        jLabel2.setText("(Please select related personnels)");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        jLabel6.setText("(Please select one box)");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabel7.setText("(Please select one)");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void devicejCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devicejCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_devicejCheckBox1ActionPerformed

    private void useerrorjCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useerrorjCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useerrorjCheckBox2ActionPerformed

    private void unknownjCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unknownjCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unknownjCheckBox4ActionPerformed

    private void devicejComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devicejComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_devicejComboBox3ActionPerformed

    private void nursejCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nursejCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nursejCheckBox3ActionPerformed

    private void surgeonjCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surgeonjCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surgeonjCheckBox4ActionPerformed

    private void pathologistjCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathologistjCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathologistjCheckBox5ActionPerformed

    private void phajCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phajCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phajCheckBox6ActionPerformed

    private void adminstrationjCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminstrationjCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminstrationjCheckBox1ActionPerformed

    private void PhysiciansjCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhysiciansjCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhysiciansjCheckBox2ActionPerformed

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

        
        
        
         if(devicejCheckBox1.isSelected()){
            workRequest.setDevicecause(Device.DEVICE_DEFECT_OR_FAILURE);  
        }if(useerrorjCheckBox2.isSelected()){
            workRequest.setDevicecause(Device.USER_ERROR);
        }if(unknownjCheckBox4.isSelected()){
            workRequest.setDevicecause(Device.UNKNOWN);
        }if(combinationjCheckBox3.isSelected()){
            workRequest.setDeviceerror(Device.COMBINATION);
        }
        
        
        workRequest.setLocation((String) locationjComboBox1.getSelectedItem());
        workRequest.setDeviceerror((String) devicejComboBox3.getSelectedItem());
        

        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof ServiceOrganization) {
                o.getWorkQueue().getWorkRequestList().add(workRequest);
            }
        }
        ua.getWorkQueue().getWorkRequestList().add(workRequest);
        JOptionPane.showMessageDialog(null, "The report has been submitted");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DoctorHomepageAreaJPanel doctorReportMedicationJPanel = new DoctorHomepageAreaJPanel(container, ua,o,e,ecoSystem);
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
    private javax.swing.JCheckBox combinationjCheckBox3;
    private javax.swing.JCheckBox devicejCheckBox1;
    private javax.swing.JComboBox devicejComboBox3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JComboBox locationjComboBox1;
    private javax.swing.JCheckBox nursejCheckBox3;
    private javax.swing.JCheckBox pathologistjCheckBox5;
    private javax.swing.JCheckBox phajCheckBox6;
    private javax.swing.JCheckBox surgeonjCheckBox4;
    private javax.swing.JCheckBox unknownjCheckBox4;
    private javax.swing.JCheckBox useerrorjCheckBox2;
    // End of variables declaration//GEN-END:variables
}
