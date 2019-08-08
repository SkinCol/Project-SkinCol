/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.MaterialBL;
import Model.Material;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel
 */
public class MaterialController {
    
    ModelAndView mav = new ModelAndView();
    MaterialBL materialBL = new MaterialBL();
    int IdMaterial;
    List datos;
    
    @RequestMapping("indexMaterial.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = materialBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexMaterial");
        return mav;
    }
    
    @RequestMapping(value = "agregarMaterial.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Material());
        mav.setViewName("agregarMaterial");
        return mav;
    }
    
    @RequestMapping(value = "agregarMaterial.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Material m){
        materialBL.insertar(m);
        return new ModelAndView("redirect:/indexMaterial.htm");
    }
    
    @RequestMapping(value = "editarMaterial.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdMaterial = Integer.parseInt(request.getParameter("IdMaterial"));
        datos = materialBL.buscar(IdMaterial);
        mav.addObject("lista", datos);
        mav.setViewName("editarMaterial");
        return mav;
    }
    
    @RequestMapping(value = "editarMaterial.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Material m){
        materialBL.actualizar(m);
        return new ModelAndView ("redirect:/indexMaterial.htm");
    }
    
    @RequestMapping("deleteMaterial.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdMaterial = Integer.parseInt(request.getParameter("IdMaterial"));
        materialBL.eliminar(IdMaterial);
        return new ModelAndView("redirect:/indexMaterial.htm");
    }       
}