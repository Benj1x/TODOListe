/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import static todoliste.JDBC.isOnline;

/**
 *
 * @author Benjamin O. Høj
 */
public class InvitationVindue extends javax.swing.JFrame {

    /**
     * Creates new form InvitationVindue
     */
    public InvitationVindue() {
        initComponents();
        inviteHandler();
        inviteStatus.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        inviteStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(425, 1000000000));
        setMinimumSize(new java.awt.Dimension(425, 300));
        setPreferredSize(new java.awt.Dimension(425, 300));
        setResizable(false);

        jLabel1.setText("Dine hold invitationer:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setVerticalScrollBar(jScrollBar1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        inviteStatus.setForeground(new java.awt.Color(0, 255, 0));
        inviteStatus.setText("Invitationen blev accepteret!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inviteStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inviteStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Denne kode er stærkt inspireret af Hovedvinduet
    Invite handler tjekker om den nuværende bruger har nogle invitationer
    hvis brugeren har dette, så sendes informationerne til setInvites metoden.
    */
    public static void inviteHandler(){
        acceptButtons.clear();
        denyButtons.clear();
        teamLabels.clear();
        userLabels.clear();
        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.repaint();
        
        try{
            int indexCorr = 0;
            int amount = JDBC.getInvites().size() / 5;
            for(int i = 0; i < amount; i++){
                setInvites(JDBC.getInvites().get(indexCorr).toString(), JDBC.getInvites().get(indexCorr+1).toString(), 
                        JDBC.getInvites().get(indexCorr+3).toString(), JDBC.getInvites().get(indexCorr+4).toString());
                indexCorr = indexCorr + 5;
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
            System.out.println("Fejl i inviteHandler");
            e.printStackTrace();
        }
    }
        
    public static ArrayList<JButton> acceptButtons = new ArrayList<>();
    public static ArrayList<JButton> denyButtons = new ArrayList<>();
    public static ArrayList<JLabel> teamLabels = new ArrayList<>();
    public static ArrayList<JLabel> userLabels = new ArrayList<>();

    /*
    @param inviteID,
    */
    public static void setInvites(String inviteID, String teamID, String username, String teamName){
        JButton accept = new JButton("Accepter");
        JButton deny = new JButton("Afvis");
        JLabel teamLbl = new JLabel("Hold: " + teamName);
        JLabel userLbl = new JLabel("Fra: " + username);
        
        accept.setName(teamID);
        deny.setName(teamID);
        userLbl.setName("LabeFor"+teamName);
        teamLbl.setName("TeamLabelFor"+teamLbl);
        
        /*
        *Hver knap får en actionListener, når man trykker på knappen "Accepter"
        *sendes hold ID'et til JDBC.acceptedInvite
        *Trykker man på "Afvis" så sendes hold ID'et til JDBC.deleteInvite
        *Disse to har hvert deres try-catch, for det kunne ikke smides i en enkelt
        */
        accept.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try{
                    JDBC.acceptedInvite(accept.getName());
                    inviteStatus.setText("Invitationen blev accepteret!");
                    inviteStatus.setForeground(Color.GREEN);
                    inviteStatus.setVisible(true);
                    InvitationVindue.inviteHandler();
                    for (Object i : JDBC.getUserTeams().keySet()) {
                        Hovedvindue.jComboBox1.addItem(JDBC.getUserTeams().get(i).toString() + ", " + i);
                    }
                    
                }
                catch(CommunicationsException ex){
                    System.out.println("JDBC er offline");
                    isOnline = false;
                    Hovedvindue.closeWindows();
                    LoginVindue login = new LoginVindue();
                    login.setVisible(true);
                }
                catch(Exception ex){
                    System.out.println("Fejl i tilføjelse af accepter knap");
                    ex.printStackTrace();
                }
            }
        });
        
        deny.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try{
                    JDBC.deleteInvite(deny.getName());
                    inviteStatus.setText("Invitationen blev slettet!");
                    inviteStatus.setForeground(Color.RED);
                    inviteStatus.setVisible(true);
                    InvitationVindue.inviteHandler();
                }
                catch(CommunicationsException ex){
                    System.out.println("JDBC er offline");
                    isOnline = false;
                    Hovedvindue.closeWindows();
                    LoginVindue login = new LoginVindue();
                    login.setVisible(true);
                }
                catch(Exception ex){
                    System.out.println("Fejl i tilføjelse af deny knap");
                    ex.printStackTrace();
                }
                
            }
        });
        
        acceptButtons.add(accept);
        denyButtons.add(deny);
        teamLabels.add(teamLbl);
        userLabels.add(userLbl);
        
        int i = -1;
   
        int element = acceptButtons.size()-1;
        i++;
        if(acceptButtons.get(i) != acceptButtons.get(0)){
            accept.setBounds(186,52,95,26);
            deny.setBounds(290,52,95,26);
        }
        else{
           int nextTaskY = acceptButtons.get(i).getBounds().y + (38*element);
           accept.setBounds(186,nextTaskY,95,26);
           deny.setBounds(290,nextTaskY,95,26);
        }
        if(teamLabels.size() == 1){
            teamLbl.setBounds(12,12,250,16);
            System.out.println(teamLbl.getBounds());
        }
        else{
           int nextTaskY = teamLabels.get(i).getBounds().y + (38*element);
           teamLbl.setBounds(12,nextTaskY,250,16);
           System.out.println(teamLbl.getText() + " " +teamLbl.getBounds());
        }
        if(userLabels.size() == 1){
            userLbl.setBounds(12,0,250,16);
            System.out.println(userLbl.getBounds());
        }
        else{
           int nextTaskY = userLabels.get(i).getBounds().y + (38*element);
           userLbl.setBounds(12,nextTaskY,250,16);
           System.out.println(userLbl.getText() + " " +userLbl.getBounds());
        }
        
        jPanel1.add(accept);
        jPanel1.add(deny);
        jPanel1.add(teamLbl);
        jPanel1.add(userLbl);
        jPanel1.repaint();
        jPanel1.revalidate();
    }
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
            java.util.logging.Logger.getLogger(InvitationVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvitationVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvitationVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvitationVindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvitationVindue().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel inviteStatus;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JPanel jPanel1;
    private static javax.swing.JScrollBar jScrollBar1;
    private static javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
