/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.FacturaBL;
import Business.SolicitudBL;
import Business.UsuarioBL;
import Model.Factura;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel
 */
@Controller
public class FacturaController {
    ModelAndView mav = new ModelAndView();
    FacturaBL facturaBL = new FacturaBL();
    SolicitudBL solicitudBL = new SolicitudBL();
    UsuarioBL usuarioBL = new UsuarioBL();
    int IdFactura;
    List datos;
    
    @RequestMapping("indexFactura.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = facturaBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexFactura");
        return mav;
    }
    
}
