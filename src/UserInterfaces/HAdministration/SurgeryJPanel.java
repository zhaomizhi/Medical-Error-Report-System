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
import Business.Util.ErrorUtil;
import Business.Util.Location;
import Business.Util.Source;
import Business.Util.Surgery;
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
public class SurgeryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SurgeryJPanel
     */
    JPanel container;
    Enterprise enterprise;

    public SurgeryJPanel(JPanel container, Enterprise enterprise1) {
        initComponents();
        this.container = container;
        enterprise = enterprise1;
        namejTextField3.setText(enterprise.getOrgName());

        populateTable();
        populateSource();
        populateMostIssuedPersonnel();
        populateMostIssuedLocation();
        populateCom();
        populateDes();

    }

    private void populateDes() {

        int timeofsur = 0;
        int timeofburn = 0;
        int timeofinc = 0;
        int timeoflab = 0;
        int timeofdent = 0;
        int timeofocu = 0;
        int timeofper = 0;
        int timeofmal = 0;

        int i = 0;
        int max = 0;

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.SURGERY_OR_ANESTHESIA)) {
                if (workRequest.getCharaofsurgery().equals(Surgery.SURGICAL_SITE_INFECTION)) {
                    timeofsur = timeofsur + 1;
                }
                if (workRequest.getCharaofsurgery().equals(Surgery.BURN_OPERATING_ROOM_FIRE)) {
                    timeofburn = timeofburn + 1;
                }
                if (workRequest.getCharaofsurgery().equals(Surgery.INCORRECT_SURGICAL_PROCEDURE)) {
                    timeofinc = timeofinc + 1;
                }
                if (workRequest.getCharaofsurgery().equals(Surgery.LATROGENIC_PNEUMOTHORAX)) {
                    timeoflab = timeoflab + 1;
                }
                if (workRequest.getCharaofsurgery().equals(Surgery.DENTAL_INJURY)) {
                    timeofdent = timeofdent + 1;
                }
                if (workRequest.getCharaofsurgery().equals(Surgery.OCULAR_INJURY)) {
                    timeofocu = timeofocu + 1;
                }
                if (workRequest.getCharaofsurgery().equals(Surgery.PERIPHERAL_NERVE_INJURY)) {
                    timeofper = timeofper + 1;
                }
                if (workRequest.getCharaofsurgery().equals(Surgery.MALIGNANT_HYPERTHERMIA)) {
                    timeofmal = timeofmal + 1;
                }

            }
        }

        int[] numbs;
        numbs = new int[8];
        numbs[0] = timeofsur;
        numbs[1] = timeofburn;
        numbs[2] = timeofinc;
        numbs[3] = timeoflab;
        numbs[4] = timeofdent;
        numbs[5] = timeofocu;
        numbs[6] = timeofper;
        numbs[7] = timeofmal;

        for (i = 0; i < 8; i++) {
            if (max < numbs[i]) {
                max = numbs[i];

                switch (i) {
                    case 0:
                        desjTextField1.setText(Surgery.SURGICAL_SITE_INFECTION);
                        break;
                    case 1:
                        desjTextField1.setText(Surgery.BURN_OPERATING_ROOM_FIRE);
                        break;
                    case 2:
                        desjTextField1.setText(Surgery.INCORRECT_SURGICAL_PROCEDURE);
                        break;
                    case 3:

                        desjTextField1.setText(Surgery.LATROGENIC_PNEUMOTHORAX);
                        break;
                    case 4:
                        desjTextField1.setText(Surgery.DENTAL_INJURY);
                        break;
                    case 5:
                        desjTextField1.setText(Surgery.OCULAR_INJURY);
                        break;
                    case 6:
                        desjTextField1.setText(Surgery.PERIPHERAL_NERVE_INJURY);
                        break;
                    case 7:

                        desjTextField1.setText(Surgery.MALIGNANT_HYPERTHERMIA);
                        break;

                }
            }
        }
    }

    private void populateCom() {
        int timeofcar = 0;
        int timeofren = 0;
        int timeofcen = 0;
        int timeofres = 0;

        int i = 0;
        int max = 0;

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.SURGERY_OR_ANESTHESIA)) {
                if (workRequest.getComplication().equals(Surgery.CARDIA)) {
                    timeofcar = timeofcar + 1;
                }
                if (workRequest.getComplication().equals(Surgery.CENTRAL_NEVERVOUS)) {
                    timeofcen = timeofcen + 1;
                }
                if (workRequest.getComplication().equals(Surgery.RESPIRATORY)) {
                    timeofres = timeofres + 1;
                }
                if (workRequest.getComplication().equals(Surgery.RENAL_FAILURE)) {
                    timeofren = timeofren + 1;
                }

            }
        }

        int[] numbs;
        numbs = new int[4];
        numbs[0] = timeofcar;
        numbs[1] = timeofcen;
        numbs[2] = timeofren;
        numbs[3] = timeofres;

        for (i = 0; i < 4; i++) {
            if (max < numbs[i]) {
                max = numbs[i];

                switch (i) {
                    case 0:
                        comjTextField1.setText(Surgery.CARDIA);
                        break;
                    case 1:
                        comjTextField1.setText(Surgery.CENTRAL_NEVERVOUS);
                        break;
                    case 2:
                        comjTextField1.setText(Surgery.RESPIRATORY);
                        break;
                    case 3:

                        comjTextField1.setText(Surgery.RENAL_FAILURE);
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
            if (workRequest.getLevel2().equals(ErrorUtil.SURGERY_OR_ANESTHESIA)) {
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
            if (workRequest.getLevel2().equals(ErrorUtil.SURGERY_OR_ANESTHESIA)) {
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
                        personneljTextField3.setText(ErrorPerson.ErrorPersonType.ADMINSTRATION.toString());
                        break;
                    case 1:
                        personneljTextField3.setText(ErrorPerson.ErrorPersonType.NURESE.toString());
                        break;
                    case 2:
                        personneljTextField3.setText(ErrorPerson.ErrorPersonType.PATHOLOGIST.toString());
                        break;
                    case 3:
                        personneljTextField3.setText(ErrorPerson.ErrorPersonType.PHARMACIST.toString());
                        break;
                    case 4:
                        personneljTextField3.setText(ErrorPerson.ErrorPersonType.PHYSICIAN.toString());
                        break;
                    case 5:
                        personneljTextField3.setText(ErrorPerson.ErrorPersonType.SURGEON.toString());
                        break;
                }

            }
        }
    }

    private void populateSource() {
        int firstsourcenumber = 0;
        int secondsourcenumber = 0;

        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.SURGERY_OR_ANESTHESIA)) {
                if (w.getSource().equals(Source.FIRST)) {
                    firstsourcenumber = firstsourcenumber + 1;
                }
                if (w.getSource().equals(Source.SECOND)) {
                    secondsourcenumber = secondsourcenumber + 1;
                }
                firstjTextField6.setText(String.valueOf(firstsourcenumber));
                secondjTextField1.setText(String.valueOf(secondsourcenumber));

            }
        }
    }

    private void populateTable() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.SURGERY_OR_ANESTHESIA)) {
                Object[] row = new Object[3];
                row[0] = w.getDateoferror();
                row[1] = w.getSurgeryevent();
                row[2] = w.getSource();
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
        namejTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        firstjTextField6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        secondjTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        personneljTextField3 = new javax.swing.JTextField();
        timesjTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        chartjButton1 = new javax.swing.JButton();
        comjTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        desjTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        respondjTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        locationjTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Surgery");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 120, -1));
        add(namejTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 180, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setText("Report List of");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date of event", "Type of event", "Source"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 680, 220));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Source");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));
        add(firstjTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 133, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("First");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));
        add(secondjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 120, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Second");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("This kind of personnel is reported most frequently");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));
        add(personneljTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 186, -1));
        add(timesjTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 90, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Write below");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        chartjButton1.setText("Chart");
        chartjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartjButton1ActionPerformed(evt);
            }
        });
        add(chartjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, -1, -1));
        add(comjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 190, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("The kind of complication most likely to occur:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Most people regard the event as:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));
        add(desjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, 180, -1));

        respondjTextArea1.setColumns(20);
        respondjTextArea1.setRows(5);
        jScrollPane2.setViewportView(respondjTextArea1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 360, 140));

        jButton1.setText("Send Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 620, -1, -1));

        jButton4.setText("<<Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setText("This kind of event most likely occure ar:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 330, -1));
        add(locationjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 620, 230, -1));

        jButton2.setText("View Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 620, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Times");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void chartjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartjButton1ActionPerformed
        // TODO add your handling code here:

        int timeofadmin = 0;
        int timeofnurse = 0;
        int timeofpathology = 0;
        int timeofphar = 0;
        int timeofphysician = 0;
        int timeofsurgeon = 0;

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.SURGERY_OR_ANESTHESIA)) {
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

    }//GEN-LAST:event_chartjButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        ReporttoEnter re = new ReporttoEnter();

        try {
            re.creatTime();
        } catch (ParseException ex) {
            Logger.getLogger(SurgeryJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        re.setLevel2(ErrorUtil.SURGERY_OR_ANESTHESIA);
        
        re.setFirst(Integer.parseInt(firstjTextField6.getText()));
        re.setSecond(Integer.parseInt(secondjTextField1.getText()));
        re.setErrorperonstring(personneljTextField3.getText());
        re.setMaxofperson(Integer.parseInt(timesjTextField2.getText()));
        re.setRespond(respondjTextArea1.getText());
        re.setMostLocation(locationjTextField1.getText());

        re.setSurCom(comjTextField1.getText());
        re.setSurdescrip(desjTextField1.getText());

        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof ServiceOrganization) {
                org.getReporttoEnterDir().getReporttoEnterList().add(re);
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
            if (workRequest.getLevel2().equals(ErrorUtil.SURGERY_OR_ANESTHESIA)) {
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
    private javax.swing.JButton chartjButton1;
    private javax.swing.JTextField comjTextField1;
    private javax.swing.JTextField desjTextField1;
    private javax.swing.JTextField firstjTextField6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField namejTextField3;
    private javax.swing.JTextField personneljTextField3;
    private javax.swing.JTextArea respondjTextArea1;
    private javax.swing.JTextField secondjTextField1;
    private javax.swing.JTextField timesjTextField2;
    // End of variables declaration//GEN-END:variables
}
