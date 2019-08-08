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
    
    @RequestMapping(value = "agregarFactura.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Factura());
        datos=solicitudBL.listar();
        mav.addObject("lista",datos);
        mav.setViewName("agregaFactura");
        return mav;
    }
    
    @RequestMapping(value = "agregarFactura.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Factura f){
        facturaBL.insertar(f);
        return new ModelAndView("redirect:/indexFactura.htm");
    }
    
    @RequestMapping(value = "editarFactura.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdFactura = Integer.parseInt(request.getParameter("IdFactura"));
        datos = facturaBL.buscar(IdFactura);
        mav.addObject("lista", datos);
        datos=solicitudBL.listar();
        mav.addObject("listaS", datos);
        datos=usuarioBL.listar();
        mav.addObject("listaU", datos);
        mav.setViewName("editarFactura");
        return mav;
    }
    
    @RequestMapping(value = "editarFactura.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Factura f){
        facturaBL.actualizar(f);
        return new ModelAndView ("redirect:/indexFactura.htm");
    }
    
    @RequestMapping("deleteFactura.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdFactura = Integer.parseInt(request.getParameter("IdFactura"));
        facturaBL.eliminar(IdFactura);
        return new ModelAndView("redirect:/indexFactura.htm");
    }
}
