/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.EnvioBL;
import Business.FacturaBL;
import Business.UsuarioBL;
import Model.Envio;
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
public class EnvioController {
    ModelAndView mav = new ModelAndView();
    EnvioBL envioBL = new EnvioBL();   
    UsuarioBL usuarioBL = new UsuarioBL();
    FacturaBL facturaBL = new FacturaBL();
    int IdEnvio;
    List datos;
    
    @RequestMapping("indexEnvio.htm")//Nombre para la url del navegador
    public ModelAndView Listar(){
        datos = envioBL.listar();
        mav.addObject("lista", datos);
        mav.setViewName("indexEnvio");
        return mav;
    }
    
    @RequestMapping(value = "agregarEnvio.htm", method = RequestMethod.GET)
    public ModelAndView Agregar(){
        mav.addObject(new Envio());
        datos=facturaBL.listar();
        mav.addObject("lista",datos);
        datos=usuarioBL.listar();
        mav.addObject("listau",datos);
        mav.setViewName("agregarEnvio");
        return mav;
    }
    
    @RequestMapping(value = "agregarEnvio.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Envio e){
        envioBL.insertar(e);
        return new ModelAndView("redirect:/indexEnvio.htm");
    }
    
}
