/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import static todoliste.JDBC.isOnline;

/**
 *
 * @author olive
 */
public class TilføjVindue extends javax.swing.JFrame {

    /**
     * Creates new form TilføjVindue
     */
    public TilføjVindue() {
        initComponents();
        setDateText();
        dateError.setVisible(false);
        taskNameError.setVisible(false);
        startTimeError.setVisible(false);
        endTimeError.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startTime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        endTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        taskName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        date = new javax.swing.JTextField();
        dateError = new javax.swing.JLabel();
        taskNameError = new javax.swing.JLabel();
        startTimeError = new javax.swing.JLabel();
        endTimeError = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(430, 340));
        setMinimumSize(new java.awt.Dimension(430, 340));
        setResizable(false);
        getContentPane().setLayout(null);

        startTime.setText("10:00");
        startTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimeActionPerformed(evt);
            }
        });
        getContentPane().add(startTime);
        startTime.setBounds(162, 134, 119, 20);

        jLabel1.setText("Start Tid:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(88, 137, 70, 14);

        jLabel2.setText("Slut Tid:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(88, 175, 70, 14);

        endTime.setText("12:30");
        endTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTimeActionPerformed(evt);
            }
        });
        getContentPane().add(endTime);
        endTime.setBounds(162, 172, 119, 20);

        jLabel3.setText("Opgave titel:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(78, 99, 80, 14);

        taskName.setText("Opgave");
        taskName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskNameActionPerformed(evt);
            }
        });
        getContentPane().add(taskName);
        taskName.setBounds(162, 96, 119, 20);

        jButton1.setText("Tilføj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 266, 80, 23);

        jButton2.setText("Annuller");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(219, 266, 90, 23);

        date.setText("jTextField1");
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        getContentPane().add(date);
        date.setBounds(177, 57, 59, 20);

        dateError.setForeground(new java.awt.Color(255, 0, 0));
        dateError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateError.setText("Ugyldig dato!");
        getContentPane().add(dateError);
        dateError.setBounds(144, 40, 130, 14);

        taskNameError.setForeground(new java.awt.Color(255, 0, 0));
        taskNameError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        taskNameError.setText("Ugyldigt opgave navn!");
        getContentPane().add(taskNameError);
        taskNameError.setBounds(144, 80, 160, 14);

        startTimeError.setForeground(new java.awt.Color(255, 0, 0));
        startTimeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startTimeError.setText("Ugyldigt start tidspunkt!");
        getContentPane().add(startTimeError);
        startTimeError.setBounds(144, 120, 160, 14);

        endTimeError.setForeground(new java.awt.Color(255, 0, 0));
        endTimeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endTimeError.setText("Ugylidigt slut tidspunkt!");
        getContentPane().add(endTimeError);
        endTimeError.setBounds(134, 160, 180, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setDateText(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime timeNow = LocalDateTime.now();
        
        date.setText(JDBC.selDate);
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //https://stackoverflow.com/a/25759060
        String timeReg = "^([0-2]?[0-9]|[2][0-3]):([0-5][0-9])";
        if (date.getText().matches("\\d{2}\\-\\d{2}\\-\\d{4}")){
            if (taskName.getText().matches("[0-9a-zA-ZæøåØÅÆ\\.\\-\\/\\s]+")){
                if (startTime.getText().matches(timeReg) && endTime.getText().matches(timeReg)){
                    try{
                        if(Hovedvindue.jComboBox1.getSelectedItem() == "Min liste"){
                            JDBC.addTask(date.getText(), taskName.getText(), startTime.getText(), endTime.getText());
                            Hovedvindue.taskHandler();
                        }
                        else{
                            String[] ArrOfTeamID = Hovedvindue.jComboBox1.getSelectedItem().toString().split(", ");
                            JDBC.addTeamTask(ArrOfTeamID[1], date.getText(), taskName.getText(), startTime.getText(), endTime.getText());
                            Hovedvindue.taskHandler();
                        }
                    }catch(CommunicationsException e){
                        System.out.println("JDBC er offline");
                        isOnline = false;
                        Hovedvindue.closeWindows();
                        LoginVindue login = new LoginVindue();
                        login.setVisible(true);
                    }
                    catch(Exception e){
                        System.out.println("Fejl i skabelse af opgave");
                    }
                }
                else{
                    dateError.setVisible(false);
                    taskNameError.setVisible(false);
                    startTimeError.setVisible(false);
                    endTimeError.setVisible(false);
                    if (startTime.getText().matches(timeReg)){
                        endTimeError.setVisible(true);
                    } else{
                        startTimeError.setVisible(true);
                    }
                } 
            }
            else{
                dateError.setVisible(false);
                taskNameError.setVisible(true);
                startTimeError.setVisible(false);
                endTimeError.setVisible(false);
            }
        } else{
            dateError.setVisible(true);
            taskNameError.setVisible(false);
            startTimeError.setVisible(false);
            endTimeError.setVisible(false);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void taskNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskNameActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void startTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startTimeActionPerformed

    private void endTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endTimeActionPerformed

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
            java.util.logging.Logger.getLogger(TilføjVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TilføjVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TilføjVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TilføjVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TilføjVindue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField date;
    private javax.swing.JLabel dateError;
    public static javax.swing.JTextField endTime;
    private javax.swing.JLabel endTimeError;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JTextField startTime;
    private javax.swing.JLabel startTimeError;
    public static javax.swing.JTextField taskName;
    private javax.swing.JLabel taskNameError;
    // End of variables declaration//GEN-END:variables
}
