/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;

/**
 * <h1>Registrerings vindue</h1>
 * Dette vindue står for registrering af nye brugere
 * @author Benjamin O. Høj
 * @since 06-05-2021
 */
public class RegistrerVindue extends javax.swing.JFrame {

    /**
     * Laver en ny form "RegistrerVindue"
     */
    public RegistrerVindue() {
        initComponents();
        emailError.setVisible(false);
        usernameError.setVisible(false);
        passwordError.setVisible(false);
        userExistslbl.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usernameError = new javax.swing.JLabel();
        emailError = new javax.swing.JLabel();
        passwordError = new javax.swing.JLabel();
        userExistslbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sign-up");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(502, 215));
        setMaximumSize(new java.awt.Dimension(458, 325));
        setMinimumSize(new java.awt.Dimension(458, 325));
        setName("Sign-up"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        emailField.setText("");
        emailField.setToolTipText("eksempel@email.dk");
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(emailField);
        emailField.setBounds(100, 90, 250, 30);

        jLabel1.setText("Email:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 100, 40, 14);

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 150, 90, 14);

        jPasswordField1.setText("");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(100, 140, 250, 30);

        jLabel3.setText("Username:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 50, 90, 14);

        usernameField.setText("");
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernameField);
        usernameField.setBounds(100, 40, 250, 30);

        jButton1.setText("Registrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 200, 110, 23);

        jLabel4.setText("Har du allerede en konto?");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 270, 150, 14);

        jLabel5.setText("Login");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(280, 270, 50, 14);

        usernameError.setForeground(new java.awt.Color(255, 0, 0));
        usernameError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameError.setText("Ugyldigt brugernavn!");
        getContentPane().add(usernameError);
        usernameError.setBounds(102, 70, 250, 14);

        emailError.setForeground(new java.awt.Color(255, 0, 0));
        emailError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailError.setText("Ugyldig Email!");
        getContentPane().add(emailError);
        emailError.setBounds(100, 120, 250, 14);

        passwordError.setForeground(new java.awt.Color(255, 0, 0));
        passwordError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordError.setText("Ugyldigt kodeord!");
        getContentPane().add(passwordError);
        passwordError.setBounds(100, 170, 250, 14);

        userExistslbl.setForeground(new java.awt.Color(255, 0, 0));
        userExistslbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userExistslbl.setText("Denne email eksistere allerede!");
        getContentPane().add(userExistslbl);
        userExistslbl.setBounds(99, 240, 250, 14);

        getAccessibleContext().setAccessibleName("Sign-up");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    /*
    *Når en bruger trykker på registrerings knappen tjekkes der om emailField
    *faktisk er en email. Dette gør den med et simplere regex, først tjekker vi
    *at der kun er store og små bogstaver, tal eller "+ - .". Efter disse tjekkes der
    *om der er et "@" efter de første tegn, og til sidst tjekker vi igen efter 
    *store og små bogstaver, tal eller "+ - ." (Alle disse er tegn der kan bruges i en email.
    *Bagefter tjekker man om password indeholder gyldige tegn, og til sidst om 
    *usernameField indeholder gyldige tegn. Dette er tildels for at undgå SQL-injections,
    *men også for at verificere om en email faktisk er gyldig.
    *Hvis et felt er ugyldigt, så sendes der en fejl besked til brugeren om det specifikke felt.
    *Hvis alt input er gyldigt, sendes det til JDBC signUp metoden.
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (emailField.getText().matches("[A-Za-z0-9+.-]+@[A-Za-z0-9.-]+$")){
            if (jPasswordField1.getText().matches("[A-Za-z0-9+$&+,:=?@#|<>.^*\\s/%!\\-_()¤ÆØÅæøå/¨]+$")){
               if (usernameField.getText().matches("[a-zA-ZæøåØÅÆ0-9\\s]+")){
                   emailError.setVisible(false);
                   passwordError.setVisible(false);
                   usernameError.setVisible(false);
                   try{
                    if (JDBC.signUp(usernameField.getText(), emailField.getText(), jPasswordField1.getText())){
                        userExistslbl.setVisible(true);
                    }
                    else{
                        LoginVindue loginvindue = new LoginVindue();
                        loginvindue.setVisible(true);
                        this.dispose();
                    }
                    }
                    catch(Exception e){
                    e.printStackTrace();
                    }
                   
               }
               else{
                emailError.setVisible(false);
                passwordError.setVisible(false);
                usernameError.setVisible(true);
               }     
            }
            else{
                emailError.setVisible(false);
                passwordError.setVisible(true);
                usernameError.setVisible(false);
            }
        }
         else{
            emailError.setVisible(true);
            passwordError.setVisible(false);
            usernameError.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        LoginVindue login = new LoginVindue();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrerVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrerVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrerVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrerVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrerVindue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailError;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel passwordError;
    private javax.swing.JLabel userExistslbl;
    private javax.swing.JLabel usernameError;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
