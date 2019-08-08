/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Material;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class MaterialDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List listar(){
        String sql = "select * from material";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
    
     public void insertar(Material m){
        try{
        String sql = "insert into material (Nombre, Descripcion) values (?, ?)";
        jdbctemplate.update(sql,m.getNombre(),m.getDescripcion());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
     public List buscar(int IdMaterial){
       
        String sql = "select * from material where IdMaterial="+IdMaterial;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;        
    }
     public void actualizar(Material m){
        try{
        String sql = "update material set Nombre=?, Descripcion=? where IdMaterial=?";
        jdbctemplate.update(sql,m.getNombre(),m.getDescripcion(), m.getIdMaterial());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
     public void eliminar(int IdMaterial){
        String sql = "delete from material where IdMaterial =" + IdMaterial;
        this.jdbctemplate.update(sql);
    }
     
    
}
