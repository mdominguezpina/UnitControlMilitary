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
public class Login {
    //Creamos los objetos que nos harán falta para crear los metodos
    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet resulSet;
    BDConn bdConn = new BDConn();
    
    public LoginClass login ( String usuario, String password){
        
        //Creamos una instanncia de LoginClass y creamos nuestro Select
        //Con esto comprobaremos nuestro usuario y nuestra contraseña
        LoginClass loginClass = new LoginClass();
        String consulta = "SELECT *FROM usuario WHERE usuario = ? AND password = ?";
        
        try {
            //Realizamos la conexión y la comprobacion 
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consulta);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            resulSet=preparedStatement.executeQuery();
            
            if(resulSet.next()){
                loginClass.setId(resulSet.getInt("id"));
                loginClass.setUsuario(resulSet.getString("usuario"));
                loginClass.setPassword(resulSet.getString("password"));
                
            }   
            
        } catch (SQLException e) {
            
            System.err.println("No se ha podido comprobar el Login");
            
        }
        return loginClass;
    }
    
    
}
