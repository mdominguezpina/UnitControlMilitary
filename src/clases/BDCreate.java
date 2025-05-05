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
public class BDCreate {
   
    private static final String BD_URL = "jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String BD = "jdbc:mysql://localhost:3306/Unit_Control_Military?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String BDNAME = "Unit_Control_Military";
    private static final String BD_USER = "Admin";
    private static final String BD_PASS = "1234";
    
    //jdbc:mysql://localhost:3306/?user=root
    
    public void crearBaseDeDatos(){
        
        Connection conn = null;
        Statement statement = null;
        
        /*Creación de la base de datos*/
        try {
            //Conexion a la base de datos
            conn=DriverManager.getConnection(BD_URL,"root","");
            Statement stmt = conn.createStatement();
            String BDName = "Unit_Control_Military";
            String CrearBD = "CREATE DATABASE IF NOT EXISTS " + BDName;
            stmt.executeUpdate(CrearBD);
            System.out.println("Base de datos creada con exito");
        
        } catch (SQLException e) {
            System.err.println("Error al crear la base de datos");
            e.printStackTrace();
            
        }finally{
            //Cierre de la conexion
            try {
                if(statement !=null){
                    statement.close();
                }
                if(conn !=null){
                    conn.close();
                }
                
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión");
            }
            
        }
    }
    
