/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Envio;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class EnvioDL {
    
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List Listar(){
        String sql = "SELECT e.IdEnvio, u.Nombres as Usuario, f.IdFactura as Factura, e.Fecha \n" +
                     "FROM envio n, factura f, usuario u \n" +
                     "WHERE f.IdFactura=e.IdFactura and u.IdUser=e.IdUsuario";
        datos = jdbctemplate.queryForList(sql);
        return datos;        
    }
    
    public void insertar(Envio e){
        String sql = "insert into envio (IdUsuario, IdFactura, Fecha) values (?, ?, ?)";
        jdbctemplate.update(sql,e.getIdUsuario(), e.getIdFactura(), e.getFecha());
    }
    
    public List buscar(int IdEnvio){
        String sql = "select * from envio where IdEnvio="+IdEnvio;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void actualizar(Envio e){
        String sql = "update factura set IdSolicitud=?, IdUser=?, Fecha=? where Idciudad=?";
        jdbctemplate.update(sql,e.getIdUsuario(), e.getIdFactura(), e.getFecha(), e.getIdEnvio());
    }
    
    public void eliminar(int IdEnvio){
        String sql = "delete from envio where IdEnvio =" + IdEnvio;
        this.jdbctemplate.update(sql);
    }
}
