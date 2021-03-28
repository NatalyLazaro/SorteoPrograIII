/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasorteo;

import Conexion.clsConexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import modelo.clsModelo;

/**
 *
 * @author arlet
 */
public class TareaSorteo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        System.out.println("\tBIENVENIDO LOS GANADORES SON:");
        clsSorteo ganadores = new clsSorteo();
        
        for(clsModelo ganador:ganadores.personasGanadoras()){
            System.out.println(ganador.getID()+"    "+ganador.getnombre());
        }
        System.out.println("GRACIAS POR PARTICIPAR");
    }
}
