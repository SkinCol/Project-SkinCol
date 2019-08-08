/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.SkinDL;
import Model.Skin;
import java.util.List;

/**
 *
 * @author angel
 */
public class SkinBL {
    SkinDL skinDL = new SkinDL();
    
    public List listar(){
        return skinDL.Listar();
    }
    
    public void insertar(Skin s){
        skinDL.insertar(s);
    }
    
    public List buscar (int IdSkin){
        return skinDL.buscar(IdSkin);
    }
    
    public void actualizar(Skin s){
        skinDL.actualizar(s);
    }
    
    public void eliminar(int IdSkin){
        skinDL.eliminar(IdSkin);
    }
    
}
