/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CiudadDL;
import Model.Ciudad;
import java.util.List;

/**
 *
 * @author angel
 */
public class CiudadBL {
    CiudadDL ciudadDL = new CiudadDL();
    
    public List listar(){
        return ciudadDL.Listar();
    }
    
    public void insertar(Ciudad c){
        ciudadDL.insertar(c);
    }
    
    public List buscar (int Idciudad){
        return ciudadDL.buscar(Idciudad);
    }
    
    public void actualizar(Ciudad c){
        ciudadDL.actualizar(c);
    }
    
    public void eliminar(int Idciudad){
        ciudadDL.eliminar(Idciudad);
    }
}
