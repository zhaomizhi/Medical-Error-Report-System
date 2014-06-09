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
import Business.Util.Blood;
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
public class BloodReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BloodReportJPanel
     */
    JPanel container;
    Enterprise enterprise;

    public BloodReportJPanel(JPanel container, Enterprise enterprise1) {
        initComponents();
        this.container = container;
        enterprise = enterprise1;
        namejTextField2.setText(enterprise1.getOrgName());
        populateTbale();
        populateSource();
        popoulateblood();
        populatestage();
        populateMostIssuedPersonnel();
        populateMostIssuedLocation();
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
            if (workRequest.getLevel2().equals(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT)) {
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
            if (workRequest.getLevel2().equals(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT)) {
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

                timesjTextField2.setText(String.valueOf(max));

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

    private void populatestage() {
        int product = 0;
        int sample = 0;
        int post = 0;

        int i;
        int max = 0;

        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT)) {
                if (w.getBloodstage().equals(Blood.POST_TRANSFUSION)) {
                    post = post + 1;
                }
                if (w.getBloodstage().equals(Blood.SAMPLE)) {
                    sample = sample + 1;
                }
                if (w.getBloodstage().equals(Blood.PRODUCT)) {
                    product = product + 1;
                }
            }
        }
        int[] nums = {product, sample, post};

        for (i = 0; i < 3; i++) {
            if (max < nums[i]) {
                max = nums[i];

                switch (i) {
                    case 0:
                        stagejTextField2.setText(Blood.PRODUCT);
                        break;
                    case 1:
                        stagejTextField2.setText(Blood.SAMPLE);
                        break;
                    case 2:
                        stagejTextField2.setText(Blood.POST_TRANSFUSION);
                }

            }
        }
    }

    private void popoulateblood() {
        int whole = 0;

        int red = 0;
        int pla = 0;
        int rhlg = 0;
        int max = 0;
        int i;

        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT)) {
                if (w.getBloodtyep().equals(Blood.WHOLE_BLOOD)) {
                    whole = whole + 1;
                }
                if (w.getBloodtyep().equals(Blood.PLASMA)) {
                    pla = pla + 1;
                }
                if (w.getBloodtyep().equals(Blood.RED_BLOOD_CELL)) {
                    red = red + 1;
                }
                if (w.getBloodtyep().equals(Blood.RHLG)) {
                    rhlg = rhlg + 1;
                }
            }
        }

        int[] nums;
        nums = new int[4];

        nums[0] = whole;
        nums[1] = red;
        nums[2] = pla;
        nums[3] = rhlg;

        for (i = 0; i < 4; i++) {
            if (max < nums[i]) {
                max = nums[i];

                switch (i) {
                    case 0:
                        typejTextField1.setText(Blood.WHOLE_BLOOD);
                        break;
                    case 1:
                        typejTextField1.setText(Blood.RED_BLOOD_CELL);
                        break;
                    case 2:
                        typejTextField1.setText(Blood.PLASMA);
                        break;
                    case 3:
                        typejTextField1.setText(Blood.RHLG);
                        break;
                }

                // jTextField1.setText();
            }
        }

    }

    private void populateSource() {
        int firstsourcenumber = 0;
        int secondsourcenumber = 0;

        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT)) {
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
            if (w.getLevel2().equals(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT)) {
                Object[] row = new Object[4];
                row[0] = w.getDateoferror();
                row[1] = w.getBloodtyep();
                row[2] = w.getBloodstage();
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

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        typejTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        namejTextField2 = new javax.swing.JTextField();
        fjTextField2 = new javax.swing.JTextField();
        sjTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stagejTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        respondjTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        personneljButton2 = new javax.swing.JButton();
        personneljTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        timesjTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        locationjTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("First");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 50, -1));

        jButton1.setText("Send Report ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 620, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Write below:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 110, -1));
        add(typejTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 210, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Report List of");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 120, -1));
        add(namejTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 180, -1));
        add(fjTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 80, -1));
        add(sjTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 120, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Second");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 70, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Source:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 70, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("This type of blood is reported most frequently :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 350, 30));
        add(stagejTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 210, -1));

        respondjTextArea1.setColumns(20);
        respondjTextArea1.setRows(5);
        jScrollPane2.setViewportView(respondjTextArea1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 480, 100));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("This stage is reported most frequently: ");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 300, -1));

        personneljButton2.setText("Chart");
        personneljButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personneljButton2ActionPerformed(evt);
            }
        });
        add(personneljButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, -1, -1));
        add(personneljTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 160, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("This kind of event most likely occure ar:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 330, -1));
        add(timesjTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 120, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Times:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 70, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setText("Blood or Blood Product Report");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 301, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date of event", "Blood Product", "Stage", "Source"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 700, 170));

        jButton4.setText("<<Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setText("This knid of Personnel is reported most frequently:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 390, -1));
        add(locationjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 630, 230, -1));

        jButton2.setText("View Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 630, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void personneljButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personneljButton2ActionPerformed
        // TODO add your handling code here:

        int timeofadmin = 0;
        int timeofnurse = 0;
        int timeofpathology = 0;
        int timeofphar = 0;
        int timeofphysician = 0;
        int timeofsurgeon = 0;

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT)) {
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

        reoprttoEnter.setLevel2(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT);

        reoprttoEnter.setRespond(respondjTextArea1.getText());
        reoprttoEnter.setFirst(Integer.parseInt(fjTextField2.getText()));
        reoprttoEnter.setSecond(Integer.parseInt(sjTextField3.getText()));
        reoprttoEnter.setErrorperonstring(personneljTextField1.getText());
        reoprttoEnter.setMaxofperson(Integer.parseInt(timesjTextField2.getText()));
        reoprttoEnter.setMostLocation(locationjTextField1.getText());

        reoprttoEnter.setBloodtype(typejTextField1.getText());
        reoprttoEnter.setBloodstage(stagejTextField2.getText());

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
            if (workRequest.getLevel2().equals(ErrorUtil.BLOOD_OR_BLOOD_PRODUCT)) {
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
    private javax.swing.JTextField fjTextField2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField locationjTextField1;
    private javax.swing.JTextField namejTextField2;
    private javax.swing.JButton personneljButton2;
    private javax.swing.JTextField personneljTextField1;
    private javax.swing.JTextArea respondjTextArea1;
    private javax.swing.JTextField sjTextField3;
    private javax.swing.JTextField stagejTextField2;
    private javax.swing.JTextField timesjTextField2;
    private javax.swing.JTextField typejTextField1;
    // End of variables declaration//GEN-END:variables
}
