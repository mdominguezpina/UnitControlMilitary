/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Armamento {
    
    //Creamos los objetos que nos harán falta para crear los metodos
    Connection conn;
    BDConn bdConn = new BDConn();
    PreparedStatement preparedStatement;
    ResultSet resulset;
    
    public boolean insertarArmamento(ArmamentoClass armamentoClass){
        
        //Creamos nuestra sentencia para realizar los inserts en las tablas
        String insertarDatosArmamento = "INSERT INTO Armamento (Numero_arma,"
                + "Nombre_arma, Tipo, Calibre, Estado_armamento, TIM_personal) VALUES (?,?,?,?,?,?)";
        
        try {
            
            //Realizamos la conexión, y preparamos los Insert en nuestra base de datos
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(insertarDatosArmamento);
            
            preparedStatement.setString(1, armamentoClass.getNumArma());
            preparedStatement.setString(2, armamentoClass.getNombreArma());
            preparedStatement.setString(3, armamentoClass.getTipo());
            preparedStatement.setString(4, armamentoClass.getCalibre());
            preparedStatement.setString(5, armamentoClass.getEstadoArma());
            preparedStatement.setString(6, armamentoClass.getTIM());
            
            //Ejecutamos los inserts
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
             //Mensaje que nos saltará si no se pueden insertar los datos
            JOptionPane.showMessageDialog(null, "No ha sido "
                    + "posible la inserción de datos");
                    
            return false;
            
        }finally{
            
            //Cierre de conexión
            try {
                
                if(preparedStatement !=null){
                    preparedStatement.close();
                }
                if(conn !=null){
                    conn.close();
                }
                
            } catch (SQLException e) {
                
                System.err.println("Error al cerrrar la conexión");
                
            }
        }
    
        
    }
    
    public List listaArmamento(){
        
        //Creamos una lista para guardar los datos
        List<ArmamentoClass> listaArmamento = new ArrayList();
        
         //Realizamos un Select para obtener la informacion
        String consultaArmamento = "SELECT * FROM Armamento";
        
        try {
            //Nos conectamos y ejecutamos la sentencia
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaArmamento);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                ArmamentoClass armamentoClass = new ArmamentoClass();
                armamentoClass.setNumArma(resulset.getString("Numero_arma"));
                armamentoClass.setNombreArma(resulset.getString("Nombre_arma"));
                armamentoClass.setTipo(resulset.getString("Tipo"));
                armamentoClass.setCalibre(resulset.getString("Calibre"));
                armamentoClass.setEstadoArma(resulset.getString("Estado_armamento"));
                armamentoClass.setTIM(resulset.getString("TIM_personal"));
                
                //Los añadimos a la lista que hemos creado previamente
                listaArmamento.add(armamentoClass);
            
            }
            
        } catch (SQLException e) {
            
            //Mensaje que lanza si no se puede obtener los datos 
            JOptionPane.showMessageDialog(null, "No se "
                    + "puede listar");
              
        }
        
        return listaArmamento;
    }
    
   public boolean eliminarArmamento(String numArma){
       
       //Creamos la sentencia para eliminar los registros
       String eliminarArmamento = "DELETE FROM Armamento WHERE Numero_arma = ?";
       
       try {
            
           //Nos conectamos y ejecutamos la sentencia con el paramentro introducido 
            preparedStatement = conn.prepareStatement(eliminarArmamento);
            preparedStatement.setString(1, numArma);
            preparedStatement.execute();
            
            return true;
            
        } catch (SQLException e) {
            
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
   
   public boolean modificarArmamento(ArmamentoClass armamentoClass){
       
        //Creamos la sentencia para modificar los datos
       String modificarArmamento = "UPDATE Armamento SET Nombre_arma=?, Tipo=?, Calibre=?, "
               + "Estado_armamento=?, TIM_personal=? WHERE Numero_arma =?";
       
       try {
           
            //Realizamos la conexion y ejecutamos la sentencia para modificar los datos
            preparedStatement = conn.prepareStatement(modificarArmamento);
 
            preparedStatement.setString(1, armamentoClass.getNombreArma());
            preparedStatement.setString(2, armamentoClass.getTipo());
            preparedStatement.setString(3, armamentoClass.getCalibre());
            preparedStatement.setString(4, armamentoClass.getEstadoArma());
            preparedStatement.setString(5, armamentoClass.getTIM());
            preparedStatement.setString(6, armamentoClass.getNumArma());
            
             //Ejecutamos la sentencia
            preparedStatement.execute();
            
            return true;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido modificar el registro \n"
                    + "Por favor, verifica los datos introducidos");
            
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
