/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.*;
/**
 *
 * @author Manuel
 */
public class BDConn {
    
    Connection conn;
    private static final String BD_USER = "Admin";
    private static final String BD_PASS = "1234";
    
    public Connection getConnection(){
        
        try {
            String BD = "jdbc:mysql://localhost:3306/Unit_Control_Military?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(BD,BD_USER,BD_PASS); 
            return conn;
            
        } catch (SQLException e) {
            System.out.println("No se ha podido realizar la conexion");
        }
        
        return null;
    }
    
    
}
