/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.SkinBL;
import Business.CategoriaBL;
import Model.Skin;
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
public class SkinController {
    ModelAndView mav = new ModelAndView();
    SkinBL skinBL = new SkinBL();
    CategoriaBL categoriaBL = new CategoriaBL();
    int IdSkin;
    List datos;
    
    @RequestMapping("indexSkin.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = skinBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexSkin");
        return mav;
    }
    
    @RequestMapping(value = "agregarSkin.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Skin());
        datos=categoriaBL.listar();
        mav.addObject("lista",datos);
        mav.setViewName("agregarSkin");
        return mav;
    }
    
    @RequestMapping(value = "agregarSkin.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Skin s){
        skinBL.insertar(s);
        return new ModelAndView("redirect:/indexSkin.htm");
    }
    
    @RequestMapping(value = "editarSkin.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdSkin = Integer.parseInt(request.getParameter("IdSkin"));
        datos = skinBL.buscar(IdSkin);
        mav.addObject("lista", datos);
        datos=categoriaBL.listar();
        mav.addObject("listaC", datos);
        mav.setViewName("editarSkin");
        return mav;
    }
    
    @RequestMapping(value = "editarSkin.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Skin s){
        skinBL.actualizar(s);
        return new ModelAndView ("redirect:/indexSkin.htm");
    }
    
    @RequestMapping("deleteSkin.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdSkin = Integer.parseInt(request.getParameter("IdSkin"));
        skinBL.eliminar(IdSkin);
        return new ModelAndView("redirect:/indexSkin.htm");
    }
    
}
