/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.DispositivoBL;
import Model.Dispositivo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel
 */
public class DispositivoController {
    ModelAndView mav = new ModelAndView();
    DispositivoBL dispositivoBL = new DispositivoBL();
    int IdDispositivo;
    List datos;
    
    @RequestMapping("indexDispositivo.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = dispositivoBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexDispositivo");
        return mav;
    }
    
    @RequestMapping(value = "agregarDispositivo.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Dispositivo());
        mav.setViewName("agregarDispositivo");
        return mav;
    }
    
    @RequestMapping(value = "agregarDispositivo.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Dispositivo d){
        dispositivoBL.insertar(d);
        return new ModelAndView("redirect:/indexDispositivo.htm");
    }
    
    @RequestMapping(value = "editarDispositivo.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdDispositivo = Integer.parseInt(request.getParameter("IdDispositivo"));
        datos = dispositivoBL.buscar(IdDispositivo);
        mav.addObject("lista", datos);
        mav.setViewName("editarDispositivo");
        return mav;
    }
    
    @RequestMapping(value = "editarDispositivo.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Dispositivo d){
        dispositivoBL.actualizar(d);
        return new ModelAndView ("redirect:/indexDispositivo.htm");
    }
    
    @RequestMapping("deleteDispositivo.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdDispositivo = Integer.parseInt(request.getParameter("IdDispositivo"));
        dispositivoBL.eliminar(IdDispositivo);
        return new ModelAndView("redirect:/indexDispositivo.htm");
    }
}
