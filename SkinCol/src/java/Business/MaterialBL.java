/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.MaterialDL;
import Model.Material;
import java.util.List;

/**
 *
 * @author angel
 */
public class MaterialBL {
    MaterialDL materialDL = new MaterialDL();
    
    public List listar(){
        return materialDL.listar();
    }
    public void insertar(Material m){
        materialDL.insertar(m);
    }
    
    public List buscar (int IdMaterial){
        return materialDL.buscar(IdMaterial);
    }
    
    public void actualizar(Material m){
        materialDL.actualizar(m);
    }
    
    public void eliminar(int IdMaterial){
        materialDL.eliminar(IdMaterial);
    }
    
}
