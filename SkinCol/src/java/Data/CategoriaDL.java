/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Categoria;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *
 * @author angel
 */
public class CategoriaDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List listar(){
        String sql = "select * from categoria";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void insertar(Categoria c){
        try{
        String sql = "insert into categoria (Nombre) values (?)";
        jdbctemplate.update(sql,c.getNombre());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List buscar(int IdCategoria){
       
        String sql = "select * from categoria where IdCategoria="+IdCategoria;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;        
    }
    public void actualizar(Categoria c){
        try{
        String sql = "update categoria set Nombre=? where IdCategoria=?";
        jdbctemplate.update(sql,c.getNombre(),c.getIdCategoria());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void eliminar(int IdCategoria){
        String sql = "delete from categoria where IdCategoria =" + IdCategoria;
        this.jdbctemplate.update(sql);
    }
}
