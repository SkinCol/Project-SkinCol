/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.DispositivoDL;
import Model.Dispositivo;
import java.util.List;

/**
 *
 * @author angel
 */
public class DispositivoBL {
    DispositivoDL dispositivoDL = new DispositivoDL();
    
    public List listar(){
        return dispositivoDL.listar();
    }
    
    public void insertar(Dispositivo d){
        dispositivoDL.insertar(d);
    }
    
    public List buscar (int IdDispositivo){
        return dispositivoDL.buscar(IdDispositivo);
    }
    
    public void actualizar(Dispositivo d){
        dispositivoDL.actualizar(d);
    }
    
    public void eliminar(int IdDispositivo){
        dispositivoDL.eliminar(IdDispositivo);
    }
}
