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
import Business.Util.Medication;
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
public class MedicationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MedicationJPanel
     */
    JPanel container;
    Enterprise enterprise;

    public MedicationJPanel(JPanel container, Enterprise enterprise1) {
        initComponents();
        this.container = container;
        enterprise = enterprise1;
        namejTextField3.setText(enterprise1.getOrgName());
        populateTable();
        populateSource();
        populateMostIssuedPersonnel();
        popoulateMedicationType();
        populateMedicalDes();
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
            if (workRequest.getLevel2().equals(ErrorUtil.MEDICATION_OR_OTHER)) {
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
    
    
    
    
    
    private void populateMedicalDes() {
        int timeofincorr = 0;
        int timeofadverse = 0;
        int timeofunsafe = 0;
        int timeofunknow=0;
        
        int i;
        int max= 0;
        
        for(WorkRequest w: enterprise.getWorkQueue().getWorkRequestList()){
            if(w.getLevel2().equals(ErrorUtil.MEDICATION_OR_OTHER)){
                if(w.getCharacterizesofme().equals(Medication.INCORRECT_ACTION)){
                    timeofincorr = timeofincorr+1;                           
                }if(w.getCharacterizesofme().equals(Medication.ADVERSE_REACTION)){
                    timeofadverse= timeofadverse+1;
                }if(w.getCharacterizesofme().equals(Medication.UNKNOWN)){
                    timeofunknow = timeofunknow+1;
                }if(w.getCharacterizesofme().equals(Medication.UNSAFE_CONDITION)){
                    timeofunsafe= timeofunsafe+1;
                }
            }
        }

        
         int[] numbs;
        numbs = new int[4];
        numbs[0] = timeofadverse;
        numbs[1] = timeofincorr;
        numbs[2] = timeofunknow;
        numbs[3] = timeofunsafe;
       

        for (i = 0; i < 4; i++) {
            if (max < numbs[i]) {
                max = numbs[i];

                switch (i) {
                    case 0:
                        descripjTextField2.setText(Medication.ADVERSE_REACTION);
                        break;
                    case 1:
                        descripjTextField2.setText(Medication.INCORRECT_ACTION);
                        break;
                    case 2:
                        descripjTextField2.setText(Medication.UNKNOWN);
                        break;
                    case 3:
                        descripjTextField2.setText(Medication.UNSAFE_CONDITION);
                        break;
                  
                }

            }
        }
        
        
        
    }

    private void popoulateMedicationType() {

        int timeofbio = 0;
        int timeofcon = 0;
        int timeofgas = 0;
        int timeofmed = 0;
        int timeofnut = 0;

        int i;
        int max = 0;

        for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getLevel2().equals(ErrorUtil.MEDICATION_OR_OTHER)) {
                if (workRequest.getMedicationtype().equals(Medication.BIOLOGICAL_PRODUCTS)) {
                    timeofbio = timeofbio + 1;
                }
                if (workRequest.getMedicationtype().equals(Medication.CONTRAST_MEDICA)) {
                    timeofcon = timeofcon + 1;
                }
                if (workRequest.getMedicationtype().equals(Medication.MEDICAL_GASES)) {
                    timeofgas = timeofgas + 1;
                }
                if (workRequest.getMedicationtype().equals(Medication.MEDICATION)) {
                    timeofmed = timeofmed + 1;
                }
                if (workRequest.getMedicationtype().equals(Medication.NUTRITIONAL_PRODUCTS)) {
                    timeofnut = timeofnut + 1;
                }
            }
        }

        int[] numbs;
        numbs = new int[5];
        numbs[0] = timeofbio;
        numbs[1] = timeofcon;
        numbs[2] = timeofgas;
        numbs[3] = timeofmed;
        numbs[4] = timeofnut;

        for (i = 0; i < 5; i++) {
            if (max < numbs[i]) {
                max = numbs[i];

                switch (i) {
                    case 0:
                        typejTextField1.setText(Medication.BIOLOGICAL_PRODUCTS);
                        break;
                    case 1:
                        typejTextField1.setText(Medication.CONTRAST_MEDICA);
                        break;
                    case 2:
                        typejTextField1.setText(Medication.MEDICAL_GASES);
                        break;
                    case 3:
                        typejTextField1.setText(Medication.MEDICATION);
                        break;
                    case 4:
                        typejTextField1.setText(Medication.NUTRITIONAL_PRODUCTS);
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
            if (workRequest.getLevel2().equals(ErrorUtil.MEDICATION_OR_OTHER)) {
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
            if (w.getLevel2().equals(ErrorUtil.MEDICATION_OR_OTHER)) {
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
            if (w.getLevel2().equals(ErrorUtil.MEDICATION_OR_OTHER)) {
                Object[] row = new Object[3];
                row[0] = w.getDateoferror();
                row[1] = w.getMedicationtype();
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
        firstjTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        secondjTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        personneljTextField3 = new javax.swing.JTextField();
        timesjTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        chartjButton1 = new javax.swing.JButton();
        typejTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        descripjTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        resjTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        locationjTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Medication and Substance");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 301, -1));
        add(namejTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 180, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setText("Report List of");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date of event", "Medication", "Source"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 700, 190));
        add(firstjTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 133, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Source");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("First");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Second");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));
        add(secondjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 120, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("This kind of personnel is reported most frequently:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));
        add(personneljTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 186, -1));
        add(timesjTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 90, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Write below");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        chartjButton1.setText("Chart");
        chartjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartjButton1ActionPerformed(evt);
            }
        });
        add(chartjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, -1, -1));
        add(typejTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 186, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("Most reporters described the medication event as:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("This type of medication was reported most frequencly:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));
        add(descripjTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 180, -1));

        resjTextArea1.setColumns(20);
        resjTextArea1.setRows(5);
        jScrollPane2.setViewportView(resjTextArea1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 480, 140));

        jButton1.setText("Send Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 610, -1, -1));

        jButton4.setText("<<Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setText("This kind of event most likely occure ar:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 330, -1));
        add(locationjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 630, 220, -1));

        jButton2.setText("View Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 630, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Times:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, -1, -1));
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
            if (workRequest.getLevel2().equals(ErrorUtil.MEDICATION_OR_OTHER)) {
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
        
         ReporttoEnter enter = new ReporttoEnter();
        
        try {
            enter.creatTime();
        } catch (ParseException ex) {
            Logger.getLogger(FallReportJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        enter.setLevel2(ErrorUtil.MEDICATION_OR_OTHER);
        
        enter.setFirst(Integer.parseInt(firstjTextField6.getText()));
        enter.setSecond(Integer.parseInt(secondjTextField1.getText()));
        enter.setErrorperonstring(personneljTextField3.getText());
        enter.setMaxofperson(Integer.parseInt(timesjTextField2.getText()));
        enter.setMostLocation(locationjTextField1.getText());
        enter.setRespond(resjTextArea1.getText());
        
        
       enter.setMeddescrip(descripjTextField2.getText());
       enter.setMedtype(typejTextField1.getText());
       
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
            if(org instanceof ServiceOrganization){
                org.getReporttoEnterDir().getReporttoEnterList().add(enter);
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
            if (workRequest.getLevel2().equals(ErrorUtil.MEDICATION_OR_OTHER)) {
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
    private javax.swing.JTextField descripjTextField2;
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
    private javax.swing.JTextArea resjTextArea1;
    private javax.swing.JTextField secondjTextField1;
    private javax.swing.JTextField timesjTextField2;
    private javax.swing.JTextField typejTextField1;
    // End of variables declaration//GEN-END:variables
}
