/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaces.HAdministration;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class HealthAdministrationWorkAreajPanel extends javax.swing.JPanel {

    /**
     * Creates new form HealthAdministrationWorkAreajPanel
     */
    JPanel container;
    UserAccount ua;
    Organization organization;
    Enterprise enterprise;
    EcoSystem es;

    public HealthAdministrationWorkAreajPanel(JPanel container, UserAccount ua, Organization org, Enterprise enterpirse, EcoSystem ecoSystem) {
        initComponents();
        this.container = container;
        this.ua = ua;
        this.organization = org;
        this.enterprise = enterpirse;
        es = ecoSystem;
        //jTextField1.setText(enterpirse.getOrgName());

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
        ReportlistjButton1 = new javax.swing.JButton();
        datajButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Healthcare Adminstration Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 473, -1));

        ReportlistjButton1.setText("Enter");
        ReportlistjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportlistjButton1ActionPerformed(evt);
            }
        });
        add(ReportlistjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 70, -1));

        datajButton1.setText("Enter");
        datajButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datajButton1ActionPerformed(evt);
            }
        });
        add(datajButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("View Report Chart");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setText("View all report list");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText("Hospital/Clinic Data");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ReportlistjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportlistjButton1ActionPerformed
        // TODO add your handling code here:
        ReportListjPanel vdjp = new ReportListjPanel(container, ua, organization, enterprise, es);
        container.add("ViewDetialJPanel", vdjp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);


    }//GEN-LAST:event_ReportlistjButton1ActionPerformed

    private void datajButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datajButton1ActionPerformed
        // TODO add your handling code here:

        ReportDataJPanel rdjp = new ReportDataJPanel(container, ua, organization, enterprise, es);
        container.add("ViewDetialJPanel", rdjp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);


    }//GEN-LAST:event_datajButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        EnterpriseListJPanel eljp = new EnterpriseListJPanel(container, ua, organization, enterprise, es);
        container.add("EnterpriseListJPanel", eljp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReportlistjButton1;
    private javax.swing.JButton datajButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
