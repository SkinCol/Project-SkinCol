/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Solicitud;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class SolicitudDL {
   Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List Listar(){
        String sql = "SELECT s.IdSolicitud, sk.Imagen as Skin, d.Imagen as Dispositivo, u1.Nombres as Administrador, u2.Nombres as Cliente, s.CostoSkin \n" +
"                     FROM  dispositivo d, skin sk, solicitudskin s\n" +
"                     INNER JOIN usuario u1 on s.IdAdmin=u1.IdUser INNER JOIN usuario u2 on s.IdUser=u2.IdUser\n" +
"                     WHERE d.IdDispositivo=s.IdDispositivo AND sk.IdSkin=s.IdSkin";
        datos = jdbctemplate.queryForList(sql);
        return datos;        
    }
    
    public void insertar(Solicitud s){
        String sql = "insert into solicitudskin (IdSkin, IdDispositivo, IdUser, IdAdmin, CostoSkin) values (?, ?, ?, ?, ?)";
        jdbctemplate.update(sql,s.getIdSkin(), s.getIdDispositivo(), s.getIdUser(), s.getIdAdmin(), s.getCostoSkin());
    }
    
    public List buscar(int IdSolicitud){
        String sql = "select * from solicitudskin where IdSolicitud="+IdSolicitud;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void actualizar(Solicitud s){
        String sql = "update solicitudSkin set IdSkin=?, IdDispositivo=?, IdUser=?, IdAdmin=? where IdSolicitud=?";
        jdbctemplate.update(sql,s.getIdDispositivo(), s.getIdUser(), s.getIdAdmin(), s.getCostoSkin(), s.getIdSolicitud());
    }
    
    public void eliminar(int IdSolicitud){
        String sql = "delete from solicitudskin where IdSolicitud =" + IdSolicitud;
        this.jdbctemplate.update(sql);
    } 
}
