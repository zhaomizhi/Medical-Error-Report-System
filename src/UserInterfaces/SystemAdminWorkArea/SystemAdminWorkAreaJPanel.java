/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaces.SystemAdminWorkArea;

import Business.EcoSystem;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Aki
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel container;
    EcoSystem ecoSystem;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public SystemAdminWorkAreaJPanel(JPanel container, EcoSystem business) {
        initComponents();
        this.container = container;
        ecoSystem = business;
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
        networkbutton = new javax.swing.JButton();
        enterprisebutton = new javax.swing.JButton();
        adminbutton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Admin Work Area");

        networkbutton.setText("manage Network");
        networkbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkbuttonActionPerformed(evt);
            }
        });

        enterprisebutton.setText("Manage Enterprise");
        enterprisebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterprisebuttonActionPerformed(evt);
            }
        });

        adminbutton.setText("Manage admin");
        adminbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminbuttonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(181, 181, 181)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(enterprisebutton)
                    .add(networkbutton)
                    .add(adminbutton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 269, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(33, 33, 33)
                .add(jLabel1)
                .add(75, 75, 75)
                .add(networkbutton)
                .add(65, 65, 65)
                .add(enterprisebutton)
                .add(85, 85, 85)
                .add(adminbutton)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void networkbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkbuttonActionPerformed
        ManagerNetworkJPanel managerNetworkJPanel = new ManagerNetworkJPanel(container, ecoSystem);
        CardLayout cl = (CardLayout) container.getLayout();
        container.add("ManageOrganizationJPanel", managerNetworkJPanel);
        cl.next(container);

        System.out.println(ecoSystem + "networkbutton");
    }//GEN-LAST:event_networkbuttonActionPerformed

    private void enterprisebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterprisebuttonActionPerformed

        System.out.println(ecoSystem + "enterprisebutton up");

        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(container, ecoSystem);
        CardLayout cl = (CardLayout) container.getLayout();
        container.add("manageEnterpriseJPanel", manageEnterpriseJPanel);
        cl.next(container);

        System.out.println(ecoSystem + "enterprisebutton");
    }//GEN-LAST:event_enterprisebuttonActionPerformed

    private void adminbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminbuttonActionPerformed
        ManageEnterpriseAdminJPanel1 managemAdminJPanel1 = new ManageEnterpriseAdminJPanel1(container, ecoSystem);
        CardLayout cl = (CardLayout) container.getLayout();
        container.add("manageEnterpriseJPanel", managemAdminJPanel1);
        cl.next(container);
    }//GEN-LAST:event_adminbuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminbutton;
    private javax.swing.JButton enterprisebutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton networkbutton;
    // End of variables declaration//GEN-END:variables
}
