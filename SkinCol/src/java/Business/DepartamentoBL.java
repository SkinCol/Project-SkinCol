/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.DepartamentoDL;
import Model.Departamento;
import java.util.List;

/**
 *
 * @author angel
 */
public class DepartamentoBL {
    DepartamentoDL departamentoDL = new DepartamentoDL();
    
    public List listar(){
        return departamentoDL.listar();
    }
    
    public void insertar(Departamento d){
        departamentoDL.insertar(d);
    }
    
    public List buscar (int Iddepartamento){
        return departamentoDL.buscar(Iddepartamento);
    }
    
    public void actualizar(Departamento d){
        departamentoDL.actualizar(d);
    }
    
    public void eliminar(int Iddepartamento){
        departamentoDL.eliminar(Iddepartamento);
    }
    
}
