/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
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


/**
 *
 * @author olive
 */
public class Hovedvindue extends javax.swing.JFrame {

    /**
     * Creates new form Hovedvindue
     */
    private int dateTracker = 0;

    
    public Hovedvindue() { 

        initComponents();
        //setTaskButton();
        
        setDateText();
        
        AddToComboBox();
        
        
        
        
        
        
    }
    
    
    private void AddToComboBox(){
        jComboBox1.addItem("Min liste");
        
        try{           
                for (Object i : JDBC.getUserTeams().keySet()) {
                    jComboBox1.addItem(JDBC.getUserTeams().get(i).toString() + ", " + i);
                }   
        }
        catch(Exception e){
            //System.out.println("Something went wrong when adding teams to the combobox");
            e.getStackTrace();
        }
        
        
        
    }
    
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
    
    public void checkTaskDates(){
    
    
    }

    public static void taskHandler(){
        
        
        if(jComboBox1.getSelectedItem() == "Min liste"){
            try{
                if(JDBC.getTasks().size() <= 4){
                    setTaskButton(JDBC.getTasks().get(1).toString(), JDBC.getTasks().get(2).toString(), JDBC.getTasks().get(3).toString());
                    //System.out.println(JDBC.getTasks().get(0).toString()+JDBC.getTasks().get(1).toString()+JDBC.getTasks().get(2).toString());
                }
                if(JDBC.getTasks().size() > 4){
                    int amount = JDBC.getTasks().size() / 4;
                    
                    for(int i = 0; i < amount; i++){
                        if(i == 0){
                            setTaskButton(JDBC.getTasks().get(1).toString(), JDBC.getTasks().get(2).toString(), JDBC.getTasks().get(3).toString());
                            //System.out.println(JDBC.getTasks().get(0).toString()+JDBC.getTasks().get(1).toString()+JDBC.getTasks().get(2).toString()+JDBC.getTasks().get(3).toString());
                        }
                        setTaskButton(JDBC.getTasks().get(i+5).toString(), JDBC.getTasks().get(i+6).toString(), JDBC.getTasks().get(i+7).toString());
                        //System.out.println(JDBC.getTasks().get(i+4).toString()+JDBC.getTasks().get(i+5).toString()+JDBC.getTasks().get(i+6).toString()+JDBC.getTasks().get(i+7).toString());
                    }
                }
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }
        if(jComboBox1.getSelectedItem() != "Min liste"){
            try{
                String[] ArrOfTeamID = jComboBox1.getSelectedItem().toString().split(", ");
                if(JDBC.getTeamTasks(ArrOfTeamID[1]).size() <= 4){
                    setTaskButton(JDBC.getTeamTasks(ArrOfTeamID[1]).get(1).toString(), JDBC.getTeamTasks(ArrOfTeamID[1]).get(2).toString(), JDBC.getTeamTasks(ArrOfTeamID[1]).get(3).toString());
                    //System.out.println(JDBC.getTeamTasks(ArrOfTeamID[1]).get(0).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(1).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(2).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(3).toString());
                }
                if(JDBC.getTeamTasks(ArrOfTeamID[1]).size() > 4){
                    int teamAmount = JDBC.getTeamTasks(ArrOfTeamID[1]).size() / 4;
                    
                    for(int j = 0; j < teamAmount; j++){
                        if(j == 0){
                            setTaskButton(JDBC.getTeamTasks(ArrOfTeamID[1]).get(1).toString(), JDBC.getTeamTasks(ArrOfTeamID[1]).get(2).toString(), JDBC.getTeamTasks(ArrOfTeamID[1]).get(3).toString());
                            //System.out.println(JDBC.getTeamTasks(ArrOfTeamID[1]).get(0).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(1).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(2).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(3).toString());
                        }
                        setTaskButton(JDBC.getTeamTasks(ArrOfTeamID[1]).get(j+5).toString(), JDBC.getTeamTasks(ArrOfTeamID[1]).get(j+6).toString(), JDBC.getTeamTasks(ArrOfTeamID[1]).get(j+7).toString());
                        //System.out.println(JDBC.getTeamTasks(ArrOfTeamID[1]).get(j+4).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(j+5).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(j+6).toString() + JDBC.getTeamTasks(ArrOfTeamID[1]).get(j+7).toString());
                    }
                }
                //JDBC.getTeamTasks(ArrOfTeamID[1]);
            }
            catch(Exception e){
                e.getStackTrace();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        invites = new javax.swing.JButton();
        createTeam = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        usernameLbl = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("To-Do Liste");
        setBackground(new java.awt.Color(102, 102, 102));
        setExtendedState(1);
        setForeground(java.awt.Color.yellow);

        jPanel3.setMaximumSize(new java.awt.Dimension(22, 22));

        jLabel2.setText("24:00");

        jLabel3.setText("0:00");

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("29-03-2021");

        jLabel1.setText("6:00");

        jLabel5.setText("18:00");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todoliste/calendar-arrow-right.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todoliste/calendar-arrow-left.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todoliste/add-task-button.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/todoliste/trash-task-button.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setPreferredSize(new java.awt.Dimension(33, 33));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        invites.setText("Invitationer");
        invites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invitesActionPerformed(evt);
            }
        });

        createTeam.setText("Lav hold");
        createTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTeamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createTeam)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(jLabel5)
                        .addGap(184, 184, 184)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(invites)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createTeam))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invites))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator6)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(516, 516, 516)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton3.setText("jButton3");

        jButton4.setText("jButton3");

        jButton5.setText("jButton3");

        jButton6.setText("jButton3");

        jButton7.setText("jButton3");

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

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton10.setText("Log af");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameLbl)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(85, 85, 85)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TilføjVindue tilføjvindue = new TilføjVindue();
        tilføjvindue.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //TODO: Slet funktion
    }//GEN-LAST:event_jButton2ActionPerformed

    //Calendar calendar = Calendar.getInstance();
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, dateTracker++);
            SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
            //calendar.add(Calendar.DATE, dateTracker++);
            jLabel4.setText(SDF.format(calendar.getTime()).toString());
            
            JDBC.selDate = jLabel4.getText();;
            try{
                JDBC.getTasks();
            } catch(Exception e){
                
            }
            

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        hasRun = false;
        buttons.clear();
        LoginVindue login = new LoginVindue();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void usernameLblAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_usernameLblAncestorAdded
        try{
            usernameLbl.setText(JDBC.getUserDetails(LoginVindue.emailFieldText));
            
        }
        catch(Exception e){
            System.out.println("ERROR IN GETTING USER DETAILS!");
            e.getStackTrace();
        }
    }//GEN-LAST:event_usernameLblAncestorAdded

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dateTracker--);
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        //calendar.add(Calendar.DATE, dateTracker--);
        jLabel4.setText(SDF.format(calendar.getTime()).toString());
        
        JDBC.selDate = jLabel4.getText();
            try{
                JDBC.getTasks();
            } catch(Exception e){
                
            }

    }//GEN-LAST:event_jButton9ActionPerformed


    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        if(evt.getStateChange() == 1 && hasRun != false){
            
            for(JButton e : buttons){
                jPanel2.remove(e);
            }
            buttons.clear();
            jPanel2.revalidate();
            jPanel2.repaint();
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

    public static ArrayList<JButton> buttons = new ArrayList<>();
    public static boolean hasRun = false;

    public static void setTaskButton(String taskName, String beginTime, String endTime){
        
        /*
        For at kunne udregne vores starttidspunkt, brugte jeg en matematisk tankegang.
        Da at teksten bliver omskrevet til en double og derefter ganget med 60 (fra timer til minutter).
        Herefter ganger jeg de antal minutter som blev fundet, med vores værdi for hvor mange pixels der er tilrådighed epr minut.
        Jeg omdanner den til en integer, for at vi kan indsætte den i en JButton.setBounds().
        */
        //TilføjVindue.date.getText()
        
        
        
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

        JButton button=new JButton(taskName);
        
        
        buttons.add(button);
        
        
        
        int i = -1;

        int element = buttons.size()-1;
        i++;

        if(buttons.get(i).getY()<=0){
            button.setBounds(m_startTimeInPixel,100,m_getTimeBetween,35);
        }
        else{
           int nextTaskY = buttons.get(i).getBounds().y + (45*element);
           button.setBounds(m_startTimeInPixel,nextTaskY,m_getTimeBetween,35);
           System.out.println(nextTaskY);
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
    private javax.swing.JButton createTeam;
    private javax.swing.JButton invites;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}
