/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manuel
 */
public class TelefonosClass {
    //Encapsulamos nuestras variables
    private int Id;
    private int numeroTelefono;
    private String TIM;

    //Creamos tanto el constructor vacio, como el contructor con parametros
    public TelefonosClass() {
    }

    public TelefonosClass(int numeroTelefono, String TIM) {
        this.numeroTelefono = numeroTelefono;
        this.TIM = TIM;
    }

    //Creamos los metodos setters y getters
    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getTIM() {
        return TIM;
    }

    public void setTIM(String TIM) {
        this.TIM = TIM;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
    
}
