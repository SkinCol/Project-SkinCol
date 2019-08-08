/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Departamento;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class DepartamentoDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List listar(){
        String sql = "select * from departamento";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
   
    public void insertar(Departamento d){
        try{
        String sql = "insert into departamento (Nombre) values (?)";
        jdbctemplate.update(sql,d.getNombre());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }    
}
    public List buscar(int IdDepartamento){
       
        String sql = "select * from departamento where IdDepartamento="+IdDepartamento;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;      
    }   
    public void actualizar(Departamento d){
        try{
        String sql = "update departamento set Nombre=? where IdDepartamento=?";
        jdbctemplate.update(sql,d.getNombre(),d.getIdDepartamento());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }    
    public void eliminar(int IdDepartamento){
        String sql = "delete from departamento where IdDepartamento =" + IdDepartamento;
        this.jdbctemplate.update(sql);
    }
}
