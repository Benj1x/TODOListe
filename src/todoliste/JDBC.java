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

/**
 *
 * @author Benjamin Høj
 */
//https://www.youtube.com/watch?v=3OrEsC-QjUA
    //https://www.youtube.com/watch?v=wR0jg0eQsZA
    //https://lucid.app/lucidchart/e53e4a47-b977-4c5a-a9ac-bafe41dcdf88/edit?beaconFlowId=F42B643A674C6E9F&page=0_0#

public class JDBC {
    public static void main() throws SQLException{
        String Query = "SELECT  * FROM users";
        
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         //username og password til min PHPAdmin host, plz don't haxor me
         Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select * from todolists");
         
         while(rs.next()){
             System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
         }
         con.close();     
     }
     
     catch(Exception e){
         System.out.println(e);
         e.printStackTrace();
     }
    }
    public static void addTask(String day, String TaskName, String StartTime, String EndTime) throws SQLException{
       //System.out.println(jTextField1.getText()+ " " + jTextField2.getText() + " " + jTextField3.getText());	
       /*
       Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
       Statement stmt = con.createStatement();
       
       //This is commented out to avoid doing a shit load of adding to the database
       ResultSet rs = stmt.executeQuery("INSERT INTO todolists (User_ID, Task_Name, Team_ID, Date, Begin_Time, End_Time) "
               + "VALUE (" + "UserID Here" + "'" + day + "'" + StartTime + "'" + EndTime + "'");
       
       //Need to handle doing it for a team too too
       System.out.println("INSERT INTO todolists (User_ID, Task_Name, Team_ID, Date, Begin_Time, End_Time) "
              + "VALUE (" + "UserID Here" + "'" + day + "'" + StartTime + "'" + EndTime + "'");
       */
    }
    public static void signIn() throws SQLException{
        //on user login get userID and save it for use in "userID" fields.
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        String x  = "email string";
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE users.Email = " + x);
        
        //Når login siden er lavet, så er query klar, vi skal bare tjekke om login oplysninger som brugeren giver er korrekt
    }
    public static void SignUp(String username, String email, String password) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://ams3.bisecthosting.com/mc80116","mc80116","9c8c12a856");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("INSERT INTO users (Username, Email, Password) VALUE ('" + "username" + "'" + "email" + "'" + "password" + "')");

    }
}

