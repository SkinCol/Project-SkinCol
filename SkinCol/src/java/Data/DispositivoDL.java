/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Dispositivo;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class DispositivoDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List listar(){
        String sql = "select * from dispositivo";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
   
    public void insertar(Dispositivo d){
        try{
        String sql = "insert into dispositivo (Modelo, Marca, Tipo, Imagen) values (?, ?, ?, ?)";
        jdbctemplate.update(sql,d.getModelo(), d.getMarca(), d.getTipo(), d.getImagen());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }    
}
    public List buscar(int IdDispositivo){
       
        String sql = "select * from dispositivo where IdDispositivo="+IdDispositivo;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;      
    }   
    public void actualizar(Dispositivo d){
        try{
        String sql = "update dispositivo set Modelo=?, Marca=?, Tipo=?, Imagen=? where IdDispositivo=?";
        jdbctemplate.update(sql,d.getModelo(), d.getMarca(), d.getTipo(), d.getImagen(), d.getIdDispositivo());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }    
    public void eliminar(int IdDispositivo){
        String sql = "delete from dispositivo where IdDispositivo =" + IdDispositivo;
        this.jdbctemplate.update(sql);
    }
}
