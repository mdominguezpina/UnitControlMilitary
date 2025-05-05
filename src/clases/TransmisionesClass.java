/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manuel
 */
public class TransmisionesClass {
    //Encapsulamos nuestras variables 
    private String numeroTransmision;
    private String nombreTransmision;
    private String tipo;
    private String estado;
    private String TIM;

    //Creamos tanto el constructor vacio, como el contructor con parametros
    public TransmisionesClass() {
    }

    public TransmisionesClass(String numeroTransmision, String nombreTransmision, String tipo, String estado, String TIM) {
        this.numeroTransmision = numeroTransmision;
        this.nombreTransmision = nombreTransmision;
        this.tipo = tipo;
        this.estado = estado;
        this.TIM = TIM;
    }

    //Creamos los metodos setters y getters
    public String getNumeroTransmision() {
        return numeroTransmision;
    }

    public void setNumeroTransmision(String numeroTransmision) {
        this.numeroTransmision = numeroTransmision;
    }

    public String getNombreTransmision() {
        return nombreTransmision;
    }

    public void setNombreTransmision(String nombreTransmision) {
        this.nombreTransmision = nombreTransmision;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTIM() {
        return TIM;
    }

    public void setTIM(String TIM) {
        this.TIM = TIM;
    }
    
    
    
    
    
}
