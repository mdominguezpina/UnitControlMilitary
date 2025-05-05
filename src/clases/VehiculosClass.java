/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manuel
 */
public class VehiculosClass {
    //Encapsulamos nuestras variables 
    private String matriculaVehiculo;
    private String nombreVehiculo;
    private String tipo;
    private String kilometros;
    private String estado;

    //Creamos tanto el constructor vacio, como el contructor con parametros
    public VehiculosClass() {
    }

    public VehiculosClass(String matriculaVehiculo, String nombreVehiculo, String tipo, String kilometros, String estado) {
        this.matriculaVehiculo = matriculaVehiculo;
        this.nombreVehiculo = nombreVehiculo;
        this.tipo = tipo;
        this.kilometros = kilometros;
        this.estado = estado;
    }

    //Creamos los metodos setters y getters
    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getKilometros() {
        return kilometros;
    }

    public void setKilometros(String kilometros) {
        this.kilometros = kilometros;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
