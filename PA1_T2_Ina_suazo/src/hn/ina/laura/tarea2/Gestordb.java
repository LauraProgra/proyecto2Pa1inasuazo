/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hn.ina.laura.tarea2;

import hn.uth.pa1.objetos.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class Gestordb {
    
   public static Connection getConexion ()
    throws Exception{
       try{
        String url="jdbc:msql://localhost:3306/registrodb";
        String usuario="root";
        String contrasenia="";
       
       return DriverManager
               .getConnection(url,usuario,contrasenia);
       }catch(Exception e){
           throw new Exception("No se pudo establecer la conexion"+e.toString());
           
       }
      
       
   }

    
public  static void guardarVehiculo(Vehiculo vehiculo){

try{
Connection con=getConexion();
 String sql="INSERT INTO vehiculo"
  + " (Marca, Anio, Motor,Precio,Nombre,Descripcion,Imagen) "
                    + " VALUES (?,?,?,?,?,?,?) ";
   PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(3, vehiculo.getMarca());
    ps.setInt(4, vehiculo.getAnio());
    ps.setString(4, vehiculo.getMotor());
    ps.setInt(5, vehiculo.getPrecio());
    ps.setString(5, vehiculo.getNombre());
    ps.setString(6, vehiculo.getDescripcion());
     ps.setString(6, vehiculo.getPlaca());
    ps.setString(7, vehiculo.getImagen());

      ps.execute();
      ps.close();

}      catch (Exception e) {
    System.out.println("Error guardar Vehiculo"+e.toString());
          
       }

}

public static void actualizarVehiculo (Vehiculo vehiculo){
    try{
        Connection con = getConexion();
        String sql = "UPTADE vehiculo";
                + "SET NOMBRE=? "
                + ", MODELO=? "
                + ", MARCA=? "
                + ", ANIO=? "
                + ", MOTOR=? "
                + ", PRECIO=? "
                + ", NOMBRE=? "
                + ", DESCRIPCION=? "
                + ", WHWERE codigo=? ";
                
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, vehiculo.getPlaca());
        ps.setString(2, vehiculo.getModelo());
        ps.setString(3, vehiculo.getMarca());
        ps.setInt(4, vehiculo.getAnio());
        ps.setString(4, vehiculo.getMotor());
        ps.setInt(5, vehiculo.getPrecio());
        ps.setString(5, vehiculo.getNombre());
        ps.setString(6, vehiculo.getDescripcion());
        ps.setString(7, vehiculo.getImagen());

        ps.execute();
        ps.close();

}      catch (Exception e) {
    System.out.println("Error guardar Vehiculo"+e.toString());
          
       }
    }

public static void EliminarVehiculo (Vehiculo vehiculo){
    try{
     Connection con =getConexion();   
     String sql="DELETE FROM vehiculo";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1,vehiculo.getPlaca());
     
          ps.execute();

            ps.close();
            con.close();
    }catch (Exception e) {
            System.out.println("Error guardarVehiculo: "
                    + e.toString());
}
}
 public static List<Vehiculo> getvehiculos() {
        try {
            List<Vehiculo> lista = new ArrayList<>();
            Connection con = getConexion();
            String sql = "SELECT *  FROM Vehiculos ";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(
                        new Vehiculo(
                                rs.getString("PLACA"),
                                 rs.getString("MODELO"),
                                 rs.getString("MARCA"),
                                 rs.getInt("ANIO"),
                                 rs.getString("MOTOR"),
                                rs.getInt("PRECIO"),
                                rs.getString("NOMBRE"),
                                rs.getString("DESCRIPCION"),
                                rs.getString("IMAGEN")));
                                
                                
            }
            rs.close();
            st.close();
            con.close();

            return lista;
        } catch (Exception e) {
            System.out.println("Error guardarVehiculo: "
                    + e.toString());
}
       return null;
}
}

