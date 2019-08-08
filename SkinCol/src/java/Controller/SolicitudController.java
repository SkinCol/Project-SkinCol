/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.DispositivoBL;
import Business.SkinBL;
import Business.SolicitudBL;
import Business.UsuarioBL;
import Model.Solicitud;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel
 */
public class SolicitudController {
    ModelAndView mav = new ModelAndView();
    SolicitudBL solicitudBL = new SolicitudBL();
    SkinBL skinBL = new SkinBL();
    DispositivoBL dispositivoBL = new DispositivoBL();
    UsuarioBL administradorBL = new UsuarioBL();
    UsuarioBL clienteBL = new UsuarioBL();
    int IdSolicitud;
    List datos;
    
    @RequestMapping("indexSolicitud.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = solicitudBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexSolicitud");
        return mav;
    }
    
    @RequestMapping(value = "agregarSolicitud.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Solicitud());
        datos=skinBL.listar();
        mav.addObject("listaS",datos);
        datos=dispositivoBL.listar();
        mav.addObject("listaD",datos);
        datos=administradorBL.listar();
        mav.addObject("listaA",datos);
        datos=clienteBL.listar();
        mav.addObject("listaC",datos);
        mav.setViewName("agregarSolicitud");
        return mav;
    }
    
    @RequestMapping(value = "agregarSolicitud.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Solicitud s){
        solicitudBL.insertar(s);
        return new ModelAndView("redirect:/indexSolicitud.htm");
    }
    
    @RequestMapping(value = "editarSolicitud.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdSolicitud = Integer.parseInt(request.getParameter("IdSolicitud"));
        datos = solicitudBL.buscar(IdSolicitud);
        mav.addObject("lista", datos);
        datos=skinBL.listar();
        mav.addObject("listaS",datos);
        datos=dispositivoBL.listar();
        mav.addObject("listaD",datos);
        datos=administradorBL.listar();
        mav.addObject("listaA",datos);
        datos=clienteBL.listar();
        mav.addObject("listaC",datos);
        mav.setViewName("editarSolicitud");
        return mav;
    }
    
    @RequestMapping(value = "editarSolicitud.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Solicitud s){
        solicitudBL.actualizar(s);
        return new ModelAndView ("redirect:/indexSolicitud.htm");
    }
    
    @RequestMapping("deleteSolicitud.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdSolicitud = Integer.parseInt(request.getParameter("IdSolicitud"));
        solicitudBL.eliminar(IdSolicitud);
        return new ModelAndView("redirect:/indexSolicitud.htm");
    }
}