    public void crearUsuario(){
        
        
        Connection conn = null;
        Statement stmt = null;
        try {
            /*Nos conectamos con un usuario con privilegios
            para crear el usuario con el que trabajaremos*/
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root","" );
            conn.setCatalog("Unit_Control_Military");
            stmt = conn.createStatement();
            String createUser = "CREATE USER IF NOT EXISTS '" + BD_USER
                    + "'@'localhost' IDENTIFIED BY '" + BD_PASS + "';"; 
            stmt.executeUpdate(createUser);
            System.out.println("Usuario creado con éxito");
              
            //Otorgamos los permisos
            String permisoUser = "GRANT ALL PRIVILEGES ON " + BDNAME + ".* TO '" + 
                    BD_USER + "'@'localhost';";
            stmt.executeUpdate(permisoUser);
            
            
        } catch (SQLException ex) {
            
            System.err.println("Error al crear el usuario y otorgar privilegios");
            ex.printStackTrace();
        }finally{ 
           //Cierre de la conexión
            try {
                if(stmt !=null){
                    stmt.close();
                }
                if(conn !=null){
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión");
            }
        }
        
        
    }
    
    public void crearTablasUsuario(){
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            //Nos conectamos con el usuario root para crear la tabla usuario
            conn = DriverManager.getConnection(BD,"root", "");
            statement = conn.createStatement();
            //Creacion de la tabla Usuario
            String crearTabalaUsuario = "CREATE TABLE IF NOT EXISTS Usuario(\n"
            + " id INT(1) NOT NULL, \n"
            + " usuario VARCHAR(10),\n"
            + " password VARCHAR(5),\n"
            + " PRIMARY KEY (id)\n"
            + ");";
            
            statement.executeUpdate(crearTabalaUsuario);
            System.out.println("Tabla usuario creada con exito");
            
            
        } catch (SQLException e) {
            System.err.println("No ha sido posible crear la tabla");
        }finally{
            //Cerramos la conexion
            try {
                if(statement!=null){
                    statement.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion");
            }
               
        }
        
       //Realizamos el insert del ususario predeterminado
       
        try {
           conn = DriverManager.getConnection(BD,"root", "");
           conn.setCatalog("Unit_Control_Military");
           statement = conn.createStatement();
            
            // Verificamos si el usuario con ID 1 ya existe antes de insertarlo
            String consultaExistencia = "SELECT COUNT(*) FROM Usuario WHERE id = 1";
            ResultSet rs = statement.executeQuery(consultaExistencia);
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                String insertarUsuario = "INSERT INTO Usuario VALUES(1,'" + BD_USER + "','" + BD_PASS + "')";
                statement.executeUpdate(insertarUsuario);
                System.out.println("Usuario predeterminado insertado");
            } else {
                System.out.println("El usuario ya existe. No se insertó de nuevo.");
}
            
        } catch (SQLException e) {
            System.out.println("No se ha podido insertar el usuario");
            e.printStackTrace();
        }finally{
            try{
                if(statement!=null){
                statement.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println("No se ha podido cerrar la conexion");
            }
        }
        
        
        
    }
    
    public void CrearTablas(){
        
        Connection conn = null;
        Statement statement = null;
        
        try {
            
            //Creamos la tabla Personal con le usuario root  
            conn = DriverManager.getConnection(BD,"root", "");
            statement = conn.createStatement();
            //Creacion de la tabla personal con sus columnas
            String crearTablaPersonal = "CREATE TABLE IF NOT EXISTS Personal(\n"
            + " TIM_personal VARCHAR(12) NOT NULL, \n"
            + " Nombre VARCHAR(20),\n"
            + " Primer_apellido VARCHAR(20),\n"
            + " Segundo_apellido VARCHAR(20),\n"
            + " DNI VARCHAR(9),\n"
            + " Rango VARCHAR(30),\n"
            + " Estado_personal VARCHAR(15),\n"
            + " PRIMARY KEY (TIM_personal)\n"
            + ");";
            
            statement.executeUpdate(crearTablaPersonal);
            System.out.println("Tabla Personal creada con exito");
            
            //Creamos la tabla Armamento con sus columnas 
            String crearTablaArmamento = "CREATE TABLE IF NOT EXISTS Armamento(\n"
            + " Numero_arma VARCHAR(10) NOT NULL, \n"
            + " Nombre_arma VARCHAR(30),\n"
            + " Tipo VARCHAR(20),\n"
            + " Calibre VARCHAR(10),\n"
            + " Estado_armamento VARCHAR(15),\n"
            + " TIM_personal VARCHAR(12),\n"   
            + " PRIMARY KEY (Numero_arma),\n"
            + " FOREIGN KEY (TIM_personal) REFERENCES Personal(TIM_personal)ON DELETE SET NULL\n" 
            + ");";
            
            statement.executeUpdate(crearTablaArmamento);
            System.out.println("Tabla Armamento creada con exito");
            
            //Creamos la tabla Vehiculos con sus columnas
            String crearTablaVehiculos = "CREATE TABLE IF NOT EXISTS Vehiculos(\n"
            + " Matricula_vehiculo VARCHAR(10) NOT NULL, \n"
            + " Nombre_vehiculo VARCHAR(30),\n"
            + " Tipo VARCHAR(30),\n"
            + " Kilometros VARCHAR (10),\n"
            + " Estado_vehiculo VARCHAR(15),\n"   
            + " PRIMARY KEY (Matricula_vehiculo)\n" 
            + ");";
            
            statement.executeUpdate(crearTablaVehiculos);
            System.out.println("Tabla vehiculo creada con exito");
            
            //Creamos la tabla Transmisiones con sus columnas
            String crearTablaTransmisiones = "CREATE TABLE IF NOT EXISTS Transmisiones(\n"
            + " Numero_transmision VARCHAR(10) NOT NULL, \n"
            + " Nombre_transmision VARCHAR(30),\n"
            + " Tipo VARCHAR(30),\n"
            + " Estado_transmision VARCHAR (15),\n"  
            + " TIM_personal VARCHAR (12),\n"   
            + " PRIMARY KEY (Numero_transmision),\n" 
            + " FOREIGN KEY (TIM_personal) REFERENCES Personal(TIM_personal)ON DELETE SET NULL\n"      
            + ");";
            
            statement.executeUpdate(crearTablaTransmisiones);
            System.out.println("Tabla transmisiones creada con exito");
            
            //Creamos la tabla Telefonos con sus columnas
             String crearTablaTelefonos = "CREATE TABLE IF NOT EXISTS Telefonos(\n"
            + " Id INT(50) NOT NULL AUTO_INCREMENT,\n"
            + " Numero_telefono INT(9), \n"
            + " TIM_personal VARCHAR(12),\n"  
            + " PRIMARY KEY (Id),\n" 
            + " FOREIGN KEY (TIM_personal) REFERENCES Personal(TIM_personal)ON DELETE CASCADE\n"
            + ");";
            
            statement.executeUpdate(crearTablaTelefonos);
            System.out.println("Tabla telefonos creada con exito");
            
            //Creamos la tabla intermedia Personal_Vehiculos con sus columnas
            String crearTablaPersonal_Vehiculos = "CREATE TABLE IF NOT EXISTS "
                     + " Personal_Vehiculos(\n"
            + " Id INT(50) NOT NULL AUTO_INCREMENT, \n"
            + " TIM_personal VARCHAR(12),\n"
            + " Matricula_Vehiculo VARCHAR (10),\n"   
            + " PRIMARY KEY (Id),\n" 
            + " FOREIGN KEY (TIM_personal) REFERENCES Personal(TIM_personal)ON DELETE CASCADE,\n"
            + " FOREIGN KEY (Matricula_Vehiculo) REFERENCES Vehiculos (Matricula_Vehiculo)ON DELETE CASCADE\n"
            + ");";
             
             statement.executeUpdate(crearTablaPersonal_Vehiculos);
            System.out.println("Tabla Personal_Vehiculos creada con exito");
            
            
        } catch (SQLException e) {
            
            System.err.println("No ha sido posible crear las tablas");
        }finally{
            //Cerramos la conexion
            try {
                if(statement!=null){
                    statement.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion");
            }
            
            
        }
        
    }
    
    
    
}
