/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.FacInsumosDL;
import Model.FacInsumos;
import java.util.List;

/**
 *
 * @author angel
 */
public class FacInsumosBL {
    FacInsumosDL facinsumosDL = new FacInsumosDL();
    
    public List listar(){
        return facinsumosDL.Listar();
    }
    
    public void insertar(FacInsumos f){
        facinsumosDL.insertar(f);
    }
    
    public List buscar (int IdFacturaInsumos){
        return facinsumosDL.buscar(IdFacturaInsumos);
    }
    
    public void actualizar (FacInsumos f){
        facinsumosDL.actualizar(f);
    }
    
    public void eliminar (int IdFacturaInsumos){
        facinsumosDL.eliminar(IdFacturaInsumos);
    }
    
}
