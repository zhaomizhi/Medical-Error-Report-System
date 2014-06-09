/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaces.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;

import Business.NetWork.Network;
import Business.Role.AdminRole;

import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aki
 */
public class ManageEnterpriseAdminJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseJPanel
     */
     JPanel container;
     EcoSystem ecoSystem;
    public ManageEnterpriseAdminJPanel1(JPanel container, EcoSystem ecoSystem1) {
        initComponents();
        this.container =  container;
        ecoSystem =ecoSystem1;
        populateTbale();
        populateNetworkCombox();
    }

    
    
    private void populateTbale() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Network network : ecoSystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEd().getEnterprisesList()) {
                for(UserAccount ua:enterprise.getUserAccountDirectory().getUserAccountList()){
                Object[] row = new Object[3];
                row[0] = enterprise.getOrgName();
                row[1] = network.getName();
                row[2] = ua.getUserName();

                model.addRow(row);
            }
        }
    }
    }
    
    
    
    
    
    
    private void populateNetworkCombox(){
        networkjComboBox2.removeAllItems();
      
        for(Network network: ecoSystem.getNetworkList()){
            networkjComboBox2.addItem(network);
            
        }
    }
    
    
    private void populateEnterpriseCombox(Network network){
        enterprisejComboBox1.removeAllItems();
        for(Enterprise e: network.getEd().getEnterprisesList()){
            enterprisejComboBox1.addItem(e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        enterprisejComboBox1 = new javax.swing.JComboBox();
        networkjComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        usernamejTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namejTextField4 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise name", "Network", "User name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 23, 385, 118));

        jLabel1.setText("Network");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 172, -1, -1));

        jLabel2.setText("Enterprise");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 218, -1, -1));

        add(enterprisejComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 214, 199, -1));

        networkjComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkjComboBox2ActionPerformed(evt);
            }
        });
        add(networkjComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 168, 199, -1));

        jLabel3.setText("User name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 259, -1, -1));
        add(usernamejTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 253, 193, -1));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 362, -1, -1));

        jLabel4.setText("password");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 305, -1, -1));

        jLabel5.setText("Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 357, -1, -1));
        add(namejTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 351, 178, -1));
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void networkjComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkjComboBox2ActionPerformed
        // TODO add your handling code here:
        
        
        Network network = (Network) networkjComboBox2.getSelectedItem();
       //在上面的box里面选的什么就传入什么，然后显示相应的条目
        if(network != null){
        populateEnterpriseCombox(network);
    }
       
    }//GEN-LAST:event_networkjComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Network network = (Network) networkjComboBox2.getSelectedItem();
        Enterprise enterprise = (Enterprise) enterprisejComboBox1.getSelectedItem();
        
        
        
        
        String username = usernamejTextField1.getText();
        String pass = String.valueOf(jPasswordField1.getPassword());
        String name = namejTextField4.getText();
        
        Employee employee =enterprise.getEmployeeDirectory().createEmployee(name);
 
        
        if(enterprise.getUserAccountDirectory().checkExit(username, enterprise)==null){
             UserAccount ua = enterprise.getUserAccountDirectory().createUserAccount(username,pass, employee, new AdminRole());
            populateTbale();
            
        }else{
            JOptionPane.showMessageDialog(null, "Sorry, this usename has already exist");
        }
        
        
        
        // if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital)||enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Clinic)){
          //  UserAccount ua = enterprise.getUserAccountDirectory().createUserAccount(username,pass, employee, new AdminRole());
           // populateTbale();
      
       
//}if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Government)){
          //  UserAccount ua = enterprise.getUserAccountDirectory().createUserAccount(username, pass, employee, new GovernmentRole());
       // }
         //   else{
        //UserAccount ua = enterprise.getUserAccountDirectory().createUserAccount(username, pass, employee, new NGORole());          
      //  populateTbale();    
      //  UserAccount ua = enterprise.getUserAccountDirectory().createUserAccount(username, pass, e, new AdminRole());
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox enterprisejComboBox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namejTextField4;
    private javax.swing.JComboBox networkjComboBox2;
    private javax.swing.JTextField usernamejTextField1;
    // End of variables declaration//GEN-END:variables
}
