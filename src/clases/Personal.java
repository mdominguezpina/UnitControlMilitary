/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;


public class Personal {
    
    //Creamos los objetos que nos harán falta para crear los metodos
    Connection conn;
    BDConn bdConn = new BDConn();
    ResultSet resulset;
    PreparedStatement preparedStatement;
    
    
    public boolean insertarPersonal(PersonalClass personalClass){
        
        //Creamos nuestra sentencia para realizar los inserts en las tablas
        String insertarDatosPersonal = "INSERT INTO Personal (TIM_personal, "
                + "Nombre, Primer_apellido, Segundo_apellido, DNI, Rango, Estado_personal)"
                + "VALUES (?,?,?,?,?,?,?)";
        
        try {
            
            //Realizamos la conexión, y preparamos los Insert en nuestra base de datos
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(insertarDatosPersonal);
            
            preparedStatement.setString(1, personalClass.getTIM());
            preparedStatement.setString(2, personalClass.getNombre());
            preparedStatement.setString(3, personalClass.getPrimerApellido());
            preparedStatement.setString(4, personalClass.getSegundoApellido());
            preparedStatement.setString(5, personalClass.getDNI());
            preparedStatement.setString(6, personalClass.getRango());
            preparedStatement.setString(7, personalClass.getEstado());
            
            //Ejecutamos la sentencia
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
            //Mensaje que nos saltará si no se pueden insertar los datos
            JOptionPane.showMessageDialog(null, "No ha sido"
                    + " posible realizar la inserción de los datos. \n"
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
    
    public boolean insertarPersonalVehiculos(PersonalVehiculosClass personalVehiculosClass){
        
        //Creamos la sentencia para realizar los inserts en la tabla
        String insertarPersonalVehiculo = "INSERT INTO Personal_Vehiculos (TIM_personal,"
                + "Matricula_vehiculo) VALUES (?,?)";
              
        try {
        
        //Realizamos la conexión, y preparamos los Insert en nuestra BD. 
        conn = bdConn.getConnection();
        preparedStatement = conn.prepareStatement(insertarPersonalVehiculo);
        
        preparedStatement.setString(1, personalVehiculosClass.getTIM());
        preparedStatement.setString(2, personalVehiculosClass.getMatriculaVehiculo());
        
        //Ejecutamos la sentencia
        preparedStatement.execute();
        return true;
        
        
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No ha sido"
                    + " posible realizar la inserción de los datos.");           
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
    
    public boolean insertarTelefono (TelefonosClass telefonoClass){
        
        //Creamos la sentencia para crear los inserts en las tablas 
        String insertarTelefono = "INSERT INTO Telefonos (Numero_telefono, TIM_personal)"
                + "VALUES (?,?)";
        
        try {
        //Realizamos la conexion y preparamos los inserts en nuestra base de datos    
        conn = bdConn.getConnection();
        preparedStatement = conn.prepareStatement(insertarTelefono);
        
        preparedStatement.setInt(1, telefonoClass.getNumeroTelefono());
        preparedStatement.setString(2, telefonoClass.getTIM());
        
        //Ejecutamos las sentencias y nos devuelve true si se realiza la insercion 
        preparedStatement.execute();
        return true;
            
        } catch (SQLException e) {
            
            //Nos lanza el siguiente mensaje si no se realiza la insercion de los datos
            JOptionPane.showMessageDialog(null, "No ha sido"
                    + " posible realizar la inserción de los datos.");
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
    
    public List listaPersonal(){
        
        //Creamos una lista para guardar los datos
        List<PersonalClass> listaPersonal = new ArrayList();
        
        //Realizamos un Select para obtener la informacion
        String consultaPersonal = "SELECT * FROM Personal";
        
        try {
            
            //Nos conectamos y ejecutamos la sentencia
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaPersonal);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                //Obtenemos los datos de las diferentes columnas de la tabla 
                PersonalClass personalClass = new PersonalClass();
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                personalClass.setDNI(resulset.getString("DNI"));
                personalClass.setRango(resulset.getString("Rango"));
                personalClass.setEstado(resulset.getString("Estado_personal"));
                
                //Los añadimos a la lista que hemos creado previamente
                listaPersonal.add(personalClass);
                
            }
                        
        } catch (SQLException e) {
            
            //Mensaje que lanza si no se puede obtener los datos 
            System.out.println("No se ha podido listar");
            
        }
        
        return listaPersonal;
    }
    
    public List listaPersonalVehiculo(){
        
        //Creamos una lista para guardar los datos de nuestra tabla
        List<PersonalVehiculosClass> listaPersonalVehiculo = new ArrayList();
        
        //Realizamos un Select con los datos que queremos obtener
        String consultaPersonalVehiculo = "SELECT * FROM Personal_Vehiculos";
        
        try {
            //Nos conectamos a la base de datos y ejecutamos la sentencia
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaPersonalVehiculo);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
            //Recorremos la tabla obteniendo los datos de las diferentes columna
            PersonalVehiculosClass personalVehiculosClass = new PersonalVehiculosClass();
            personalVehiculosClass.setId(resulset.getInt("Id"));
            personalVehiculosClass.setTIM(resulset.getString("TIM_personal"));
            personalVehiculosClass.setMatriculaVehiculo(resulset.getString("Matricula_vehiculo"));
            
            //Lo añadimos a la lista que hemos creado previamente
            listaPersonalVehiculo.add(personalVehiculosClass);
            
            }
            
        } catch (SQLException e) {
            
            //Mensaje que lanza si no se puede obtener los datos 
           JOptionPane.showMessageDialog(null, "No se "
                    + "puede listar");
           
        }
        
        return listaPersonalVehiculo;
    }
    
    public List listaTelefono(){
        
        //Creamos una lista para guardar los datos de nuestra Base de datos
        List<TelefonosClass> listaTelefono = new ArrayList();
        
        //Creamos la sentencia para obtener los datos
        String consultarTelefono = "SELECT * FROM Telefonos";
        
        try {
            //Realizamos la conexion y ejecutamos la sentencia
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultarTelefono);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
            
            //Recorremos la tabla obteniendo los datos de las columnas
            TelefonosClass telefonoClass = new TelefonosClass();            
            telefonoClass.setId(resulset.getInt("Id"));
            telefonoClass.setNumeroTelefono(resulset.getInt("Numero_telefono"));
            telefonoClass.setTIM(resulset.getString("TIM_personal"));
            
            //Añadimos los datos a la lista creada previamente
            listaTelefono.add(telefonoClass);
            
            }
            
        } catch (SQLException e) {
           
            //Mensaje que lanza si no se puede obtener los datos 
           JOptionPane.showMessageDialog(null, "No se "
                    + "puede listar");      

        }
        
        return listaTelefono;
    }
        
