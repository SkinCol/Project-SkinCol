/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Ciudad;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class CiudadDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List Listar(){
        String sql = "SELECT c.IdCiudad, d.Nombre as Departamento, c.Nombre \n" +
                     "FROM ciudad c, departamento d \n" +
                     "WHERE d.IdDepartamento=c.IdDepartamento";
        datos = jdbctemplate.queryForList(sql);
        return datos;        
    }
    
    public void insertar(Ciudad c){
        String sql = "insert into ciudad (IdDepartamento, Nombre) values (?, ?)";
        jdbctemplate.update(sql,c.getIdDepartamento(), c.getNombre());
    }
    
    public List buscar(int IdCiudad){
        String sql = "select * from ciudad where IdCiudad="+IdCiudad;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void actualizar(Ciudad c){
        String sql = "update ciudad set IdDepartamento=?, Nombre=? where IdCiudad=?";
        jdbctemplate.update(sql,c.getIdDepartamento(), c.getNombre(),c.getIdCiudad());
    }
    
    public void eliminar(int IdCiudad){
        String sql = "delete from ciudad where IdCiudad =" + IdCiudad;
        this.jdbctemplate.update(sql);
    }
}
