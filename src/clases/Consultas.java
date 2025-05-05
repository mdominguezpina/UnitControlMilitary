/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class Consultas{
    
    //Creamos los objetos que nos harán falta para añadirle funcionalidad a la interfaz
    Connection conn;
    BDConn bdConn = new BDConn();
    ResultSet resulset;
    PreparedStatement preparedStatement;
    PersonalClass personalClass;
    ArmamentoClass armamentoClass;
    VehiculosClass vehiculosClass = new VehiculosClass();
    TransmisionesClass transmisionesClass = new TransmisionesClass();
    TelefonosClass telefonosClass = new TelefonosClass();
    
    
    public List consultaPersonalNombre(String nombre){
        
        //Creamos una lista para guardar los datos de la consulta
        List<PersonalClass> listaPersonalNombre = new ArrayList();
        //Creamos la consulta
        String consultaPersonalNombre = "SELECT * FROM Personal WHERE Nombre=?";

        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaPersonalNombre);
            preparedStatement.setString(1, nombre);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                personalClass = new PersonalClass();
                //Obtenemos los datos y los guardamos en la lista
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                personalClass.setDNI(resulset.getString("DNI"));
                personalClass.setRango(resulset.getString("Rango"));
                personalClass.setEstado(resulset.getString("Estado_personal"));
                //Los añadimos a la lista que hemos creado previamente
                listaPersonalNombre.add(personalClass);
                
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
            
        }
        
        return listaPersonalNombre;
    }
    
    public List consultaPersonalTIM(String tim){
        
        //Creamos una lista para guardar los datos de la consulta
        List<PersonalClass> listaPersonalTIM = new ArrayList();
        //Creamos la consulta
        String consultaPersonalTIM = "SELECT * FROM Personal WHERE TIM_personal=?";

        try {
             //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaPersonalTIM);
            preparedStatement.setString(1, tim);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                personalClass = new PersonalClass();
                //Obtenemos los datos y los guardamos en la lista
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                personalClass.setDNI(resulset.getString("DNI"));
                personalClass.setRango(resulset.getString("Rango"));
                personalClass.setEstado(resulset.getString("Estado_personal"));
                
                //Los añadimos a la lista que hemos creado previamente
                listaPersonalTIM.add(personalClass);
                
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaPersonalTIM;
        
        
    }
    
    public List consultaPersonalEstado(String estado){
        
        //Creamos una lista para guardar los datos de la consulta
        List<PersonalClass> listaPersonalEstado = new ArrayList();
        //Creamos la consulta
        String consultaPersonalEstado = "SELECT * FROM Personal WHERE Estado_personal=?";

        try {
             //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaPersonalEstado);
            preparedStatement.setString(1, estado);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                personalClass = new PersonalClass();
                //Obtenemos los datos y los guardamos en la lista
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                personalClass.setDNI(resulset.getString("DNI"));
                personalClass.setRango(resulset.getString("Rango"));
                personalClass.setEstado(resulset.getString("Estado_personal"));
                //Los añadimos a la lista que hemos creado previamente
                listaPersonalEstado.add(personalClass);
                
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaPersonalEstado;
     
    }
    
    public List consultaArmamentoNombre(String nombre){
        
        //Creamos una lista para guardar los datos de la consulta
        List<ArmamentoClass> listaArmamentoNombre = new ArrayList();
        //Creamos la consulta
        String consultaArmamentoNombre = "SELECT Personal.TIM_personal, Personal.Nombre,"
                + "Personal.Primer_apellido, Personal.Segundo_apellido, Armamento.Numero_arma,"
                + "Armamento.Nombre_arma, Armamento.Estado_armamento FROM Personal INNER JOIN Armamento ON "
                + "Personal.TIM_personal = Armamento.TIM_personal " 
                + "WHERE Personal.Nombre = ?";
        
        try {
             //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaArmamentoNombre);
            preparedStatement.setString(1, nombre);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                armamentoClass = new ArmamentoClass(); 
                personalClass = new PersonalClass();
                
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                armamentoClass.setNumArma(resulset.getString("Numero_arma"));
                armamentoClass.setNombreArma(resulset.getString("Nombre_arma"));
                armamentoClass.setEstadoArma(resulset.getString("Estado_armamento"));
                
                //Los añadimos a la lista que hemos creado previamente
                listaArmamentoNombre.add(armamentoClass);
                                   
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaArmamentoNombre;
        
        
    }
    
    public List consultaArmamentoTIM(String tim){
        
        //Creamos una lista para guardar los datos de la consulta
        List<ArmamentoClass> listaArmamentoNombre = new ArrayList();
        //Creamos la consulta
        String consultaArmamentoNombre = "SELECT Personal.TIM_personal, Personal.Nombre,"
                + "Personal.Primer_apellido, Personal.Segundo_apellido, Armamento.Numero_arma,"
                + "Armamento.Nombre_arma, Armamento.Estado_armamento FROM Personal INNER JOIN Armamento ON "
                + "Personal.TIM_personal = Armamento.TIM_personal " 
                + "WHERE Personal.TIM_personal = ?";
        
        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaArmamentoNombre);
            preparedStatement.setString(1, tim);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                armamentoClass = new ArmamentoClass(); 
                personalClass = new PersonalClass();
                
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                armamentoClass.setNumArma(resulset.getString("Numero_arma"));
                armamentoClass.setNombreArma(resulset.getString("Nombre_arma"));
                armamentoClass.setEstadoArma(resulset.getString("Estado_armamento"));
                
                //Los añadimos a la lista que hemos creado previamente
                listaArmamentoNombre.add(armamentoClass);
                //listaPersonalNombre.add(personalClass);
                   
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaArmamentoNombre;
        
        
    }
    
    public List consultaArmamentoNumero(String numeroArma){
        
        //Creamos una lista para guardar los datos de la consulta
        List<ArmamentoClass> listaArmamentoNumero= new ArrayList();
        //Creamos la consulta
        String consultaArmamentoEstado = "SELECT * FROM Armamento WHERE Numero_arma=?";

        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaArmamentoEstado);
            preparedStatement.setString(1, numeroArma);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                armamentoClass = new ArmamentoClass();
                armamentoClass.setNumArma(resulset.getString("Numero_arma"));
                armamentoClass.setNombreArma(resulset.getString("Nombre_Arma"));
                armamentoClass.setTipo(resulset.getString("Tipo"));
                armamentoClass.setCalibre(resulset.getString("Calibre"));
                armamentoClass.setEstadoArma(resulset.getString("Estado_armamento"));
                armamentoClass.setTIM(resulset.getString("TIM_personal"));
                //Los añadimos a la lista que hemos creado previamente
                listaArmamentoNumero.add(armamentoClass);
                
            }
             
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaArmamentoNumero;
          
    }
    
    public List consultaArmamentoEstado(String estado){
        
        //Creamos una lista para guardar los datos de la consulta
        List<ArmamentoClass> listaArmamentoEstado= new ArrayList();
        //Creamos la consulta
        String consultaArmamentoEstado = "SELECT * FROM Armamento WHERE Estado_armamento=?";

        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaArmamentoEstado);
            preparedStatement.setString(1, estado);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                armamentoClass = new ArmamentoClass();
                armamentoClass.setNumArma(resulset.getString("Numero_arma"));
                armamentoClass.setNombreArma(resulset.getString("Nombre_Arma"));
                armamentoClass.setTipo(resulset.getString("Tipo"));
                armamentoClass.setCalibre(resulset.getString("Calibre"));
                armamentoClass.setEstadoArma(resulset.getString("Estado_armamento"));
                armamentoClass.setTIM(resulset.getString("TIM_personal"));
                //Los añadimos a la lista que hemos creado previamente
                listaArmamentoEstado.add(armamentoClass);
                
            }
             
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaArmamentoEstado;
        
    }
    
    public List consultaVehiculosNombre( String nombre){
        
        //Creamos una lista para guardar los datos de la consulta
        List<VehiculosClass> listaVehiculoNommbre = new ArrayList();
        //Creamos la consulta        
        String consultaVehiculosNombre = "SELECT Personal.TIM_personal, Personal.Nombre,"
                 + "Personal.Primer_apellido, Personal.Segundo_apellido, Vehiculos.Matricula_vehiculo,"
                 + "Vehiculos.Nombre_vehiculo, Vehiculos.Estado_vehiculo FROM Personal INNER JOIN "
                 + "Personal_Vehiculos ON Personal.TIM_personal = Personal_Vehiculos.TIM_personal "
                 + "INNER JOIN Vehiculos ON Personal_Vehiculos.Matricula_Vehiculo = Vehiculos.Matricula_vehiculo "
                 + "WHERE Personal.Nombre=? ";
                 
         try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaVehiculosNombre);
            preparedStatement.setString(1, nombre);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                vehiculosClass = new VehiculosClass(); 
                personalClass = new PersonalClass();
                
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                vehiculosClass.setMatriculaVehiculo(resulset.getString("Matricula_vehiculo"));
                vehiculosClass.setNombreVehiculo(resulset.getString("Nombre_vehiculo"));
                vehiculosClass.setEstado(resulset.getString("Estado_vehiculo"));
                //Los añadimos a la lista que hemos creado previamente 
                listaVehiculoNommbre.add(vehiculosClass);
                   
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
         
         return listaVehiculoNommbre;
        
    }
    
    public List consultaVehiculoTIM (String tim){
        
        //Creamos una lista para guardar los datos de la consulta
        List<VehiculosClass> listaVehiculoTIM = new ArrayList();
        //Creamos la consulta       
        String consultaVehiculosTIM = "SELECT Personal.TIM_personal, Personal.Nombre,"
                 + "Personal.Primer_apellido, Personal.Segundo_apellido, Vehiculos.Matricula_vehiculo,"
                 + "Vehiculos.Nombre_vehiculo, Vehiculos.Estado_vehiculo FROM Personal INNER JOIN "
                 + "Personal_Vehiculos ON Personal.TIM_personal = Personal_Vehiculos.TIM_personal "
                 + "INNER JOIN Vehiculos ON Personal_Vehiculos.Matricula_Vehiculo = Vehiculos.Matricula_vehiculo "
                 + "WHERE Personal.TIM_personal=? ";
                 
         try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaVehiculosTIM);
            preparedStatement.setString(1, tim);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                vehiculosClass = new VehiculosClass(); 
                personalClass = new PersonalClass();
                
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                vehiculosClass.setMatriculaVehiculo(resulset.getString("Matricula_vehiculo"));
                vehiculosClass.setNombreVehiculo(resulset.getString("Nombre_vehiculo"));
                vehiculosClass.setEstado(resulset.getString("Estado_vehiculo"));
                //Los añadimos a la lista que hemos creado previamente
                listaVehiculoTIM.add(vehiculosClass);
                      
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
         
         return listaVehiculoTIM;
        
    }
    
    public List consultaVehiculosMatricula(String matriculaVehiculo){
        //Creamos una lista para guardar los datos de la consulta
        List<VehiculosClass> listaVehiculosMatricula= new ArrayList();
        //Creamos la consulta     
        String consultaVehiculosMatricula = "SELECT * FROM Vehiculos WHERE Matricula_vehiculo=?";

        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaVehiculosMatricula);
            preparedStatement.setString(1, matriculaVehiculo);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                vehiculosClass = new VehiculosClass();
                
                vehiculosClass.setMatriculaVehiculo(resulset.getString("Matricula_vehiculo"));
                vehiculosClass.setNombreVehiculo(resulset.getString("Nombre_vehiculo"));
                vehiculosClass.setTipo(resulset.getString("Tipo"));
                vehiculosClass.setKilometros(resulset.getString("Kilometros"));
                vehiculosClass.setEstado(resulset.getString("Estado_vehiculo"));
                //Los añadimos a la lista que hemos creado previamente
                listaVehiculosMatricula.add(vehiculosClass);
                
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaVehiculosMatricula;
          
    }
    
    public List consultaVehiculosEstado(String estado){
        
        //Creamos una lista para guardar los datos de la consulta
        List<VehiculosClass> listaVehiculosEstado= new ArrayList();
        //Creamos la consulta
        String consultaVehiculosEstado= "SELECT * FROM Vehiculos WHERE Estado_vehiculo=?";

        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaVehiculosEstado);
            preparedStatement.setString(1, estado);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                vehiculosClass = new VehiculosClass();
                
                vehiculosClass.setMatriculaVehiculo(resulset.getString("Matricula_vehiculo"));
                vehiculosClass.setNombreVehiculo(resulset.getString("Nombre_vehiculo"));
                vehiculosClass.setTipo(resulset.getString("Tipo"));
                vehiculosClass.setKilometros(resulset.getString("Kilometros"));
                vehiculosClass.setEstado(resulset.getString("Estado_vehiculo"));
                //Los añadimos a la lista que hemos creado previamente
                listaVehiculosEstado.add(vehiculosClass);
                
            }
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaVehiculosEstado;
        
    }
    
    public List consultaTransmisionesNombre(String nombre){
        //Creamos una lista para guardar los datos de la consulta       
        List<TransmisionesClass> listaTransmisionesNombre = new ArrayList();
       
        //Creamos la consulta
         String consultaTransmisionesNombre = "SELECT Personal.TIM_personal, Personal.Nombre,"
                 + "Personal.Primer_apellido, Personal.Segundo_apellido, Transmisiones.Numero_transmision,"
                 + "Transmisiones.Nombre_transmision, Transmisiones.Estado_transmision FROM Personal INNER JOIN "
                 + "Transmisiones ON Personal.TIM_personal = Transmisiones.TIM_personal "
                 + "WHERE Personal.Nombre=? ";
        
         try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaTransmisionesNombre);
            preparedStatement.setString(1, nombre);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                transmisionesClass = new TransmisionesClass(); 
                personalClass = new PersonalClass();
                
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                transmisionesClass.setNumeroTransmision(resulset.getString("Numero_transmision"));
                transmisionesClass.setNombreTransmision(resulset.getString("Nombre_transmision"));
                transmisionesClass.setEstado(resulset.getString("Estado_transmision"));
                //Los añadimos a la lista que hemos creado previamente
                listaTransmisionesNombre.add(transmisionesClass);
                      
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
         
         return listaTransmisionesNombre;
         
    }
    
    public List consultaTransmisionesTIM(String tim){
        //Creamos una lista para guardar los datos de la consulta       
       List<TransmisionesClass> listaTransmisionesTIM = new ArrayList();
       
         //Creamos la consulta       
         String consultaTransmisionesTIM= "SELECT Personal.TIM_personal, Personal.Nombre,"
                 + "Personal.Primer_apellido, Personal.Segundo_apellido, Transmisiones.Numero_transmision,"
                 + "Transmisiones.Nombre_transmision, Transmisiones.Estado_transmision FROM Personal INNER JOIN "
                 + "Transmisiones ON Personal.TIM_personal = Transmisiones.TIM_personal "
                 + "WHERE Personal.TIM_personal=? ";
        
         try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaTransmisionesTIM);
            preparedStatement.setString(1, tim);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                transmisionesClass = new TransmisionesClass(); 
                personalClass = new PersonalClass();
                
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                transmisionesClass.setNumeroTransmision(resulset.getString("Numero_transmision"));
                transmisionesClass.setNombreTransmision(resulset.getString("Nombre_transmision"));
                transmisionesClass.setEstado(resulset.getString("Estado_transmision"));
                
                //Los añadimos a la lista que hemos creado previamente
                listaTransmisionesTIM.add(transmisionesClass);
                     
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
         
        return listaTransmisionesTIM; 
        
    }
    
    public List consultaTransmisionesNumero(String numeroTransmision){
        //Creamos una lista para guardar los datos de la consulta
        List<TransmisionesClass> listaTransmisionesNumero= new ArrayList();
        //Creamos la consulta  
        String consultaTransmisionesNumero = "SELECT * FROM Transmisiones WHERE Numero_transmision=?";

        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaTransmisionesNumero);
            preparedStatement.setString(1, numeroTransmision);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                transmisionesClass = new TransmisionesClass();
                
                transmisionesClass.setNumeroTransmision(resulset.getString("Numero_transmision"));
                transmisionesClass.setNombreTransmision(resulset.getString("Nombre_transmision"));
                transmisionesClass.setTipo(resulset.getString("Tipo"));
                transmisionesClass.setEstado(resulset.getString("Estado_transmision"));
                transmisionesClass.setTIM(resulset.getString("TIM_personal"));
                //Los añadimos a la lista que hemos creado previamente
                listaTransmisionesNumero.add(transmisionesClass);
                
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaTransmisionesNumero;
          
    }
    
    public List consultaTransmisionEstado(String estado){
        //Creamos una lista para guardar los datos de la consulta
        List<TransmisionesClass> listaTransmisionesEstado= new ArrayList();
        //Creamos la consulta  
        String consultaTransmisionesEstado= "SELECT * FROM Transmisiones WHERE Estado_transmision=?";

        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaTransmisionesEstado);
            preparedStatement.setString(1, estado);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                transmisionesClass = new TransmisionesClass();
                
                transmisionesClass.setNumeroTransmision(resulset.getString("Numero_transmision"));
                transmisionesClass.setNombreTransmision(resulset.getString("Nombre_transmision"));
                transmisionesClass.setTipo(resulset.getString("Tipo"));
                transmisionesClass.setEstado(resulset.getString("Estado_transmision"));
                transmisionesClass.setTIM(resulset.getString("TIM_personal"));
                //Los añadimos a la lista que hemos creado previamente
                listaTransmisionesEstado.add(transmisionesClass);
                
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
        
        return listaTransmisionesEstado;
        
    }
    
    public List consultaTelefonoNombre(String nombre){
        //Creamos una lista para guardar los datos de la consulta
        List<TelefonosClass> listaTelefonoNombre= new ArrayList();
       
         //Creamos la consulta         
         String consultaTelefonosNombre = "SELECT Personal.TIM_personal, Personal.Nombre,"
                 + "Personal.Primer_apellido, Personal.Segundo_apellido, Telefonos.Numero_telefono "
                 + "FROM Personal INNER JOIN Telefonos ON Personal.TIM_personal = Telefonos.TIM_personal "
                 + "WHERE Personal.Nombre=? ";
        
        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaTelefonosNombre);
            preparedStatement.setString(1, nombre);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                telefonosClass = new TelefonosClass();
                personalClass = new PersonalClass();
                
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                telefonosClass.setNumeroTelefono(resulset.getInt("Numero_Telefono"));
                //Los añadimos a la lista que hemos creado previamente
                listaTelefonoNombre.add(telefonosClass);
                     
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
         
         return listaTelefonoNombre;
         
    }
    
    public List consultaTelefonoTIM(String tim){
        //Creamos una lista para guardar los datos de la consulta
        List<TelefonosClass> listaTelefonoTIM= new ArrayList();
        
         //Creamos la consulta       
         String consultaTelefonosTIM= "SELECT Personal.TIM_personal, Personal.Nombre,"
                 + "Personal.Primer_apellido, Personal.Segundo_apellido, Telefonos.Numero_telefono "
                 + "FROM Personal INNER JOIN Telefonos ON Personal.TIM_personal = Telefonos.TIM_personal "
                 + "WHERE Personal.TIM_personal=? ";
        
        try {
            //Conectamos a la base de datos y ejecutamos la consulta
            conn = bdConn.getConnection();
            preparedStatement = conn.prepareStatement(consultaTelefonosTIM);
            preparedStatement.setString(1, tim);
            resulset = preparedStatement.executeQuery();
            
            while(resulset.next()){
                
                telefonosClass = new TelefonosClass();
                personalClass = new PersonalClass();
                
                personalClass.setTIM(resulset.getString("TIM_personal"));
                personalClass.setNombre(resulset.getString("Nombre"));
                personalClass.setPrimerApellido(resulset.getString("Primer_apellido"));
                personalClass.setSegundoApellido(resulset.getString("Segundo_apellido"));
                telefonosClass.setNumeroTelefono(resulset.getInt("Numero_Telefono"));
                //Los añadimos a la lista que hemos creado previamente
                listaTelefonoTIM.add(telefonosClass);
                     
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "No se "
                    + "ha podido realizar la consulta \n"
                    + "Por favor, verifica los datos introducidos");
        }
         
         return listaTelefonoTIM;
        
    }
      
}
