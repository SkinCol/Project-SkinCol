/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.FacturaDL;

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

}