    public boolean eliminarPersonal(String TIM){
        
        //Creamos la sentencia para eliminar los registros
        String eliminarPersonal = "DELETE FROM Personal WHERE TIM_personal = ?";
        
        try {
            
            //Nos conectamos y ejecutamos la sentencia con el paramentro introducido 
            preparedStatement = conn.prepareStatement(eliminarPersonal);
            preparedStatement.setString(1, TIM);
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
            //Mensaje que nos salta si no se puede eliminar el registro 
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido eliminar el registro");
            return false;
            
        }finally{
            //Cerramos la conexion
            try {  
                conn.close();      
            } catch (SQLException e) {               
                System.out.println("No ha sido posible cerrar la conexion");  
            }
        }
        
    }
    
    public boolean eliminarPersonalVehiculo(String Id){
        
        //Creamos la sentencia para eliminar el reigstro 
        String eliminarPersonalVehiculo = "DELETE FROM Personal_Vehiculos WHERE Id = ?";
        
        try {
            //Nos conectamos y ejecutamos la sentencia por el id
            preparedStatement = conn.prepareStatement(eliminarPersonalVehiculo);
            preparedStatement.setString(1, Id);
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("No ha sido posible eliminar el registro");
            return false;
           
        //Cerramos la conexion 
        }finally{
            //Cerramos la conexion 
            try {  
                conn.close();   
            } catch (SQLException e) {               
                JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido eliminar el registro");
   
            }
        }
        
    }
    
