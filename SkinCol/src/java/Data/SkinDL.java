/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Skin;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class SkinDL {
    
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List Listar(){
        String sql = "SELECT s.IdSkin, c.Nombre as Categoria, s.IdSkin, s.Imagen, s.Disponible \n" +
                     "FROM skin s, categoria c \n" +
                     "WHERE c.IdCategoria=s.IdCategoria";
        datos = jdbctemplate.queryForList(sql);
        return datos;        
    }
    
    public void insertar(Skin s){
        String sql = "insert into skin (IdCategoria, Nombre, Imagen, Disponible) values (?, ?, ?, ?)";
        jdbctemplate.update(sql,s.getIdCategoria(), s.getNombre(), s.getImagen(),s.isDisponible());
    }
    
    public List buscar(int IdSkin){
        String sql = "select * from skin where IdSkin="+IdSkin;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void actualizar(Skin s){
        String sql = "update skin set IdCategoria=?, Nombre=?, Imagen=?, Disponible=? where IdSkin=?";
        jdbctemplate.update(sql,s.getIdCategoria(), s.getNombre(), s.getImagen(),s.isDisponible(),s.getIdSkin());
    }
    
    public void eliminar(int IdSkin){
        String sql = "delete from skin where IdSkin =" + IdSkin;
        this.jdbctemplate.update(sql);
    }
}
