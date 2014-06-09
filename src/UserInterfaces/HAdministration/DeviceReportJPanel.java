/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaces.HAdministration;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ServiceOrganization;
import Business.Report.ReporttoEnter;
import Business.Util.Device;

import Business.Util.ErrorUtil;
import Business.Util.Location;
import Business.Util.Source;
import Business.UtilPersonnel.AdminstrationErrorPerson;
import Business.UtilPersonnel.ErrorPerson;
import Business.UtilPersonnel.NurseErrorPerson;
import Business.UtilPersonnel.PathologistriceErrorPerson;
import Business.UtilPersonnel.PharmacistErrorPerson;
import Business.UtilPersonnel.PhysicianErrorPerson;
import Business.UtilPersonnel.SurgeonErrorPerson;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Aki
 */
public class DeviceReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DeviceReportJPanel
     */
    JPanel container;
    Enterprise enterprise;
    
    public DeviceReportJPanel(JPanel container, Enterprise enterprise1) {
        initComponents();
        this.container = container;
        enterprise = enterprise1;
        namejTextField2.setText(enterprise1.getOrgName());
        populateSource();
        populateTbale();
        populateCause();
        populateDevice();
        populateMostIssuedLocation();
        populateMostIssuedPersonnel();
        
        
    }
    
    
    
    private void populateMostIssuedPersonnel() {

        int timeofadmin = 0;
        int timeofnurse = 0;
        int timeofpathology = 0;
        int timeofphar = 0;
        int timeofphysician = 0;
        int timeofsurgeon = 0;

        int i;
        int max = 0;

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.DEVICE_OR_MEDICAL)) {
                for (ErrorPerson ep : workRequest.getEpd().getErrorpersonlist()) {
                    if (ep instanceof AdminstrationErrorPerson) {
                        // if (ep.getEpt().getValue().equals(ErrorPerson.ErrorPersonType.ADMINSTRATION.getValue())) {
                        timeofadmin = timeofadmin + 1;
                    }
                    if (ep instanceof NurseErrorPerson) {
                        timeofnurse = timeofnurse + 1;
                    }
                    if (ep instanceof PathologistriceErrorPerson) {
                        timeofpathology = timeofpathology + 1;
                    }
                    if (ep instanceof PharmacistErrorPerson) {
                        timeofphar = timeofphar + 1;
                    }
                    if (ep instanceof PhysicianErrorPerson) {
                        timeofphysician = timeofphysician + 1;
                    }
                    if (ep instanceof SurgeonErrorPerson) {
                        timeofsurgeon = timeofsurgeon + 1;
                    }

                }
            }
        }

        int[] numbs;
        numbs = new int[6];
        numbs[0] = timeofadmin;
        numbs[1] = timeofnurse;
        numbs[2] = timeofpathology;
        numbs[3] = timeofphar;
        numbs[4] = timeofphysician;
        numbs[5] = timeofsurgeon;

        for (i = 0; i < 6; i++) {
            if (max < numbs[i]) {
                max = numbs[i];

                timejTextField2.setText(String.valueOf(max));

                switch (i) {
                    case 0:
                        personneljTextField1.setText(ErrorPerson.ErrorPersonType.ADMINSTRATION.toString());
                        break;
                    case 1:
                        personneljTextField1.setText(ErrorPerson.ErrorPersonType.NURESE.toString());
                        break;
                    case 2:
                        personneljTextField1.setText(ErrorPerson.ErrorPersonType.PATHOLOGIST.toString());
                        break;
                    case 3:
                        personneljTextField1.setText(ErrorPerson.ErrorPersonType.PHARMACIST.toString());
                        break;
                    case 4:
                        personneljTextField1.setText(ErrorPerson.ErrorPersonType.PHYSICIAN.toString());
                        break;
                    case 5:
                        personneljTextField1.setText(ErrorPerson.ErrorPersonType.SURGEON.toString());
                        break;
                }

            }
        }
    }
    
    
    
     private void populateMostIssuedLocation() {
        int timeofem = 0;
        int timeofpha = 0;
        int timeofward = 0;
        int timeofor = 0;
        int timeoflab = 0;
        int timeofoutpatient = 0;

        int i;
        int max = 0;

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.DEVICE_OR_MEDICAL)) {
                if (workRequest.getLocation().equals(Location.EMERGENCY)) {
                    timeofem = timeofem + 1;
                }
                if (workRequest.getLocation().equals(Location.LABORATORY)) {
                    timeoflab = timeoflab + 1;
                }
                if (workRequest.getLocation().equals(Location.OR)) {
                    timeofor = timeofor + 1;
                }
                if (workRequest.getLocation().equals(Location.OUTPATIEN)) {
                    timeofoutpatient = timeofoutpatient + 1;
                }
                if (workRequest.getLocation().equals(Location.PHARMACY)) {
                    timeofpha = timeofpha + 1;
                }
                if (workRequest.getLocation().equals(Location.WARD)) {
                    timeofward = timeofward + 1;
                }

            }
        }

        int[] numbs;
        numbs = new int[6];
        numbs[0] = timeofem;
        numbs[1] = timeoflab;
        numbs[2] = timeofor;
        numbs[3] = timeofoutpatient;
        numbs[4] = timeofpha;
        numbs[5] = timeofward;

        for (i = 0; i < 6; i++) {
            if (max < numbs[i]) {
                max = numbs[i];

//  locationjTextField1.setText(String.valueOf(max));
                switch (i) {
                    case 0:
                        locationjTextField1.setText(Location.EMERGENCY);
                        break;
                    case 1:
                        locationjTextField1.setText(Location.LABORATORY);
                        break;
                    case 2:
                        locationjTextField1.setText(Location.OR);
                        break;
                    case 3:
                        locationjTextField1.setText(Location.OUTPATIEN);
                        break;
                    case 4:
                        locationjTextField1.setText(Location.PHARMACY);
                        break;
                    case 5:
                        locationjTextField1.setText(Location.WARD);
                        break;
                }

            }
        }
    }
    
    
    
    
    private void populateDevice() {
        int hit = 0;
        int imp = 0;
        int surg = 0;
        int medical = 0;
        
        int i;
        int max = 0;
        
        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.DEVICE_OR_MEDICAL)) {
                if (workRequest.getDeviceerror().equals(Device.HIT_DEVICE)) {
                    hit = hit + 1;
                }
                if (workRequest.getDeviceerror().equals(Device.IMPLANTABLE_DEVICE)) {
                    imp = imp + 1;
                }
                if (workRequest.getDeviceerror().equals(Device.MEDICALT_SURGICAL_SUPPLY)) {
                    surg = surg + 1;
                }
                if (workRequest.getDeviceerror().equals(Device.MEDICAL_EQUIMENT)) {
                    medical = medical + 1;
                }
                
            }
        }
        
        int[] numbs;
        numbs = new int[4];
        numbs[0] = hit;
        numbs[1] = imp;
        numbs[2] = surg;
        numbs[3] = medical;
        
        for (i = 0; i < 4; i++) {
            if (max < numbs[i]) {
                max = numbs[i];
                
                switch (i) {
                    case 0:
                        typejTextField2.setText(Device.HIT_DEVICE);
                        break;
                    case 1:
                        typejTextField2.setText(Device.IMPLANTABLE_DEVICE);
                        break;
                    case 2:
                        typejTextField2.setText(Device.MEDICALT_SURGICAL_SUPPLY);
                        break;
                    case 3:
                        typejTextField2.setText(Device.MEDICAL_EQUIMENT);
                        break;
                }
                
            }
        }
    }
    
    private void populateCause() {
        int device = 0;
        int user = 0;
        int com = 0;
        int unknown = 0;
        
        int i;
        int max = 0;
        
        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.DEVICE_OR_MEDICAL)) {
                if (workRequest.getDevicecause().equals(Device.DEVICE_DEFECT_OR_FAILURE)) {
                    device = device + 1;
                }
                if (workRequest.getDevicecause().equals(Device.USER_ERROR)) {
                    user = user + 1;
                }
                if (workRequest.getDevicecause().equals(Device.UNKNOWN)) {
                    unknown = unknown + 1;
                }
                if (workRequest.getDevicecause().equals(Device.COMBINATION)) {
                    com = com + 1;
                }
            }
        }
        
        int[] numbs;
        numbs = new int[4];
        numbs[0] = device;
        numbs[1] = user;
        numbs[2] = com;
        numbs[3] = unknown;
        
        for (i = 0; i < 4; i++) {
            if (max < numbs[i]) {
                max = numbs[i];
                
                switch (i) {
                    case 0:
                        causejTextField1.setText(Device.DEVICE_DEFECT_OR_FAILURE);
                        break;
                    case 1:
                        causejTextField1.setText(Device.USER_ERROR);
                        break;
                    case 2:
                        causejTextField1.setText(Device.COMBINATION);
                        break;
                    case 3:
                        causejTextField1.setText(Device.UNKNOWN);
                        break;
                }
                
            }
        }
        
    }
    
    private void populateSource() {
        int firstsourcenumber = 0;
        int secondsourcenumber = 0;
        
        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.DEVICE_OR_MEDICAL)) {
                if (w.getSource().equals(Source.FIRST)) {
                    firstsourcenumber = firstsourcenumber + 1;
                }
                if (w.getSource().equals(Source.SECOND)) {
                    secondsourcenumber = secondsourcenumber + 1;
                }
                fjTextField2.setText(String.valueOf(firstsourcenumber));
                sjTextField3.setText(String.valueOf(secondsourcenumber));
                
            }
        }
    }
    
    private void populateTbale() {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.DEVICE_OR_MEDICAL)) {
                Object[] row = new Object[4];
                row[0] = w.getReportdate();
                row[1] = w.getDevicecause();
                row[2] = w.getDeviceerror();
                row[3] = w.getSource();
                model.addRow(row);
            }
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

        jLabel3 = new javax.swing.JLabel();
        namejTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        fjTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sjTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        causejTextField1 = new javax.swing.JTextField();
        typejTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        personneljTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        personneljButton2 = new javax.swing.JButton();
        timejTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        respongTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        locationjTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Device or Medical Supply");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 249, -1));
        add(namejTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 180, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Report List of");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date of event", "Reason of Event ", "Type of device", "Source"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 680, 220));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Source:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));
        add(fjTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 80, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("First");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, -1, -1));
        add(sjTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 90, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Second");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, 20));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 494, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("This type of device is reported most frequently:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));
        add(causejTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 180, -1));
        add(typejTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 190, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("This cause of device error event is reported most frequently:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));
        add(personneljTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 160, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("This knid of Personnel is reported most frequently:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        personneljButton2.setText("View Chart");
        personneljButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personneljButton2ActionPerformed(evt);
            }
        });
        add(personneljButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 610, -1, -1));
        add(timejTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, 120, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setText("Times:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 610, -1, -1));

        respongTextArea1.setColumns(20);
        respongTextArea1.setRows(5);
        jScrollPane2.setViewportView(respongTextArea1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 440, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Write below:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, -1, -1));

        jButton1.setText("Send Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 650, -1, -1));

        jButton4.setText("<<Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jButton2.setText("View Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 660, -1, -1));
        add(locationjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 200, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setText("This kind of event most likely occure ar:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 330, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void personneljButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personneljButton2ActionPerformed
        // TODO add your handling code here:

        int timeofadmin = 0;
        int timeofnurse = 0;
        int timeofpathology = 0;
        int timeofphar = 0;
        int timeofphysician = 0;
        int timeofsurgeon = 0;
        
        int i;
        int max = 0;
        
        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.DEVICE_OR_MEDICAL)) {
                for (ErrorPerson ep : workRequest.getEpd().getErrorpersonlist()) {
                    if (ep instanceof AdminstrationErrorPerson) {
                        // if (ep.getEpt().getValue().equals(ErrorPerson.ErrorPersonType.ADMINSTRATION.getValue())) {
                        timeofadmin = timeofadmin + 1;
                    }
                    if (ep instanceof NurseErrorPerson) {
                        timeofnurse = timeofnurse + 1;
                    }
                    if (ep instanceof PathologistriceErrorPerson) {
                        timeofpathology = timeofpathology + 1;
                    }
                    if (ep instanceof PharmacistErrorPerson) {
                        timeofphar = timeofphar + 1;
                    }
                    if (ep instanceof PhysicianErrorPerson) {
                        timeofphysician = timeofphysician + 1;
                    }
                    if (ep instanceof SurgeonErrorPerson) {
                        timeofsurgeon = timeofsurgeon + 1;
                    }
                    
                }
            }
        }
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(timeofadmin, "Adminstration", "Adminstration");
        dataset.addValue(timeofnurse, "Nurse", "Nurse");
        dataset.addValue(timeofpathology, "Pathologist", "Pathologist");
        dataset.addValue(timeofphar, "Pharmacist", "Pharmacist");
        dataset.addValue(timeofphysician, "Physician", "Physician");
        dataset.addValue(timeofsurgeon, "Surgeon", "Surgeon");
        //dataset.setValue(80, "masd", "sss");

        JFreeChart chart = ChartFactory.createBarChart("Personnel", "Position", "Times", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.WHITE);
        ChartFrame frame = new ChartFrame("Chart for ERROR", chart);
        frame.setVisible(true);
        frame.setSize(900, 700);

    }//GEN-LAST:event_personneljButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        ReporttoEnter reoprttoEnter = new ReporttoEnter();
        
        try {
            reoprttoEnter.creatTime();
        } catch (ParseException ex) {
            Logger.getLogger(BloodReportJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        reoprttoEnter.setLevel2(ErrorUtil.DEVICE_OR_MEDICAL);
        
        reoprttoEnter.setFirst(Integer.parseInt(fjTextField2.getText()));
        reoprttoEnter.setSecond(Integer.parseInt(sjTextField3.getText()));
        reoprttoEnter.setRespond(respongTextArea1.getText());
        reoprttoEnter.setErrorperonstring(personneljTextField1.getText());        
        reoprttoEnter.setMaxofperson(Integer.parseInt(timejTextField2.getText()));
         reoprttoEnter.setMostLocation(locationjTextField1.getText());
        
        
        reoprttoEnter.setDevicecause(causejTextField1.getText());
        reoprttoEnter.setDevicetype(typejTextField2.getText());
        
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof ServiceOrganization) {
                org.getReporttoEnterDir().getReporttoEnterList().add(reoprttoEnter);
            }
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        container.remove(this);
        CardLayout cl = (CardLayout) container.getLayout();
        cl.previous(container);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int timeofem = 0;
        int timeofpha = 0;
        int timeofward = 0;
        int timeofor = 0;
        int timeoflab = 0;
        int timeofoutpatient = 0;

        int i;
        int max = 0;

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.DEVICE_OR_MEDICAL)) {
                if (workRequest.getLocation().equals(Location.EMERGENCY)) {
                    timeofem = timeofem + 1;
                }
                if (workRequest.getLocation().equals(Location.LABORATORY)) {
                    timeoflab = timeoflab + 1;
                }
                if (workRequest.getLocation().equals(Location.OR)) {
                    timeofor = timeofor + 1;
                }
                if (workRequest.getLocation().equals(Location.OUTPATIEN)) {
                    timeofoutpatient = timeofoutpatient + 1;
                }
                if (workRequest.getLocation().equals(Location.PHARMACY)) {
                    timeofpha = timeofpha + 1;
                }
                if (workRequest.getLocation().equals(Location.WARD)) {
                    timeofward = timeofward + 1;
                }

            }
        }

        int[] numbs;
        numbs = new int[6];
        numbs[0] = timeofem;
        numbs[1] = timeoflab;
        numbs[2] = timeofor;
        numbs[3] = timeofoutpatient;
        numbs[4] = timeofpha;
        numbs[5] = timeofward;

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(Location.EMERGENCY, timeofem);
        dataset.setValue(Location.LABORATORY, timeoflab);
        dataset.setValue(Location.OR, timeofor);
        dataset.setValue(Location.OUTPATIEN, timeofoutpatient);
        dataset.setValue(Location.PHARMACY, timeofpha);
        dataset.setValue(Location.WARD, timeofward);

        JFreeChart chart = ChartFactory.createPieChart(" Chart", dataset, true, true, true);

        PiePlot p = (PiePlot) chart.getPlot();

        ChartFrame chartFrame = new ChartFrame("Location of events", chart);
        chartFrame.setSize(450, 550);
        chartFrame.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField causejTextField1;
    private javax.swing.JTextField fjTextField2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField locationjTextField1;
    private javax.swing.JTextField namejTextField2;
    private javax.swing.JButton personneljButton2;
    private javax.swing.JTextField personneljTextField1;
    private javax.swing.JTextArea respongTextArea1;
    private javax.swing.JTextField sjTextField3;
    private javax.swing.JTextField timejTextField2;
    private javax.swing.JTextField typejTextField2;
    // End of variables declaration//GEN-END:variables
}
