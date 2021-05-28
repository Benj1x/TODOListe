/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;


import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import static todoliste.JDBC.isOnline;


/**
 *
 * @author Oliver K. Svendsen & Benjamin O. Høj
 *
 */
public class Hovedvindue extends javax.swing.JFrame{

    private int dateTracker = 0;
    public static String taskNameUpdater, taskIDUpdater;
    /**
     * Creates new form Hovedvindue
     */
    
    /*
    *Oliver:
    */
    public Hovedvindue() { 

        initComponents();
        //setTaskButton();
        setDateText();
        
        AddToComboBox();
        
    }
    
    /*
    *Oliver:
    */
    private void AddToComboBox(){
        jComboBox1.addItem("Min liste");
        
        try{           
                for (Object i : JDBC.getUserTeams().keySet()) {
                    jComboBox1.addItem(JDBC.getUserTeams().get(i).toString() + ", " + i);
                }   
        }
        catch(Exception e){
            //System.out.println("Something went wrong when adding teams to the combobox");
            e.printStackTrace();
        }
        
        
        
    }
    /*
    *Oliver:
    */
    public void setDateText(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime timeNow = LocalDateTime.now();
        
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(SDF.parse());
        //calendar.add(Calendar.DATE, 1);
        
        jLabel4.setText(SDF.format(calendar.getTime()).toString());
        JDBC.selDate = jLabel4.getText();
    }
    /*
    *Oliver:
    */
    public static void taskHandler(){
        buttons.clear();
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        
        int indexCorr = 0;
        if(jComboBox1.getSelectedItem() == "Min liste"){
            try{
                int amount = JDBC.getTasks().size() / 4;
                for(int i = 0; i < amount; i++){
                    setTaskButton(JDBC.getTasks().get(indexCorr).toString(), JDBC.getTasks().get(indexCorr+1).toString(), JDBC.getTasks().get(indexCorr+2).toString(), false, JDBC.getTasks().get(indexCorr+3).toString());
                        //System.out.println(JDBC.getTasks().get(i+4).toString()+JDBC.getTasks().get(i+5).toString()+JDBC.getTasks().get(i+6).toString()+JDBC.getTasks().get(i+7).toString());
                    indexCorr = indexCorr + 4;      
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
                System.out.println("Fejl i henting af opgaver");
            }
        }
        else{
            try{
                String[] ArrOfTeamID = jComboBox1.getSelectedItem().toString().split(", ");
                int teamAmount = JDBC.getTeamTasks(ArrOfTeamID[1]).size() / 4;
                for(int j = 0; j < teamAmount; j++){
                    
                    setTaskButton(JDBC.getTeamTasks(ArrOfTeamID[1]).get(indexCorr).toString(), JDBC.getTeamTasks(ArrOfTeamID[1]).get(indexCorr+1).toString(), JDBC.getTeamTasks(ArrOfTeamID[1]).get(indexCorr+2).toString(), true, JDBC.getTeamTasks(ArrOfTeamID[1]).get(indexCorr+3).toString());
                        
                    indexCorr = indexCorr + 4;
                }
                //JDBC.getTeamTasks(ArrOfTeamID[1]);
            }
            catch(CommunicationsException e){
                System.out.println("JDBC er offline");
                isOnline = false;
                Hovedvindue.closeWindows();
                LoginVindue login = new LoginVindue();
                login.setVisible(true);
            }
            catch(Exception e){
                System.out.println("Fejl i henting af opgaver");
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

        jPanel2 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl22H = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl21H = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl20H = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl19H = new javax.swing.JLabel();
        lbl23H = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl24h = new javax.swing.JLabel();
        lbl00H = new javax.swing.JLabel();
        lbl18H = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl17H = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl16H = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl15H = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl14H = new javax.swing.JLabel();
        lbl13H = new javax.swing.JLabel();
        lbl12H = new javax.swing.JLabel();
        lbl11H = new javax.swing.JLabel();
        lbl10H = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        createTeam = new javax.swing.JButton();
        signOut = new javax.swing.JButton();
        usernameLbl = new javax.swing.JLabel();
        addTeam = new javax.swing.JButton();
        invites = new javax.swing.JButton();
        inviteUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("To-Do Liste");
        setBackground(new java.awt.Color(102, 102, 102));
        setExtendedState(1);
        setForeground(java.awt.Color.yellow);
        setMinimumSize(new java.awt.Dimension(1160, 641));
        setResizable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1094, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("|");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(860, 70, 40, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("|");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(990, 80, 20, 20);

        lbl22H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl22H.setText("22:00");
        jPanel1.add(lbl22H);
        lbl22H.setBounds(890, 60, 60, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("|");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(820, 80, 40, 20);

        lbl21H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl21H.setText("21:00");
        jPanel1.add(lbl21H);
        lbl21H.setBounds(860, 60, 40, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("|");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(940, 80, 40, 20);

        lbl20H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl20H.setText("20:00");
        jPanel1.add(lbl20H);
        lbl20H.setBounds(810, 60, 60, 30);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("|");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(890, 80, 60, 20);

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("29-03-2021");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(560, 40, 90, 20);

        lbl19H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl19H.setText("19:00");
        jPanel1.add(lbl19H);
        lbl19H.setBounds(770, 60, 60, 30);

        lbl23H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl23H.setText("23:00");
        jPanel1.add(lbl23H);
        lbl23H.setBounds(930, 60, 60, 30);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todoliste/calendar-arrow-right.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(640, 40, 36, 22);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todoliste/calendar-arrow-left.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(530, 40, 36, 22);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("|");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(790, 80, 10, 20);

        lbl24h.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl24h.setText("24:00");
        jPanel1.add(lbl24h);
        lbl24h.setBounds(970, 60, 60, 30);

        lbl00H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl00H.setText("00:00");
        jPanel1.add(lbl00H);
        lbl00H.setBounds(0, 60, 40, 30);

        lbl18H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl18H.setText("18:00");
        jPanel1.add(lbl18H);
        lbl18H.setBounds(730, 60, 50, 30);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("|");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(720, 80, 70, 20);

        lbl17H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl17H.setText("17:00");
        jPanel1.add(lbl17H);
        lbl17H.setBounds(680, 60, 70, 30);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("|");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(690, 80, 50, 20);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("|");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(670, 80, 10, 20);

        lbl16H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl16H.setText("16:00");
        jPanel1.add(lbl16H);
        lbl16H.setBounds(650, 60, 50, 30);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("|");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(590, 80, 80, 20);

        lbl15H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl15H.setText("15:00");
        jPanel1.add(lbl15H);
        lbl15H.setBounds(600, 60, 60, 30);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("|");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(560, 80, 60, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("|");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(520, 80, 60, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("|");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(500, 80, 20, 20);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("|");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(440, 80, 60, 20);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("|");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(390, 80, 70, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("|");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(360, 80, 50, 20);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("|");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(320, 80, 50, 20);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("|");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(280, 80, 50, 20);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("|");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(240, 80, 50, 20);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("|");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(190, 80, 60, 20);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("|");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(160, 80, 40, 20);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("|");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(110, 80, 60, 20);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("|");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(80, 80, 40, 20);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("|");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(40, 80, 40, 20);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("|");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(0, 80, 40, 20);

        lbl14H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl14H.setText("14:00");
        jPanel1.add(lbl14H);
        lbl14H.setBounds(560, 60, 60, 30);

        lbl13H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl13H.setText("13:00");
        jPanel1.add(lbl13H);
        lbl13H.setBounds(520, 60, 60, 30);

        lbl12H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl12H.setText("12:00");
        jPanel1.add(lbl12H);
        lbl12H.setBounds(490, 60, 40, 30);

        lbl11H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl11H.setText("11:00");
        jPanel1.add(lbl11H);
        lbl11H.setBounds(450, 60, 40, 30);

        lbl10H.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10H.setText("10:00");
        jPanel1.add(lbl10H);
        lbl10H.setBounds(400, 60, 50, 30);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("09:00");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(360, 60, 50, 30);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("08:00");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(320, 60, 50, 30);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("07:00");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(280, 60, 50, 30);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("06:00");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(240, 60, 50, 30);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("05:00");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(190, 60, 60, 30);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("04:00");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(160, 60, 40, 30);

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("03:00");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(120, 60, 40, 30);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("02:00");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(80, 60, 40, 30);

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("01:00");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(40, 60, 40, 30);

        createTeam.setText("Lav hold");
        createTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTeamActionPerformed(evt);
            }
        });

        signOut.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        signOut.setText("Log af");
        signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutActionPerformed(evt);
            }
        });

        usernameLbl.setText("userName");
        usernameLbl.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                usernameLblAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        addTeam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todoliste/add-task-button.png"))); // NOI18N
        addTeam.setBorder(null);
        addTeam.setBorderPainted(false);
        addTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeamActionPerformed(evt);
            }
        });

        invites.setText("Invitationer");
        invites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invitesActionPerformed(evt);
            }
        });

        inviteUser.setText("Inviter");
        inviteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inviteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createTeam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inviteUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(invites))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTeam))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(signOut)
                                .addComponent(usernameLbl)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(createTeam))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(invites)
                                .addComponent(inviteUser)))
                        .addGap(3, 3, 3)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeamActionPerformed
        TilføjVindue tilføjvindue = new TilføjVindue();
        tilføjvindue.setVisible(true);
    }//GEN-LAST:event_addTeamActionPerformed
    /*
    *Oliver gjorde så pilen til højre går igennem kalenderen, i dette tilfælde
    *en dag frem i tiden. Herefter tilføjede, jeg, Benjamin så den nuværende
    *dato, også er den dato vi kigger efter opgaver på. Imodsætningn til før, 
    *hvor vi hentede tasks for alle data. Dette nedsætter fetch time på databasen.
    */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, dateTracker++);
            SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
            //calendar.add(Calendar.DATE, dateTracker++);
            jLabel4.setText(SDF.format(calendar.getTime()).toString());
            
            JDBC.selDate = jLabel4.getText();
            taskHandler();
    }//GEN-LAST:event_jButton8ActionPerformed

    /*
    *Af Benjamin:
    *Når en bruger trykker på log ud knappen tømmer programmet alle arrays
    *Herefter kaldes closeWindows()
    *Så åbnes et nyt login vindue
    */
    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        hasRun = false;
        jPanel2.removeAll();
        try{
          JDBC.getTasks().clear();
          JDBC.inviteIDs.clear();
          JDBC.signOut();
        }
        catch(CommunicationsException e){
         isOnline = false;
        } catch(Exception ex){
         System.out.println("Uhåndteret fejl i JDBC load!\n"+ex);
        }
        closeWindows();
        
        LoginVindue login = new LoginVindue();
        login.setVisible(true);
    }//GEN-LAST:event_signOutActionPerformed

    /*Af Benjamin:
    *Alle vinduer som er åbne, lukkes, dette gøre ved at loope igennem
    *vinduerne ved hjælp af java.awt.Window, med dette kan vi loope igennem de 
    *aktive vinduer.
    */
    public static void closeWindows(){
        for (java.awt.Window window : java.awt.Window.getWindows()) {
            window.dispose();
        }
    }
    
    private void usernameLblAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_usernameLblAncestorAdded
        try{
            usernameLbl.setText(JDBC.getUserDetails(LoginVindue.emailFieldText));
        }
        catch(Exception e){
            System.out.println("ERROR IN GETTING USER DETAILS!");
            e.getStackTrace();
        }
    }//GEN-LAST:event_usernameLblAncestorAdded

    /*
    *Oliver gjorde så pilen til venstre går igennem kalenderen, i dette tilfælde
    *en dag tilbage i tiden. Herefter tilføjede, jeg, Benjamin så den nuværende
    *dato, også er den dato vi kigger efter opgaver på. Imodsætningn til før, 
    *hvor vi hentede tasks for alle data. Dette nedsætter fetch time på databasen.
    */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dateTracker--);
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        //calendar.add(Calendar.DATE, dateTracker--);
        jLabel4.setText(SDF.format(calendar.getTime()).toString());
        
        JDBC.selDate = jLabel4.getText();
        taskHandler();

    }//GEN-LAST:event_jButton9ActionPerformed


    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        if(evt.getStateChange() == 1 && hasRun != false){
            
            for(JButton e : buttons){
                jPanel2.remove(e);
            }
            taskHandler();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    
    private void invitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invitesActionPerformed
        InvitationVindue invitationVindue = new InvitationVindue();
        invitationVindue.setVisible(true);
    }//GEN-LAST:event_invitesActionPerformed

    private void createTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTeamActionPerformed
        CreateNewTeam createNewTeam = new CreateNewTeam();
        createNewTeam.setVisible(true);
    }//GEN-LAST:event_createTeamActionPerformed

    private void inviteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inviteUserActionPerformed
        inviteUserVindue InviteUserVindue = new inviteUserVindue();
        InviteUserVindue.setVisible((true));
    }//GEN-LAST:event_inviteUserActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public static ArrayList<JButton> buttons = new ArrayList<>();
    public static boolean hasRun = false;

    /* @author Oliver:
    *For at kunne udregne vores starttidspunkt, brugte jeg en matematisk tankegang.
    *Da at teksten bliver omskrevet til en double og derefter ganget med 60 (fra timer til minutter).
    *Herefter ganger jeg de antal minutter som blev fundet, med vores værdi for hvor mange pixels der er tilrådighed epr minut.
    *Jeg omdanner den til en integer, for at vi kan indsætte den i en JButton.setBounds().
    */
    public static void setTaskButton(String taskName, String beginTime, String endTime, boolean isTeamTask, String ID){   
        String[] arrOfStartTime = beginTime.split(":");
        String StartTime = "";
        
        String[] HourStartTime = arrOfStartTime[0].split("");
        if(HourStartTime[0].contains("0")){
            StartTime = HourStartTime[1];
        }
        if(HourStartTime[0].contains("1") || HourStartTime[0].contains("2")){
            StartTime = HourStartTime[0] + HourStartTime[1];
        }
        
        String[] MinuteStartTime = arrOfStartTime[1].split("");
        String MinuteStart = "";
        if(MinuteStartTime[0].contains("0")){
            MinuteStart = MinuteStartTime[1];
        }
        if(MinuteStartTime[0].contains("1") || MinuteStartTime[0].contains("2") || MinuteStartTime[0].contains("3") || MinuteStartTime[0].contains("4") || MinuteStartTime[0].contains("5") || MinuteStartTime[0].contains("6")){
            MinuteStart = MinuteStartTime[0] + MinuteStartTime[1];
        }
        

        
        double startTimeInMintues = Integer.parseInt(StartTime) * 60;
        double stringToMinutes = Integer.parseInt(MinuteStart);
        double HoursAndMinutes = startTimeInMintues + stringToMinutes;
        //System.out.println(HoursAndMinutes);
        double startTimeInPixel = HoursAndMinutes * 0.685;
        int m_startTimeInPixel = (int) startTimeInPixel;
        
        String[] arrOfEndTime = endTime.split(":");
        String EndTime = "";
        
        String[] HourEndTime = arrOfEndTime[0].split("");
        if(HourEndTime[0].contains("0")){
            EndTime = HourEndTime[1];
        }
        if(HourEndTime[0].contains("1") || HourEndTime[0].contains("2")){
            EndTime = HourEndTime[0] + HourEndTime[1];
        }
        
        String[] MinuteEndTime = arrOfEndTime[1].split("");
        String MinuteEnd = "";
        if(MinuteEndTime[0].contains("0")){
            MinuteEnd = MinuteEndTime[1];
        }
        if(MinuteEndTime[0].contains("1") || MinuteEndTime[0].contains("2") || MinuteEndTime[0].contains("3") || MinuteEndTime[0].contains("4") || MinuteEndTime[0].contains("5") || MinuteEndTime[0].contains("6")){
            MinuteEnd = MinuteEndTime[0] + MinuteEndTime[1];
        }
        
        double endTimeInMintues = Integer.parseInt(EndTime) * 60;
        double stringToM = Integer.parseInt(MinuteEnd);
        double HoursAndMinutesEnd = endTimeInMintues + stringToM;
        System.out.println(HoursAndMinutesEnd);
        double endTimeInPixel = HoursAndMinutesEnd * 0.685;
        double getTimeBetween = endTimeInPixel - startTimeInPixel;
        int m_getTimeBetween = (int) getTimeBetween;

        
        //Inden en knap tilføjes, tilføjes en actionListener til knappen. 
        //Kilde: https://stackoverflow.com/a/27840774
        JButton button=new JButton(taskName);
        //Adds action event to all butons generated
        try{
            if(!isTeamTask){
                button.setName(ID);
            }
            else{
                String[] getTeamID = jComboBox1.getSelectedItem().toString().split(", ");
                int IDCorr = 3;
                button.setName(ID);
                IDCorr = IDCorr + 3;
            }
        }
        catch(Exception e){
            System.out.println("Fejl i henting af opgave ID");
        }
        

        //Inden en knap tilføjes, tilføjes en actionListener til knappen.
        button.addActionListener(new ActionListener(){
        /*
        *Af Benjamin: 
        *Når en knap trykkes på, åbnes "deleteTaskVindue", derudover sættes 
        *taskNameUpdater til knappens tekst, dette indeholder opgavens navn.
        *Samtidig sættes taskIDUpdater til knappens navn, navnet på knappen
        *er et unikt ID som hentes fra databasen
        */
        public void actionPerformed(ActionEvent e)
        {
            //Sæt opgave navn til opgave nummer: (taskID)?
            deleteTaskVindue deleteTaskVindue = new deleteTaskVindue();
            deleteTaskVindue.setVisible(true);
            
            taskNameUpdater = button.getText();
            taskIDUpdater = button.getName();
        }
        });
        buttons.add(button);
        
        
        
        int i = -1;
        
        int element = buttons.size()-1;
        i++;

        if(buttons.get(i).getY()<=0){
            button.setBounds(m_startTimeInPixel,2,m_getTimeBetween,35);
        }
        else{
           int nextTaskY = buttons.get(i).getBounds().y + (37*element);
           button.setBounds(m_startTimeInPixel,nextTaskY,m_getTimeBetween,35);
        }
       
        jPanel2.add(button);
        
        hasRun = true;
        
        jPanel2.repaint();
        jPanel2.revalidate();
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
            java.util.logging.Logger.getLogger(Hovedvindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hovedvindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hovedvindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hovedvindue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hovedvindue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTeam;
    private javax.swing.JButton createTeam;
    private javax.swing.JButton inviteUser;
    private javax.swing.JButton invites;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lbl00H;
    private javax.swing.JLabel lbl10H;
    private javax.swing.JLabel lbl11H;
    private javax.swing.JLabel lbl12H;
    private javax.swing.JLabel lbl13H;
    private javax.swing.JLabel lbl14H;
    private javax.swing.JLabel lbl15H;
    private javax.swing.JLabel lbl16H;
    private javax.swing.JLabel lbl17H;
    private javax.swing.JLabel lbl18H;
    private javax.swing.JLabel lbl19H;
    private javax.swing.JLabel lbl20H;
    private javax.swing.JLabel lbl21H;
    private javax.swing.JLabel lbl22H;
    private javax.swing.JLabel lbl23H;
    private javax.swing.JLabel lbl24h;
    private javax.swing.JButton signOut;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}
