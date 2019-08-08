/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.CiudadBL;
import Business.DepartamentoBL;
import Model.Ciudad;
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
public class CiudadController {
    ModelAndView mav = new ModelAndView();
    CiudadBL ciudadBL = new CiudadBL();
    DepartamentoBL departamentoBL = new DepartamentoBL();
    int Idciudad;
    List datos;
    
    @RequestMapping("indexCiudad.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = ciudadBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexCiudad");
        return mav;
    }
    
    @RequestMapping(value = "agregarCiudad.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Ciudad());
        datos=departamentoBL.listar();
        mav.addObject("lista",datos);
        mav.setViewName("agregarCiudad");
        return mav;
    }
    
    @RequestMapping(value = "agregarCiudad.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Ciudad c){
        ciudadBL.insertar(c);
        return new ModelAndView("redirect:/indexCiudad.htm");
    }
    
    @RequestMapping(value = "editarCiudad.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        Idciudad = Integer.parseInt(request.getParameter("IdCiudad"));
        datos = ciudadBL.buscar(Idciudad);
        mav.addObject("lista", datos);
        datos=departamentoBL.listar();
        mav.addObject("listaD", datos);
        mav.setViewName("editarCiudad");
        return mav;
    }
    
    @RequestMapping(value = "editarCiudad.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Ciudad c){
        ciudadBL.actualizar(c);
        return new ModelAndView ("redirect:/indexCiudad.htm");
    }
    
    @RequestMapping("deleteCiudad.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        Idciudad = Integer.parseInt(request.getParameter("IdCiudad"));
        ciudadBL.eliminar(Idciudad);
        return new ModelAndView("redirect:/indexCiudad.htm");
    }
    
}
