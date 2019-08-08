/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.CategoriaBL;
import Model.Categoria;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel
 */
public class CategoriaController {
    
    ModelAndView mav = new ModelAndView();
    CategoriaBL categoriaBL = new CategoriaBL();
    int IdCategoria;
    List datos;
    
    @RequestMapping("indexCategoria.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = categoriaBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexCategoria");
        return mav;
    }
    
    @RequestMapping(value = "agregarCategoria.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Categoria());
        mav.setViewName("agregarCategoria");
        return mav;
    }
    
    @RequestMapping(value = "agregarCategoria.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Categoria c){
        categoriaBL.insertar(c);
        return new ModelAndView("redirect:/indexCategoria.htm");
    }
    
    @RequestMapping(value = "editarCategoria.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdCategoria = Integer.parseInt(request.getParameter("IdCategoria"));
        datos = categoriaBL.buscar(IdCategoria);
        mav.addObject("lista", datos);
        mav.setViewName("editarCategoria");
        return mav;
    }
    
    @RequestMapping(value = "editarCategoria.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Categoria c){
        categoriaBL.actualizar(c);
        return new ModelAndView ("redirect:/indexCategoria.htm");
    }
    
    @RequestMapping("deleteCategoria.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdCategoria = Integer.parseInt(request.getParameter("IdCategoria"));
        categoriaBL.eliminar(IdCategoria);
        return new ModelAndView("redirect:/indexCategoria.htm");
    }    
}
