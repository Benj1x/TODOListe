/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1>TODOList datahåndtering</h1>
 * Denne klasse står for at hente data ned fra vores database
 * <b> Note: </b> For at dette fungere bruges J-Connector library fra MYSQL
 * @author Benjamin O. Høj
 * 
 */
//https://www.youtube.com/watch?v=3OrEsC-QjUA
    //https://www.youtube.com/watch?v=wR0jg0eQsZA
    //https://lucid.app/lucidchart/e53e4a47-b977-4c5a-a9ac-bafe41dcdf88/edit?beaconFlowId=F42B643A674C6E9F&page=0_0#

public class JDBC {
    public static String GlobalUserID;
    public static ArrayList<String> inviteIDs = new ArrayList<String>();
    public static void main() throws SQLException{
        
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         //username og password til min PHPAdmin host, plz don't haxor me
         Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
         
         System.out.println("JDBC er live");
         con.close();     
     }
     
     catch(Exception e){
         System.out.println(e);
         e.printStackTrace();
         System.out.println("JDBC er offline");
     }
     
    }
    /**
   * Denne metode bruges til at manipulere databasen når en bruger
   * acceptere en hold invitation. This is
   * a the simplest form of a class method, just to
   * show the usage of various javadoc Tags.
   * @param teamID Den eneste parameter i acceptedInvite metoden
   * teamID parameteren indeholder et unikt tal til at indentificere 
   * hvert hold i databasen.
   * teamID er opbevaret i en String, Strings fylder mere end den 
   * primitive type int. Dette er gjort da ID'et bliver hentet ned 
   * som en String og da variablen ikke gemmes i programmet er impact minimalt
   */
    public static void acceptedInvite(String teamID) throws SQLException{

        
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM invites WHERE invited_User_ID = '" + JDBC.GlobalUserID + "' AND team_ID = '" + teamID + "'");
        
        stmt.executeUpdate("INSERT INTO relations (User_ID, team_ID) VALUE ('" + JDBC.GlobalUserID + "', '" + teamID + "');");
        //Feedback "invitationen er accpeteret velkommen til 'holdNavn'!"
        
        con.close(); 
        stmt.close();
        
    }
    
    public static void addTask(String day, String taskName, String startTime, String endTime) throws SQLException{
       //System.out.println(jTextField1.getText()+ " " + jTextField2.getText() + " " + jTextField3.getText());	
       //This works rev 1
       Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
       Statement stmt = con.createStatement();
       
       stmt.executeUpdate("INSERT INTO todolists (User_ID, Task_Name, Date, Begin_Time, End_Time) VALUE ('" + JDBC.GlobalUserID + "', '" + taskName + "', '" + day + "', " + "'" + startTime + "', '" + endTime + "')");
       con.close(); 
       stmt.close();
    }
    
    public static void addTeamTask(String teamID, String day, String taskName, String startTime, String endTime) throws SQLException{
       //System.out.println(jTextField1.getText()+ " " + jTextField2.getText() + " " + jTextField3.getText());	
       //This works rev 1
       Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
       Statement stmt = con.createStatement();
       
       stmt.executeUpdate("INSERT INTO todolists (Team_ID, Task_Name, Date, Begin_Time, End_Time) VALUE ('" + teamID + "', '" + taskName + "', '" + day + "', " + "'" + startTime + "', '" + endTime + "')");
       
       con.close(); 
       stmt.close();
    }
    
    public static void createTeam(String teamName) throws SQLException{
        
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Teams(Team_Name) VALUES ('" + teamName + "');");
        
        ResultSet rs = stmt.executeQuery("SELECT Team_ID FROM teams WHERE Team_Name = '" + teamName + "'");
        String newTeamID = "";
        
        while(rs.next()){
            newTeamID = rs.getString(1);
        }
        
        stmt.executeUpdate("INSERT INTO relations (User_ID, team_ID) VALUE ('" + JDBC.GlobalUserID + "', '" + newTeamID + "');");
        
        con.close();
        stmt.close();
        
        //Feedback "Hold: 'holdNavn' blev lavet!" 
    }
    
    public static void deleteTask(String date, String beginTime, String Endtime) throws SQLException{

        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        //Skal rettes til når GUI er mere klar
        stmt.executeUpdate("DELETE FROM todolists WHERE User_ID = '" + JDBC.GlobalUserID + "' AND Date = '30-04-2021' AND Begin_Time = '17:20' AND End_Time = '17:20'");
        
        con.close(); 
        stmt.close();
    }
    
    public static void deleteInvite(String teamID, String holdNavn) throws SQLException{

        
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM invites WHERE invited_User_ID = '" + JDBC.GlobalUserID + "' AND team_ID = '" + teamID + "'");
        
        con.close();
        stmt.close();
        //Skal rettes til når GUI er mere klar
        //Feedback bruger med "Invitation til hold 'holdnavn' er blevet slettet
        
        
    }
    
    public static boolean signIn(String loginEmail, String loginPassword) throws SQLException{
        //on user login get userID and save it for use in "userID" fields.
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        //This works, rev 1
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.Email = '" + loginEmail + "'");
        
        String userID = "";
        String username = "";
        String email = "";
        String password = "";
        
        while(rs.next()){
            userID = rs.getString(1);
            username = rs.getString(2);
            email = rs.getString(3);
            password = rs.getString(4);
        }
        JDBC.GlobalUserID = userID;
        
        
        if (loginPassword.equals(password)){
            con.close(); 
            stmt.close();
            JDBC.hasInvite();
            JDBC.getTasks();
            return true;
        } else{
            con.close(); 
            stmt.close();
            return false;
        }
        
    }
    
    public static String getUserDetails(String loginEmail) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.Email = '" + loginEmail + "'");
        
        String userID = "";
        String username = "";
        String email = "";
        String password = "";
        
        while(rs.next()){
             userID = rs.getString(1);
             username = rs.getString(2);
             email = rs.getString(3);
             password = rs.getString(4);
         }  
        con.close(); 
        stmt.close();
        return username;
    }
    
    public static String getUserID(String loginEmail) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
 
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.Email = '" + loginEmail + "'");
        
        
        String userID = "";
        String username = "";
        String email = "";
        String password = "";
        
        while(rs.next()){
             userID = rs.getString(1);
             username = rs.getString(2);
             email = rs.getString(3);
             password = rs.getString(4);
         }  
        con.close(); 
        stmt.close();
        return userID;
    }
    //Needs testing
    public static void sendInvite(String TeamID, String Email) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.Email = '" + Email + "'");
        
        if (Email.equals(rs.getString(3))){
            stmt.executeUpdate("INSERT INTO invites (invited_User_ID, team_ID, user_ID_sendInvite) SELECT invited.User_ID, '" + JDBC.GlobalUserID + "' AS Team_ID, '"+ TeamID +"' AS User_ID\n" +
            "FROM users invited WHERE invited.email = '" + Email + "'");
            System.out.println("Brugeren blev inviteret!");
        }
        else{
            System.out.println("Brugeren eksistere ikke!");
        }
        con.close(); 
        stmt.close();
    }
    
    public static boolean signUp(String username, String email, String password) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        //This works rev 1
        boolean userExists = false;
        ResultSet rs = stmt.executeQuery("SELECT users.User_ID FROM users WHERE Email= '" + email + "'");
        
        //Før vi tilføjer en bruger til databasen tjekker vi om brugeren existere
        //Vi tjekker ved at bruge en regex. "\\d" Tjeker efter et enkelt tal alt i mellem 0-9. Tal som 105 kommer altså ikke med 
        //Vi bruger derfor "*" til at sige 0 eller flere gange, tal som 105 bliver altså læst korrket.
        
        while (rs.next()){
        if (!rs.getString(1).matches("\\d*")){
            userExists = false;
            
        } else {
            userExists = true;
        }
        }
        if (!userExists){
            System.out.println("Denne email findes ikke, denne bruger blev lavet!");
            stmt.executeUpdate("INSERT INTO users (Username, Email, Password) VALUE ('" + username + "', '" + email + "', '" + password + "')");
        } 
        con.close(); 
        stmt.close();
        return userExists;
    }
    
    public static ArrayList getTasks() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();

        //This works rev 2
        ResultSet rs = stmt.executeQuery("SELECT users.Username, todolists.Task_Name, todolists.Date, todolists.Begin_Time, "
                + "todolists.End_Time FROM users, todolists WHERE users.User_ID='" + JDBC.GlobalUserID + "' AND todolists.User_ID= '" + JDBC.GlobalUserID + "'");
        
        ArrayList<String> getTaskArray = new ArrayList<>();
        
        while(rs.next()){
             //System.out.println(rs.getString(1));
             getTaskArray.add(rs.getString(3));
             getTaskArray.add(rs.getString(2));
             getTaskArray.add(rs.getString(4));
             getTaskArray.add(rs.getString(5));
         }
        
        
        con.close(); 
        stmt.close();
        
        return getTaskArray;
    }
    
    public static HashMap getUserTeams() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        
        //This works søg med bruger ID rev 2
        ResultSet rs = stmt.executeQuery("SELECT users.username, relations.Relations_ID, relations.User_ID, relations.Team_ID, teams.Team_Name, teams.Team_ID "
                + "FROM users, relations, teams WHERE users.User_ID='" + JDBC.GlobalUserID + "'AND relations.User_ID=users.User_ID AND teams.Team_ID=relations.Team_ID");
        
         HashMap<String, String> TeamInfo = new HashMap<String, String>();

        
        while(rs.next()){
             //System.out.println("Username: " + rs.getString(1));
             //System.out.println("Connection table ID: " + rs.getString(2));
             //System.out.println("UserID: " + rs.getString(3));
             //System.out.println("Team ID: " + rs.getString(4));
             TeamInfo.put(rs.getString(4),rs.getString(5));
             
         
        }
       con.close(); 
       stmt.close();
       return TeamInfo;
    }
    
    public static ArrayList getTeamTasks(String teamID) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();

        //This works søger med teamID, rev2 da vi finder Teams ID i getUserTeams, kan denne query forkortes
        ResultSet rs = stmt.executeQuery("SELECT todolists.Task_Name, todolists.Date, todolists.Begin_Time, todolists.End_Time "
                + "FROM todolists WHERE todolists.Team_ID='" + teamID + "'");  
        
        ArrayList<String> getTeamTaskArray = new ArrayList<>();
        
        while(rs.next()){
             getTeamTaskArray.add(rs.getString(2));
             getTeamTaskArray.add(rs.getString(1));
             getTeamTaskArray.add(rs.getString(3));
             getTeamTaskArray.add(rs.getString(4));
         }
       
        
        con.close(); 
        stmt.close();
        return getTeamTaskArray;
    
    }
    //Kaldes på login og igen når invitaioner accepteres
    public static boolean hasInvite() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_ID_sendInvite FROM invites WHERE invited_User_ID = '" + JDBC.GlobalUserID + "'");  
        
        while(rs.next()){
             inviteIDs.add(rs.getString(1));
         }
         JDBC.getInvites();
         
         
        if(rs.isAfterLast()){
            stmt.close();
            con.close(); 
            return true;
        } else {
            stmt.close();
            con.close(); 
            return false;
        }
       
    }
    //Har skrevet Query om, det var nemmere at få fat i invitationerne med rigtig info hvis jeg skrev den om i stedet
    //REV 1
    public static String getInvites() throws SQLException{
        
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT invites.invite_ID, invites.team_ID, invites.user_ID_sendInvite, users.username FROM"
                + " invites, users WHERE invites.invited_user_ID = " + JDBC.GlobalUserID + " AND users.User_ID = invites.user_ID_sendInvite");
       try{
        //TODO Oliver skal håndtere dette output så han kan bruge det i UI
        while(rs.next()){
             System.out.println("invite_ID: " + rs.getString(1));
             System.out.println("team_ID: " + rs.getString(2));
             System.out.println("user_ID_sendInvite: " + rs.getString(3));
             System.out.println("username: " + rs.getString(4));
         }
            con.close(); 
            stmt.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        return "";
    }
    
}