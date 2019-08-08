/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.FacInsumosBL;
import Business.MaterialBL;
import Business.ProveedorBL;
import Model.FacInsumos;
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
public class FacInsumosController {
    ModelAndView mav = new ModelAndView();
    FacInsumosBL facinsumosBL = new FacInsumosBL();
    MaterialBL materialBL = new MaterialBL();
    ProveedorBL proveedorBL = new ProveedorBL();
    int IdFacturaInsumos;
    List datos;
  
    
    @RequestMapping("indexFacInsumos.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = facinsumosBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexFacInsumos");
        return mav;
    }
    
    @RequestMapping(value = "agregarFacInsumos.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new FacInsumos());
        datos=materialBL.listar(); 
        mav.addObject("lista",datos);
        datos=proveedorBL.listar();
        mav.addObject("listap",datos);
        mav.setViewName("agregarFacInsumos");
        return mav;
    }
    
    @RequestMapping(value = "agregarFacInsumos.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(FacInsumos f){
        facinsumosBL.insertar(f);
        return new ModelAndView("redirect:/indexFacInsumos.htm");
    }
    
    @RequestMapping(value = "editarFacInsumos.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdFacturaInsumos = Integer.parseInt(request.getParameter("IdFacturaInsumos"));
        datos = facinsumosBL.buscar(IdFacturaInsumos);
        mav.addObject("lista", datos);
        datos=materialBL.listar();
        mav.addObject("listaM", datos);
        //mav.addObject("listap", datos);
        datos=proveedorBL.listar();      
        mav.addObject("listaP", datos);
        mav.setViewName("editarFacInsumos");
        return mav;
    }
    
    @RequestMapping(value = "editarFacInsumos.htm", method = RequestMethod.POST)
    public ModelAndView Editar(FacInsumos f){
        facinsumosBL.actualizar(f);
        return new ModelAndView ("redirect:/indexFacInsumos.htm");
    }
    
    @RequestMapping("deleteFacInsumos.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdFacturaInsumos = Integer.parseInt(request.getParameter("IdFacturaInsumos"));
        facinsumosBL.eliminar(IdFacturaInsumos);
        return new ModelAndView("redirect:/indexFacInsumos.htm");
    }
}
