/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Transmisiones {
    
    //Creamos los objetos que nos harán falta para crear los metodos
    Connection conn;
    BDConn bdConn = new BDConn();
    PreparedStatement preparedStatement; 
    ResultSet resulset;
    
    public boolean insertarTransmision( TransmisionesClass transmisionesClass){
        
         //Creamos nuestra sentencia para realizar los inserts en las tablas
        String insertarDatosTransmision = "INSERT INTO Transmisiones (Numero_transmision,"
                + "Nombre_transmision, Tipo, Estado_transmision, TIM_personal) VALUES (?,?,?,?,?)";
        
        try {
            
            //Realizamos la conexión, y preparamos los Insert en nuestra base de datos
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(insertarDatosTransmision);
            preparedStatement.setString(1, transmisionesClass.getNumeroTransmision());
            preparedStatement.setString(2, transmisionesClass.getNombreTransmision());
            preparedStatement.setString(3, transmisionesClass.getTipo());
            preparedStatement.setString(4, transmisionesClass.getEstado());
            preparedStatement.setString(5, transmisionesClass.getTIM());
            
            //Ejecutamos la sentencia
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
             //Mensaje que nos saltará si no se pueden insertar los datos
            JOptionPane.showMessageDialog(null, "No ha sido"
                    + " posible realizar la inserción de los datos. \n "
                    + "Verifica los datos introducidos");
            return false;
            
        }finally{
            
             //Cierre de la conexion
            try {
                if(preparedStatement !=null){
                    preparedStatement.close();
                }
                    
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión");
            }
            
        }
        
    }
    
    public List listaTransmisiones(){
        
        //Creamos una lista para guardar los datos
        List<TransmisionesClass> listaTransmisiones = new ArrayList();
        
        //Realizamos un Select para obtener la informacion
        String consultaTransmisiones = "SELECT * FROM Transmisiones";
        
        try {
            
            //Nos conectamos y ejecutamos la sentencia
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaTransmisiones);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                TransmisionesClass transmisionesClass = new TransmisionesClass();
                transmisionesClass.setNumeroTransmision(resulset.getString("Numero_transmision"));
                transmisionesClass.setNombreTransmision(resulset.getString("Nombre_transmision"));
                transmisionesClass.setTipo(resulset.getString("Tipo"));
                transmisionesClass.setEstado(resulset.getString("Estado_transmision"));
                transmisionesClass.setTIM(resulset.getString("TIM_personal"));
                
                //Los añadimos a la lista que hemos creado previamente
                listaTransmisiones.add(transmisionesClass);
                
            }
            
            
        } catch (SQLException e) {
            
            //Mensaje que lanza si no se puede obtener los datos 
            JOptionPane.showMessageDialog(null, "No se "
                    + "puede listar");
            
        }
        
        return listaTransmisiones;
    }
    
    public boolean eliminarTransmision(String numeroTransmision){
        
        //Creamos la sentencia para eliminar los registros
        String eliminarTransmision = "DELETE FROM Transmisiones WHERE Numero_transmision = ?";
       
        try {
            
            //Nos conectamos y ejecutamos la sentencia con el paramentro introducido 
            preparedStatement = conn.prepareStatement(eliminarTransmision);
            preparedStatement.setString(1, numeroTransmision);
            preparedStatement.execute();
            return true;
            
        }catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido eliminar el registro");
            return false;
        
         //Cerramos la conexion
        }finally{
            
            try {
                
                conn.close();
                
            } catch (SQLException e) {
                
                System.out.println("No ha sido posible cerrar la conexion");
                  
            }
        }
        
    }
    
    public boolean modificarTransmisiones(TransmisionesClass transmisionesClass){
        
        //Creamos la sentencia para modificar los datos
        String modificarTransmisiones = "UPDATE Transmisiones SET Nombre_transmision=?, Tipo=?, "
                + "Estado_transmision=?, TIM_personal=? WHERE Numero_transmision=?";
        
        try {
            
            //Realizamos la conexion y ejecutamos la sentencia para modificar los datos
            preparedStatement = conn.prepareStatement(modificarTransmisiones);
 
            preparedStatement.setString(1, transmisionesClass.getNombreTransmision());
            preparedStatement.setString(2, transmisionesClass.getTipo());
            preparedStatement.setString(3, transmisionesClass.getEstado());
            preparedStatement.setString(4, transmisionesClass.getTIM());
            preparedStatement.setString(5, transmisionesClass.getNumeroTransmision());
            
            //Ejecutamos la sentencia
            preparedStatement.execute();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("No ha sido posible modificar el registro \n "
                    + "Por favor, verifica que el campo tim existe");
            
            return false;
         //Cerramos la conexion  
        }finally{
            
            try {
                
                conn.close();
                
            } catch (SQLException e) {
                
                System.out.println("No ha sido posible cerrar la conexion");
                
            }
            
        }
        
    }
    
}
