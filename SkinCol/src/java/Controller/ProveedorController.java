/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.ProveedorBL;
import Model.Proveedor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author angel
 */
public class ProveedorController {
    ModelAndView mav = new ModelAndView();
    ProveedorBL proveedorBL = new ProveedorBL();
    int IdProveedor;
    List datos;
    
    @RequestMapping("indexProveedor.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = proveedorBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexProveedor");
        return mav;
    }
    
    @RequestMapping(value = "agregarProveedor.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Proveedor());
        mav.setViewName("agregarProveedor");
        return mav;
    }
    
    @RequestMapping(value = "agregarProveedor.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Proveedor p){
        proveedorBL.insertar(p);
        return new ModelAndView("redirect:/indexProveedor.htm");
    }
    
    @RequestMapping(value = "editarProveedor.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request){
        IdProveedor = Integer.parseInt(request.getParameter("IdProveedor"));
        datos = proveedorBL.buscar(IdProveedor);
        mav.addObject("lista", datos);
        mav.setViewName("editarProveedor");
        return mav;
    }
    
    @RequestMapping(value = "editarProveedor.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Proveedor p){
        proveedorBL.actualizar(p);
        return new ModelAndView ("redirect:/indexProveedor.htm");
    }
    
    @RequestMapping("deleteProveedor.htm")
    public ModelAndView Delete(HttpServletRequest  request){
        IdProveedor = Integer.parseInt(request.getParameter("IdProveedor"));
        proveedorBL.eliminar(IdProveedor);
        return new ModelAndView("redirect:/indexProveedor.htm");
    }
    
}
