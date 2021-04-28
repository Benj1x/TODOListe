/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Benjamin Høj
 */
//https://www.youtube.com/watch?v=3OrEsC-QjUA
    //https://www.youtube.com/watch?v=wR0jg0eQsZA
    //https://lucid.app/lucidchart/e53e4a47-b977-4c5a-a9ac-bafe41dcdf88/edit?beaconFlowId=F42B643A674C6E9F&page=0_0#

public class JDBC {
    public static String GlobalUserID;
    
    public static void main() throws SQLException{
        String Query = "SELECT  * FROM users";
        
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         //username og password til min PHPAdmin host, plz don't haxor me
         Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select * from todolists");
         
         String x = "";
         while(rs.next()){
             x = rs.getString(1);
             System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
         }
         
         System.out.println(x);
         con.close();     
     }
     
     catch(Exception e){
         System.out.println(e);
         e.printStackTrace();
     }
     
    }
    public static void addTask(String day, String taskName, String startTime, String endTime) throws SQLException{
       //System.out.println(jTextField1.getText()+ " " + jTextField2.getText() + " " + jTextField3.getText());	
       //This works rev 1
       Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
       Statement stmt = con.createStatement();
       String userID = JDBC.GlobalUserID;
       
       stmt.executeUpdate("INSERT INTO todolists (User_ID, Task_Name, Date, Begin_Time, End_Time) VALUE ('" + userID + "', '" + taskName + "', '" + day + "', " + "'" + startTime + "', '" + endTime + "')");
       
    }
    
    public static void addTeamTask(String teamID, String day, String taskName, String startTime, String endTime) throws SQLException{
       //System.out.println(jTextField1.getText()+ " " + jTextField2.getText() + " " + jTextField3.getText());	
       //This works rev 1
       Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
       Statement stmt = con.createStatement();
       
       stmt.executeUpdate("INSERT INTO todolists (Team_ID, Task_Name, Date, Begin_Time, End_Time) VALUE ('" + teamID + "', '" + taskName + "', '" + day + "', " + "'" + startTime + "', '" + endTime + "')");
       
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
            System.out.println("Logget ind på bruger: " + username);
            return true;
        } else{
            System.out.println("Ikke logget ind.");
            return false;
        }
        
        //Når login siden er lavet, så er query klar, vi skal bare tjekke om login oplysninger som brugeren giver er korrekt
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
        return userID;
    }
    
    public static void signUp(String username, String email, String password) throws SQLException{
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

    }
    
    public static void getTasks(String userID) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
       
        //This works rev 2
        ResultSet rs = stmt.executeQuery("SELECT users.Username, todolists.Task_Name, todolists.Date, todolists.Begin_Time, "
                + "todolists.End_Time FROM users, todolists WHERE users.User_ID='" + userID + "' AND todolists.User_ID= '" + userID + "'");

        while(rs.next()){
             System.out.println(rs.getString(1));
             System.out.println(rs.getString(2));
             System.out.println(rs.getString(3));
             System.out.println(rs.getString(4));
             System.out.println(rs.getString(5));
         }
        
    }
    
    public static HashMap getUserTeams(String userID) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        
        //This works søg med bruger ID rev 2
        ResultSet rs = stmt.executeQuery("SELECT users.username, relations.Relations_ID, relations.User_ID, relations.Team_ID, teams.Team_Name, teams.Team_ID "
                + "FROM users, relations, teams WHERE users.User_ID='" + userID + "'AND relations.User_ID=users.User_ID AND teams.Team_ID=relations.Team_ID");
        
         HashMap<String, String> TeamInfo = new HashMap<String, String>();

        
        while(rs.next()){
             //System.out.println("Username: " + rs.getString(1));
             //System.out.println("Connection table ID: " + rs.getString(2));
             //System.out.println("UserID: " + rs.getString(3));
             //System.out.println("Team ID: " + rs.getString(4));
             TeamInfo.put(rs.getString(4),rs.getString(5));
             
         
        }
       return TeamInfo;
    }
    
    public static void getTeamTasks(String teamID) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();

        //This works søger med teamID, rev2 da vi finder Teams ID i getUserTeams, kan denne query forkortes
        ResultSet rs = stmt.executeQuery("SELECT todolists.Task_Name, todolists.Date, todolists.Begin_Time, todolists.End_Time "
                + "FROM todolists WHERE todolists.Team_ID='" + teamID + "'");  
        
        while(rs.next()){
             System.out.println("Task name: " + rs.getString(1));
             System.out.println("Date: " + rs.getString(2));
             System.out.println("Starting time: " + rs.getString(3));
             System.out.println("End time: " + rs.getString(4));
         }
        

    }
    
}

