/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;
import java.sql.*;  
/**
 *
 * @author Benjamin
 */
public class TODOListe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    //https://www.youtube.com/watch?v=3OrEsC-QjUA
    //https://www.youtube.com/watch?v=wR0jg0eQsZA
    //https://lucid.app/lucidchart/e53e4a47-b977-4c5a-a9ac-bafe41dcdf88/edit?beaconFlowId=F42B643A674C6E9F&page=0_0#
}

class DBConnection{
    public static void main(String args[]){
     try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListDatabase","application","Database");
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select * from emp");
         
         while(rs.next()){
             System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
         }
         con.close();
         
     }
     catch(Exception e){
         System.out.println(e);
     }
    }
}