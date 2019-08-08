/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.UsuarioDL;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author angel
 */
public class UsuarioBL {
    UsuarioDL usuarioDL = new UsuarioDL();
    
    public List listar(){
        return usuarioDL.Listar();
    }
    
    public void insertar(Usuario u){
        usuarioDL.insertar(u);
    }
    
    public List buscar (int IdUser){
        return usuarioDL.buscar(IdUser);
    }
    
    public void actualizar(Usuario u){
        usuarioDL.actualizar(u);
    }
    
    public void eliminar(int IdUser){
        usuarioDL.eliminar(IdUser);
    }
}
