/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.SolicitudDL;
import Model.Solicitud;
import java.util.List;

/**
 *
 * @author angel
 */
public class SolicitudBL {
     SolicitudDL solicitudDL = new SolicitudDL();
    
    public List listar(){
        return solicitudDL.Listar();
    }
    
    public void insertar(Solicitud s){
        solicitudDL.insertar(s);
    }
    
    public List buscar (int IdSolicitud){
        return solicitudDL.buscar(IdSolicitud);
    }
    
    public void actualizar(Solicitud s){
        solicitudDL.actualizar(s);
    }
    
    public void eliminar(int IdSolicitud){
        solicitudDL.eliminar(IdSolicitud);
    }
    
}
