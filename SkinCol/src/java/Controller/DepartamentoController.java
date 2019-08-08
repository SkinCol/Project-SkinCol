/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.DepartamentoBL;
import Model.Departamento;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel
 */
public class DepartamentoController {
    ModelAndView mav = new ModelAndView();
    DepartamentoBL departamentoBL = new DepartamentoBL();
    int IdDepartamento;
    List datos;
    
    @RequestMapping("indexDepartamento.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = departamentoBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexDepartamento");
        return mav;
    }
    
    @RequestMapping(value = "agregarDepartamento.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Departamento());
        mav.setViewName("agregarDepartamento");
        return mav;
    }
    
    @RequestMapping(value = "agregarDepartamento.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Departamento d){
        departamentoBL.insertar(d);
        return new ModelAndView("redirect:/indexDepartamento.htm");
    }
    
    @RequestMapping(value = "editarDepartamento.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdDepartamento = Integer.parseInt(request.getParameter("IdDepartamento"));
        datos = departamentoBL.buscar(IdDepartamento);
        mav.addObject("lista", datos);
        mav.setViewName("editarDepartamento");
        return mav;
    }
    
    @RequestMapping(value = "editarDepartamento.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Departamento d){
        departamentoBL.actualizar(d);
        return new ModelAndView ("redirect:/indexDepartamento.htm");
    }
    
    @RequestMapping("deleteDepartamento.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdDepartamento = Integer.parseInt(request.getParameter("IdDepartamento"));
        departamentoBL.eliminar(IdDepartamento);
        return new ModelAndView("redirect:/indexDepartamento.htm");
    }
    
}
