/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hn.ina.laura.tarea2;

import hn.uth.pa1.objetos.Vehiculo;
import java.util.List;

/**
 *
 * @author inalaurasuazo
 */
public class Programavehiculo {
    public static void main(String [] args){
       Vehiculo  vehi=new Vehiculo("pdfar", "Tacoma", "mvw", 2014, "2.0", 2000000, "toyota", "imagen", "El vehiculo tiene un año");
       Gestordb.guardarVehiculo(vehi);
       
       vehi.setNombre("Ford");
       vehi.setModelo("camioneta");
       Gestordb.actualizarVehiculo(vehi);
       
       Gestordb.EliminarVehiculo(vehi);
       
       List<Vehiculo> listaPrueba=Gestordb.getvehiculos();
        for (Vehiculo variableTMP : listaPrueba) {
            System.out.println("valor: "+variableTMP);
        }
        
         Gestordb
                .guardarVehiculo(new Vehiculo("mevnm", "Hunday", "bus", 2015, "2.0", 4000000, "ford", "El vehiculo tiene 3 años ", "Imagen"));
         
          listaPrueba=Gestordb.getvehiculos();
        for (Vehiculo variableTMP : listaPrueba) {
            System.out.println("valor2: "+variableTMP);
        }
    }}