    public boolean eliminarTelefono(String Id ){
        
        //Realizamos la sentencia para eliminar los registros 
        String eliminarTelefono = "DELETE FROM Telefonos WHERE Id = ?";
        
        try {
            //Nos conectamos y ejecutamos la sentencia por el Id del resgistro
            preparedStatement = conn.prepareStatement(eliminarTelefono);
            preparedStatement.setString(1, Id);
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido eliminar el registro");
            return false;
            
        }finally{
            //Cerramos la conexion
            try { 
                conn.close();  
            } catch (SQLException e) {
                System.out.println("No ha sido posible cerrar la conexion");  
            }
        }
        
    }
    
    public boolean modificarPersonal(PersonalClass personalClass){
        
        //Creamos la sentencia para modificar los datos 
        String modificarPersonal = "UPDATE Personal SET Nombre=?,Primer_apellido=?,"
                + " Segundo_apellido=?, DNI=?, Rango=?, Estado_personal=? WHERE "
                + "TIM_personal=?";
        
        try {
            
            //Realizamos la conexion y ejecutamos la sentencia para modificar los datos
            preparedStatement = conn.prepareStatement(modificarPersonal);
 
            preparedStatement.setString(1, personalClass.getNombre());
            preparedStatement.setString(2, personalClass.getPrimerApellido());
            preparedStatement.setString(3, personalClass.getSegundoApellido());
            preparedStatement.setString(4, personalClass.getDNI());
            preparedStatement.setString(5, personalClass.getRango());
            preparedStatement.setString(6, personalClass.getEstado());
            preparedStatement.setString(7, personalClass.getTIM());
            
            //Ejecutamos la sentencia
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
           System.out.println("No ha sido posible modificar el registro \n "
                    + "Por favor, verifica los campos");
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
    
    public boolean modificarPersonalVehiculo(PersonalVehiculosClass personalVehculoClass){
        
        //Creamos la sentencia para modificar los datos
        String modificarPersonalVehiculo = "UPDATE Personal_Vehiculos SET TIM_personal=?,Matricula_vehiculo=? "
                + "WHERE Id=?";
        
        try {
            //Realizamos la conexion y ejecutamos la sentencia
            preparedStatement = conn.prepareStatement(modificarPersonalVehiculo);
 
            preparedStatement.setString(1, personalVehculoClass.getTIM());
            preparedStatement.setString(2, personalVehculoClass.getMatriculaVehiculo());
            preparedStatement.setInt(3, personalVehculoClass.getId());
            
            //Ejecutamos la sentencia
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No ha sido posible modificar el"
                    + "registro \n Verifica que el campo tim o matricula existe ");
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
    
    public boolean modificarTelefonos(TelefonosClass telefonoClass){
        
        //Creamos la sentencia para modificar los datos 
        String modificarTelefono = "UPDATE Telefonos SET Numero_telefono=?, TIM_personal=? "
                + " WHERE Id=?";
        
        try {
            //Nos conectamos y ejecutamos la sentencia para eliminar los registros
            preparedStatement = conn.prepareStatement(modificarTelefono);
 
            preparedStatement.setInt(1, telefonoClass.getNumeroTelefono());
            preparedStatement.setString(2, telefonoClass.getTIM());
            preparedStatement.setInt(3, telefonoClass.getId());
            
            //Ejecutamos la sentencia
            preparedStatement.execute();
            return true;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No ha sido posible modificar el"
                    + "registro \n Verifica que el campo tim existe ");
            
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
