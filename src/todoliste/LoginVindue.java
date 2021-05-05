/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;

/**
 *
 * @author olive
 */
public class LoginVindue extends javax.swing.JFrame {

    public static String emailFieldText;
    
    public LoginVindue() {
        initComponents();
        loginError.setVisible(false);
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
        emailField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocation(new java.awt.Point(600, 230));
        setMaximumSize(new java.awt.Dimension(360, 310));
        setMinimumSize(new java.awt.Dimension(360, 310));
        setName("Login"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 170, 100, 23);

        emailField.setText("");
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(emailField);
        emailField.setBounds(100, 70, 190, 20);

        jLabel1.setText("Email:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 80, 20);

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 120, 80, 20);

        jPasswordField1.setText("");
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(100, 120, 190, 20);

        jLabel3.setText("Har du ikke en konto?");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 240, 130, 14);

        jLabel4.setText("Registrer dig her");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 240, 100, 14);

        loginError.setForeground(new java.awt.Color(255, 0, 0));
        loginError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginError.setText("Brugernavn eller kodeord forkert!");
        getContentPane().add(loginError);
        loginError.setBounds(80, 200, 190, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        En simpel regex til at verificere emails, emailen skal indholde mindst et punktum, og alt efter det sidste punktum skal være et bogstaver
//        Email må gerne indholde store og små bogstaver, tal (emails kan indeholde IP'er efter @ i stedet for etc studiobeans.dk)
//        Email må også indeholde punktum, bindestreg og underscore
//        Password må indeholde alle latniske bogstaver + danske. (Skulle være jævnt sikkert overfor SQL Injection, men er dog ikke ekspert lmao)
        if (emailField.getText().matches("[A-Za-z0-9+.-]+@[A-Za-z0-9.-]+$") 
                && jPasswordField1.getText().matches("[A-Za-z0-9+$&+,:=?@#|<>.^*\\s/%!\\-_()¤ÆØÅæøå/¨]+$")){
            try{
                if(JDBC.signIn(emailField.getText(), jPasswordField1.getText()) == true){
                    emailFieldText = emailField.getText();
                    Hovedvindue hovedvindue = new Hovedvindue();
                    hovedvindue.setVisible(true);
                    //Hovedvindue.setTaskButton(JDBC.getTasks().get(0).toString(),JDBC.getTasks().get(1).toString(),JDBC.getTasks().get(2).toString());
                    
                    Hovedvindue.taskHandler();
                    
                    this.dispose();
                }
                else{
                loginError.setVisible(true);
                }
            //JDBC.signIn(emailField.getText());
            //System.out.println(JDBC.password);
            }
            catch(Exception e){
                System.out.print("Exception i Login Vinduet");
                e.printStackTrace();
            }
        }
        else{
            //Ugyldigt bruger navn eller password
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        RegistrerVindue registrervindue = new RegistrerVindue();
        registrervindue.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(LoginVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVindue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel loginError;
    // End of variables declaration//GEN-END:variables
}
