/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.CiudadBL;
import Business.UsuarioBL;
import Model.Usuario;
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
public class UsuarioController {
    ModelAndView mav = new ModelAndView();
    UsuarioBL usuarioBL = new UsuarioBL();
    CiudadBL ciudadBL = new CiudadBL();
    int IdUser;
    List datos;
    
    @RequestMapping("indexUsuario.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = usuarioBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexUsuario");
        return mav;
    }
    
    @RequestMapping(value = "agregarUsuario.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Usuario());
        datos=ciudadBL.listar();
        mav.addObject("lista",datos);
        mav.setViewName("agregarUsuario");
        return mav;
    }
    
    @RequestMapping(value = "agregarUsuario.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Usuario u){
        usuarioBL.insertar(u);
        return new ModelAndView("redirect:/indexUsuario.htm");
    }
    
    @RequestMapping(value = "editarUsuario.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdUser= Integer.parseInt(request.getParameter("IdUser"));
        datos = usuarioBL.buscar(IdUser);
        mav.addObject("lista", datos);
        datos=ciudadBL.listar();
        mav.addObject("listaC", datos);
        mav.setViewName("editarUsuario");
        return mav;
    }
    
    @RequestMapping(value = "editarUsuario.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Usuario u){
        usuarioBL.actualizar(u);
        return new ModelAndView ("redirect:/indexUsuario.htm");
    }
    
    @RequestMapping("deleteUsuario.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdUser = Integer.parseInt(request.getParameter("IdUser"));
        ciudadBL.eliminar(IdUser);
        return new ModelAndView("redirect:/indexUsuario.htm");
    }
}
