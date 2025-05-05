/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manuel
 */
public class ArmamentoClass {
    //Encapsulamos nuestras variables 
    private String numArma;
    private String nombre;
    private String tipo;
    private String estadoArma;
    private String calibre;
    private String TIM;
    
    
    //Creamos tanto el constructor vacio como el constructor con parametros
    public ArmamentoClass() {
    }

    public ArmamentoClass(String numArma, String nombre, String tipo, String estadoArma, String calibre, String TIM) {
        this.numArma = numArma;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estadoArma = estadoArma;
        this.calibre = calibre;
        this.TIM = TIM;
    }

    //Creamos los metodos setter y getters 
    public String getNumArma() {
        return numArma;
    }

    public void setNumArma(String numArma) {
        this.numArma = numArma;
    }

    public String getNombreArma() {
        return nombre;
    }

    public void setNombreArma(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstadoArma() {
        return estadoArma;
    }

    public void setEstadoArma(String estadoArma) {
        this.estadoArma = estadoArma;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getTIM() {
        return TIM;
    }

    public void setTIM(String TIM) {
        this.TIM = TIM;
    }
    
    
    
}
