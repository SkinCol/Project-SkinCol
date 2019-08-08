/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Usuario;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class UsuarioDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List Listar(){
        String sql = "SELECT u.IdUser, c.Nombre as Ciudad, u.Tipo, u.Nombres, u.Apellidos, u.Documento, u.Telefono, u.Direccion, u.Email, u.Contrasena, u.Estado \n" +
                     "FROM usuario u, ciudad c \n" +
                     "WHERE u.IdCiudad=c.IdCiudad";
        datos = jdbctemplate.queryForList(sql);
        return datos;        
    }
    
    public void insertar(Usuario u){
        String sql = "insert into usuario (IdCiudad, Tipo, Nombres, Apellidos, Documento, Telefono, Direccion, Email, Contrasena, Estado) \n"
                   + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbctemplate.update(sql,u.getIdCiudad(), u.isTipo(), u.getNombres(), u.getApellidos(), u.getDocumento(), u.getTelefono(), u.getDireccion(), u.getDireccion(), u.getEmail(), u.getContrasena(), u.isEstado());
    }
    
    public List buscar(int IdUser){
        String sql = "select * from usuario where IdUser="+IdUser;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void actualizar(Usuario u){
        String sql = "update usuario set IdCiudad=?, Tipo=?, Nombres=?, Apellidos=?, Documento=?, Telefono=?, Direccion=? Email=?, Contrasena=? Estado=? where IdUser=?";
        jdbctemplate.update(sql,u.getIdCiudad(), u.isTipo(), u.getNombres(), u.getApellidos(), u.getDocumento(), u.getTelefono(), u.getDireccion(), u.getDireccion(), u.getEmail(), u.getContrasena(), u.isEstado(), u.getIdUser());
    }
    
    public void eliminar(int IdUser){
        String sql = "delete from usuario where IdUser =" + IdUser;
        this.jdbctemplate.update(sql);
    }
}
