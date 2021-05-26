/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;

/**
 * <h1>TODOList vindue til at slette tasks</h1>
 * @author Benjamin O. Høj
 */
public class deleteTaskVindue extends javax.swing.JFrame {

    static String setTaskName, setTaskID;
    /**
     * Creates new form deleteTaskVindue
     */
        
    public deleteTaskVindue() {
        initComponents();
        deletionStatus.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        taskNamelbl = new javax.swing.JLabel();
        deletionStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(799, 371));
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Ja");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 210, 70, 23);

        jButton2.setText("Nej");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 210, 70, 23);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vil du slette opgaven?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 70, 400, 14);

        taskNamelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        taskNamelbl.setText("placeHolderText");
        taskNamelbl.setMaximumSize(new java.awt.Dimension(105, 14));
        taskNamelbl.setMinimumSize(new java.awt.Dimension(105, 14));
        taskNamelbl.setPreferredSize(new java.awt.Dimension(105, 14));
        taskNamelbl.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                taskNamelblAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(taskNamelbl);
        taskNamelbl.setBounds(0, 90, 400, 20);

        deletionStatus.setForeground(new java.awt.Color(0, 255, 0));
        deletionStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deletionStatus.setText("Opgaven blev slettet!");
        getContentPane().add(deletionStatus);
        deletionStatus.setBounds(0, 160, 400, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    *Når brugeren trykker på slet knappen, sendes setTaskID til JDBC deleteTask metoden.
    *Når dette er gjordt, kaldes hovedvinduets taskHandler igen.
    *For at undgå at brugeren trykker på "Ja" knappen igen, slår vi både "Ja" og "Nej"
    *knappen fra.
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        deletionStatus.setVisible(true);
        try{
            if(Hovedvindue.jComboBox1.getSelectedItem() == "Min liste"){
                JDBC.deleteUserTask(setTaskID);
                Hovedvindue.taskHandler();
            }
            else{
                String[] ArrOfTeamID = Hovedvindue.jComboBox1.getSelectedItem().toString().split(", ");
                JDBC.deleteTeamTask(ArrOfTeamID[1], setTaskID);
                Hovedvindue.taskHandler();
            }
        }
        catch(Exception e){
            System.out.println("Fejl i sletning af opgaver");
            e.printStackTrace();
        }

        Hovedvindue.taskHandler();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /*
    *Når vinduet åbnes, opdatere vi teksten på taskNamelbl og setTaskID til den valgte 
    *opgaves navn og ID.
    */
    private void taskNamelblAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_taskNamelblAncestorAdded
        taskNamelbl.setText(Hovedvindue.taskNameUpdater);
        setTaskID = Hovedvindue.taskIDUpdater;
    }//GEN-LAST:event_taskNamelblAncestorAdded

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
            java.util.logging.Logger.getLogger(deleteTaskVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteTaskVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteTaskVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteTaskVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deleteTaskVindue().setVisible(true);
 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deletionStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel taskNamelbl;
    // End of variables declaration//GEN-END:variables
}
