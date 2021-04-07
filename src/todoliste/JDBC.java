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
         ResultSet rs = stmt.executeQuery("select * from users");
         
         while(rs.next()){
             System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
         }
         con.close();
         
     }
     
     catch(Exception e){
         System.out.println(e);
         e.printStackTrace();
     }
    }
}

