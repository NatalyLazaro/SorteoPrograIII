/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modelo.clsModelo;

/**
 *
 * @author arlet
 */
public class clsConexion {
    
    public com.mysql.jdbc.Connection conexion;
    private final String servidor_conexion = "jdbc:mysql://localhost/dbsorteo";
    static private final String usuario="root";
    static private final String clave="";
   
    
   public Connection AbrirConexion(){
       try{
           conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection(servidor_conexion, usuario, clave);
       }catch(SQLException ex){
           System.out.println("Error:"+ex.getMessage());
       }
       return conexion;
   }
   
   private void CerrarConexion(){
       try{
           conexion.close();
       }catch(SQLException ex){
         System.out.println("Error:"+ex.getMessage());  
       }
   }
   
   public List<clsModelo> modelos(){
       
      clsModelo modelo = new clsModelo();
      
      List<clsModelo> columnas = new ArrayList<>();
      
      try{
      AbrirConexion();
      String criterio="select * from tbsorteo";
      Statement s = (Statement) conexion.createStatement();
      ResultSet rs = s.executeQuery(criterio);
      
      while (rs.next()){
          //System.out.println(rs.getInt("ID")+"  "+rs.getString("nombre"));
          modelo.setID(rs.getInt("ID"));
          modelo.setnombre(rs.getString("nombre"));
          columnas.add(modelo);
          modelo = new clsModelo();
      }
      
       }catch(SQLException ex){
           CerrarConexion();
          System.out.println("error:"+ ex.getMessage());
      }
       return columnas;
    }
}
