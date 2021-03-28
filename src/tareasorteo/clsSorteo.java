/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasorteo;

import Conexion.clsConexion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modelo.clsModelo;

/**
 *
 * @author arlet
 */
public class clsSorteo {
    private List<clsModelo> nombres; 
    
    public clsSorteo(){
        clsConexion cn = new clsConexion();
        nombres = cn.modelos();
    }    
    
    public List<clsModelo> personasGanadoras(){
        List<clsModelo> ganadores = new ArrayList<>();
        for(int i=0; i<10; i++){
           Random random = new Random();
           int posicion = random.nextInt(nombres.size());//size devuelve el total de elementos de la lista 
           ganadores.add(nombres.get(posicion));
           nombres.remove(posicion);//elimina un elemento de la posicion indicada
        }
        return ganadores;
    }
    
}
