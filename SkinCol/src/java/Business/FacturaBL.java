/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.FacturaDL;
import Model.Factura;
import java.util.List;

/**
 *
 * @author angel
 */
public class FacturaBL {
    FacturaDL facturaDL = new FacturaDL();
    
    public List listar(){
        return facturaDL.Listar();
    }
    
    public void insertar(Factura f){
        facturaDL.insertar(f);
    }
    
    public List buscar (int IdFactura){
        return facturaDL.buscar(IdFactura);
    }
    
    public void actualizar(Factura f){
        facturaDL.actualizar(f);
    }
    
    public void eliminar(int IdFactura){
        facturaDL.eliminar(IdFactura);
    }
}
