/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CategoriaDL;
import Model.Categoria;
import java.util.List;

/**
 *
 * @author angel
 */
public class CategoriaBL {
    CategoriaDL categoriaDL = new CategoriaDL();
    
    public List listar(){
        return categoriaDL.listar();
    }
    
    public void insertar(Categoria c){
        categoriaDL.insertar(c);
    }
    
    public List buscar (int IdCategoria){
        return categoriaDL.buscar(IdCategoria);
    }
    
    public void actualizar(Categoria c){
        categoriaDL.actualizar(c);
    }
    
    public void eliminar(int IdCategoria){
        categoriaDL.eliminar(IdCategoria);
    }
    
}
