/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;

import com.mysql.cj.exceptions.CJCommunicationsException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import static todoliste.JDBC.isOnline;

/**
 *
 * @author Benjamin
 */
public class inviteUserVindue extends javax.swing.JFrame {

    /**
     * Creates new form inviteUserVindue
     */
    public inviteUserVindue() {
        initComponents();
        updateCheckBox();
    }
    public static void updateCheckBox(){
        try{
            for (Object i : JDBC.getUserTeams().keySet()) {
                jComboBox2.addItem(JDBC.getUserTeams().get(i).toString() + ", " + i);
            }
        }
        catch(CommunicationsException e){
         System.out.println("JDBC er offline");
         isOnline = false;
         Hovedvindue.closeWindows();
         LoginVindue login = new LoginVindue();
         login.setVisible(true);
        }
        catch(Exception e){
            System.out.println("Fejl i hentning af hold!");
            e.printStackTrace();
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
        emailField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        inviteStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(290, 300));
        setMinimumSize(new java.awt.Dimension(290, 300));
        setPreferredSize(new java.awt.Dimension(290, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inviter en bruger til et hold via. Email:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 80, 200, 14);

        emailField.setText("exempel@email.dk");
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(emailField);
        emailField.setBounds(50, 100, 190, 20);

        jButton1.setText("Inviter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 160, 90, 23);

        inviteStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(inviteStatus);
        inviteStatus.setBounds(0, 190, 270, 14);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 132, 290, 21);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[] ArrOfTeamID = jComboBox2.getSelectedItem().toString().split(", ");
        try{
            if(JDBC.inviteCheck(ArrOfTeamID[1], emailField.getText())){
                inviteStatus.setText("Brugeren blev inviteret!");
            }
            else{
                inviteStatus.setText("Brugeren eksistere ikke!");
            }
        }
        catch(CJCommunicationsException e){
         System.out.println("JDBC er offline");
         isOnline = false;
         Hovedvindue.closeWindows();
         LoginVindue login = new LoginVindue();
         login.setVisible(true);
        }
        catch(Exception e){
            System.out.println("Fejl i invitation af bruger");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inviteUserVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inviteUserVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inviteUserVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inviteUserVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inviteUserVindue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel inviteStatus;
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
