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
import Business.Util.Fall;
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
public class FallReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FallReportJPanel
     */
    JPanel container;
    Enterprise enterprise;

    public FallReportJPanel(JPanel container, Enterprise enterprise1) {
        initComponents();
        this.container = container;
        enterprise = enterprise1;
        namejTextField3.setText(enterprise.getOrgName());

        populateTable();
        populateSource();
        populateDoing();
        populateMostIssuedPersonnel();
        populateass();
        populateOutcome();
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
            if (workRequest.getLevel2().equals(ErrorUtil.FALL)) {
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
    
    
    
    
    
    
    private void populateOutcome(){
        int timeofdis =0;
        int timeoffrac =0;
        int timeofintra =0;
        int timeoflacer =0;
        int timeofnotall =0;
        
        int max =0;
        int i ;
        
        
        for(WorkRequest w:enterprise.getWorkQueue().getWorkRequestList()){
            if(w.getLevel2().equals(ErrorUtil.FALL)){
                if(w.getCauseoffall().equals(Fall.DISLOCATION)){
                    timeofdis = timeofdis+1;
                }if(w.getCauseoffall().equals(Fall.FRACTURE)){
                    timeoffrac = timeoffrac+1;
                }if(w.getCauseoffall().equals(Fall.INTRACRANIAL_INJURY)){
                    timeofintra = timeofintra+1;
                }if(w.getCauseoffall().equals(Fall.LACERATION_REQUIRING)){
                    timeoflacer = timeoflacer+1;
                }if(w.getCauseoffall().equals(Fall.NOT_APPLICABLE)){
                    timeofnotall  = timeofnotall+1;
                }
                
            }
        }
        
        int[] numbs;
        numbs = new int[5];
        numbs[0] = timeofdis;
        numbs[1] = timeoffrac;
        numbs[2] = timeofintra;
        numbs[3] = timeoflacer;
        numbs[4] = timeofnotall;
        

        for (i = 0; i < 5; i++) {
            if (max < numbs[i]) {
                max = numbs[i];
        
                
                 switch (i) {
                    case 0:
                        outcomejTextField7.setText(Fall.DISLOCATION);
                        break;
                    case 1:
                        outcomejTextField7.setText(Fall.FRACTURE);
                        break;
                    case 2:
                        outcomejTextField7.setText(Fall.INTRACRANIAL_INJURY);
                        break;
                    case 3:
                        outcomejTextField7.setText(Fall.LACERATION_REQUIRING);
                        break;
                    case 4:
                        outcomejTextField7.setText(Fall.NOT_APPLICABLE);
                        break;
                    
                }
                
        
            }
        }
        
        
    }

    private void populateass() {
        int timeofa = 0;
        int timeofnoa = 0;
        int timeofunknown = 0;

        int max = 0;
        int i;

        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.FALL)) {
                if (w.getAssisted().equals(Fall.ASSISTED)) {
                    timeofa = timeofa + 1;
                }
                if (w.getAssisted().equals(Fall.UNASSISTED)) {
                    timeofnoa = timeofnoa + 1;
                }
                if (w.getAssisted().equals(Fall.UNKNOWN)) {
                    timeofunknown = timeofunknown + 1;
                }

            }
        }

        int[] numbs;
        numbs = new int[3];
        numbs[0] = timeofa;
        numbs[1] = timeofnoa;
        numbs[2] = timeofunknown;

        for (i = 0; i < 3; i++) {
            if (max < numbs[i]) {
                max = numbs[i];

                switch (i) {
                    case 0:
                        assistedjTextField4.setText(Fall.ASSISTED);
                        break;
                    case 1:
                        assistedjTextField4.setText(Fall.UNASSISTED);
                        break;
                    case 2:
                        assistedjTextField4.setText(Fall.UNKNOWN);

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
            if (workRequest.getLevel2().equals(ErrorUtil.FALL)) {
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

    private void populateDoing() {
        int awithas = 0;
        int awithoutas = 0;
        int change = 0;
        int navigating = 0;
        int bath = 0;
        int reaching = 0;

        int i;
        int max = 0;

        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.FALL)) {
                if (w.getFalldoing().equals(Fall.AMBULATING_WITH_ASSISTANCE)) {
                    awithas = awithas + 1;
                }
                if (w.getFalldoing().equals(Fall.AMUBLATING_WITHOUT_ASSISTANCE)) {
                    awithoutas = awithoutas + 1;
                }
                if (w.getFalldoing().equals(Fall.CHANGING_POSITION)) {
                    change = change + 1;
                }
                if (w.getFalldoing().equals(Fall.NAVIGATING_BEDRAILS)) {
                    navigating = navigating + 1;
                }
                if (w.getFalldoing().equals(Fall.SHOWING_OR_BATHING)) {
                    bath = bath + 1;
                }
                if (w.getFalldoing().equals(Fall.REACHING_FOR_AN_ITEM)) {
                    reaching = reaching + 1;
                }
            }
        }

        int[] numbs;
        numbs = new int[6];
        numbs[0] = awithas;
        numbs[1] = awithoutas;
        numbs[2] = change;
        numbs[3] = navigating;
        numbs[4] = bath;
        numbs[5] = reaching;

        for (i = 0; i < 6; i++) {
            if (max < numbs[i]) {
                max = numbs[i];

                switch (i) {
                    case 0:
                        doingjTextField5.setText(Fall.AMBULATING_WITH_ASSISTANCE);
                        break;
                    case 1:
                        doingjTextField5.setText(Fall.AMUBLATING_WITHOUT_ASSISTANCE);
                        break;
                    case 2:
                        doingjTextField5.setText(Fall.CHANGING_POSITION);
                        break;
                    case 3:
                        doingjTextField5.setText(Fall.NAVIGATING_BEDRAILS);
                        break;
                    case 4:
                        doingjTextField5.setText(Fall.SHOWING_OR_BATHING);
                        break;
                    case 5:
                        doingjTextField5.setText(Fall.REACHING_FOR_AN_ITEM);
                        break;
                }

            }

        }
    }

    private void populateSource() {
        int firstsourcenumber = 0;
        int secondsourcenumber = 0;

        for (WorkRequest w : enterprise.getWorkQueue().getWorkRequestList()) {
            if (w.getLevel2().equals(ErrorUtil.FALL)) {
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
            if (w.getLevel2().equals(ErrorUtil.FALL)) {
                Object[] row = new Object[3];
                row[0] = w.getDateoferror();
                row[1] = w.getCauseoffall();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        namejTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        secondjTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        timesjTextField2 = new javax.swing.JTextField();
        personneljTextField3 = new javax.swing.JTextField();
        assistedjTextField4 = new javax.swing.JTextField();
        doingjTextField5 = new javax.swing.JTextField();
        firstjTextField6 = new javax.swing.JTextField();
        chartjButton1 = new javax.swing.JButton();
        outcomejTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        respondjTextArea1 = new javax.swing.JTextArea();
        submitjButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        locationjTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Fall");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 100, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date of event", "Type of Injury", "Source"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 680, 220));
        add(namejTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 180, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setText("Report List of");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));
        add(secondjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 374, 120, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Source");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 374, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("First");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Second");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("This kind of personnel is reported most frequently:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Times");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("at hospital/clinic.");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Most common outcome of the fall is:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));
        add(timesjTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 490, 90, -1));
        add(personneljTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 186, -1));
        add(assistedjTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 186, -1));
        add(doingjTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 630, 210, -1));
        add(firstjTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 374, 133, -1));

        chartjButton1.setText("Chart");
        chartjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartjButton1ActionPerformed(evt);
            }
        });
        add(chartjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, -1, -1));
        add(outcomejTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 210, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Write below");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, -1, 80));

        respondjTextArea1.setColumns(20);
        respondjTextArea1.setRows(5);
        jScrollPane2.setViewportView(respondjTextArea1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 430, 150));

        submitjButton1.setText("Submit");
        submitjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButton1ActionPerformed(evt);
            }
        });
        add(submitjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 680, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setText("Prior to the fall,  most patient are: ");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, -1));

        jButton4.setText("<<Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        add(locationjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 680, 210, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setText("This kind of event most likely occure ar:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 330, -1));

        jButton2.setText("View Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 680, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setText("when they fall");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 640, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setText("Most patients are under");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, -1));
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
            if (workRequest.getLevel2().equals(ErrorUtil.FALL)) {
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

    private void submitjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButton1ActionPerformed
        // TODO add your handling code here:
        ReporttoEnter enter = new ReporttoEnter();
        
        try {
            enter.creatTime();
        } catch (ParseException ex) {
            Logger.getLogger(FallReportJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        enter.setLevel2(ErrorUtil.FALL);
        
        enter.setFirst(Integer.parseInt(firstjTextField6.getText()));
        enter.setSecond(Integer.parseInt(secondjTextField1.getText()));
        enter.setErrorperonstring(personneljTextField3.getText());
        enter.setMaxofperson(Integer.parseInt(timesjTextField2.getText()));
        enter.setMostLocation(locationjTextField1.getText());
        enter.setRespond(respondjTextArea1.getText());
        
        enter.setAssistedornot(assistedjTextField4.getText());
        enter.setFalloutcome(outcomejTextField7.getText());
        enter.setFalldoing(doingjTextField5.getText());
        
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
            if(org instanceof ServiceOrganization){
                org.getReporttoEnterDir().getReporttoEnterList().add(enter);
            }
        }
    }//GEN-LAST:event_submitjButton1ActionPerformed

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
            if (workRequest.getLevel2().equals(ErrorUtil.FALL)) {
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
    private javax.swing.JTextField assistedjTextField4;
    private javax.swing.JButton chartjButton1;
    private javax.swing.JTextField doingjTextField5;
    private javax.swing.JTextField firstjTextField6;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField locationjTextField1;
    private javax.swing.JTextField namejTextField3;
    private javax.swing.JTextField outcomejTextField7;
    private javax.swing.JTextField personneljTextField3;
    private javax.swing.JTextArea respondjTextArea1;
    private javax.swing.JTextField secondjTextField1;
    private javax.swing.JButton submitjButton1;
    private javax.swing.JTextField timesjTextField2;
    // End of variables declaration//GEN-END:variables
}
