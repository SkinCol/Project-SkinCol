/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.EnvioDL;
import Model.Envio;
import java.util.List;

/**
 *
 * @author angel
 */
public class EnvioBL {
    EnvioDL envioDL = new EnvioDL();
    
    public List listar(){
        return envioDL.Listar();
    }
    
    public void insertar(Envio e){
        envioDL.insertar(e);
    }
    
    public List buscar (int IdEnvio){
        return envioDL.buscar(IdEnvio);
    }
    
    public void actualizar(Envio e){
        envioDL.actualizar(e);
    }
    
    public void eliminar(int IdEnvio){
        envioDL.eliminar(IdEnvio);
    }
}
