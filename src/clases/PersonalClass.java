/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class PersonalClass {
    //Encapsulamos nuestras variables 
    private String TIM;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String DNI;
    private String rango;
    private String estado;
    
    //Creamos tanto el constructor vacio, como el contructor con parametros
    public PersonalClass(){
        
    }

    public PersonalClass(String TIM, String nombre, String primerApellido, String segundoApellido, String DNI, String rango, String estado) {
        this.TIM = TIM;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.DNI = DNI;
        this.rango = rango;
        this.estado = estado;
    }

    //Creamos los metodos setters y getters
    public String getTIM() {
        return TIM;
    }

    public void setTIM(String TIM) {
        this.TIM = TIM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
