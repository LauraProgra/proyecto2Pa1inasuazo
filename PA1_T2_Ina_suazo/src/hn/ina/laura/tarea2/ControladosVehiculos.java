/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hn.ina.laura.tarea2;

import hn.uth.pa1.objetos.Vehiculo;

/**
 *
 * @author inalaurasuazo
 */
public class ControladosVehiculos {
    
    public static Vehiculo vehiculoactual;
    
    public static void setvehiculoactual(Vehiculo vehiculo){
            vehiculoactual=vehiculo;
    
}
    public static void 
        setPersonaActual(Vehiculo vehiculo){
            vehiculoactual=vehiculo;
    }
        
    public static Vehiculo
        getPersonaActual(){
            return vehiculoactual;
    }    
}