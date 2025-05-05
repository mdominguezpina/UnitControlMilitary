
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manuel
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Vehiculos {
    
    Connection conn;
    BDConn bdConn = new BDConn();
    ResultSet resulset;
    PreparedStatement preparedStatement;
    
    public boolean insertarVehiculo (VehiculosClass vehiculoClass){
        
        String InsertarDatosVehiculo = "INSERT INTO Vehiculos (Matricula_vehiculo,"
                + "Nombre_vehiculo, Tipo, Kilometros, Estado_vehiculo) VALUES (?,?,?,?,?)";
        
        try {
            
            //Realizamos la conexión y preparamos los inserts en nuestra BD
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(InsertarDatosVehiculo);
            
            preparedStatement.setString(1, vehiculoClass.getMatriculaVehiculo());
            preparedStatement.setString(2, vehiculoClass.getNombreVehiculo());
            preparedStatement.setString(3, vehiculoClass.getTipo());
            preparedStatement.setString(4, vehiculoClass.getKilometros());
            preparedStatement.setString(5, vehiculoClass.getEstado());
            
            //Con esta sentencia, ejecutamos el insert, y nos devuelve true
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No ha sido"
                    + " posible realizar la inserción de los datos.");
            e.printStackTrace();
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
    
    public List listaVehiculos(){
        
        List<VehiculosClass> listaVehiculos = new ArrayList();
        
        String consultaVehiculo = "Select * FROM Vehiculos";
        
        try {
            
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaVehiculo);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
            
            VehiculosClass vehiculoClass = new VehiculosClass();
            
            vehiculoClass.setMatriculaVehiculo(resulset.getString("Matricula_vehiculo"));
            vehiculoClass.setNombreVehiculo(resulset.getString("Nombre_vehiculo"));
            vehiculoClass.setTipo(resulset.getString("Tipo"));
            vehiculoClass.setKilometros(resulset.getString("Kilometros"));
            vehiculoClass.setEstado(resulset.getString("Estado_vehiculo"));
            
            listaVehiculos.add(vehiculoClass);
            
        }
            
        } catch (SQLException e) {
            
            System.out.println("No se ha podido listar");
            e.printStackTrace(); 
            
        }
        
        return listaVehiculos;
        
    }
    
    public boolean eliminarVehiculo(String matriculaVehiculo){
        
        String eliminarArmamento = "DELETE FROM Vehiculos WHERE Matricula_Vehiculo = ?";
       
       try {
            
            preparedStatement = conn.prepareStatement(eliminarArmamento);
            preparedStatement.setString(1, matriculaVehiculo);
            preparedStatement.execute();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("No ha sido posible eliminar");
            e.printStackTrace();
            return false;
            
        }finally{
            
            try {
                
                conn.close();
                
            } catch (SQLException e) {
                
                System.out.println("No ha sido posible cerrar la conexion");
                e.printStackTrace();
                
            }
        }
        
    }
    
    
    public boolean modificarVehiculo(VehiculosClass vehiculoClass){
        
        String modificarVehiculo = "UPDATE Vehiculos SET Nombre_vehiculo=?, Tipo=?, Kilometros=?,"
                + "Estado_vehiculo=? WHERE Matricula_vehiculo=? ";
               
        try {
            
            preparedStatement = conn.prepareStatement(modificarVehiculo);
 
            preparedStatement.setString(1, vehiculoClass.getNombreVehiculo());
            preparedStatement.setString(2, vehiculoClass.getTipo());
            preparedStatement.setString(3, vehiculoClass.getKilometros());
            preparedStatement.setString(4, vehiculoClass.getEstado());
            preparedStatement.setString(5, vehiculoClass.getMatriculaVehiculo());
            
            preparedStatement.execute();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("No ha sido posible modificar el registro");
            e.printStackTrace();
            return false;
            
        }finally{
            
            try {
                
                conn.close();
                
            } catch (SQLException e) {
                
                System.out.println("No ha sido posible cerrar la conexion");
                
            }
            
        }
        
    }
    
    
}
