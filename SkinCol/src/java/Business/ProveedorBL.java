/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.ProveedorDL;
import Model.Proveedor;
import java.util.List;

/**
 *
 * @author angel
 */
public class ProveedorBL {
    ProveedorDL proveedorDL = new ProveedorDL();
    
    public List listar(){
        return proveedorDL.listar();
    }
    
    public void insertar(Proveedor p){
        proveedorDL.insertar(p);
    }
    
    public List buscar (int IdProveedor){
        return proveedorDL.buscar(IdProveedor);
    }
    
    public void actualizar(Proveedor p){
        proveedorDL.actualizar(p);
    }
    
    public void eliminar(int IdCategoria){
        proveedorDL.eliminar(IdCategoria);
    }
  
}