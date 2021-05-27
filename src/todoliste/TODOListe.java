/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoliste;  

import java.sql.SQLException;

/**
 *
 * @author Benjamin
 */
public class TODOListe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        //Hovedvindue hovedvindue = new Hovedvindue();
        //hovedvindue.setVisible(true);
        
        LoginVindue loginvindue = new LoginVindue();
        loginvindue.setVisible(true);
        
    }
    
    
}