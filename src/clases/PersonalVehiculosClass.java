/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manuel
 */
public class PersonalVehiculosClass {
    //Encapsulamos nuestras variables 
    private int id;
    private String TIM;
    private String matriculaVehiculo;

    //Creamos tanto el constructor vacio, como el contructor con parametros
    public PersonalVehiculosClass() {
    }

    public PersonalVehiculosClass(String TIM, String matriculaVehiculo) {
        this.TIM = TIM;
        this.matriculaVehiculo = matriculaVehiculo;
    }

    //Creamos los metodos setters y getters
    public String getTIM() {
        return TIM;
    }

    public void setTIM(String TIM) {
        this.TIM = TIM;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
}
