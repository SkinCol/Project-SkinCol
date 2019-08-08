/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Factura;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class FacturaDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List Listar(){
        String sql = "SELECT f.IdFactura, s.CostoSkin as Solicitud, u.Nombres as Usuario, f.Fecha \n" +
                     "FROM factura f, solicitudskin s, usuario u \n" +
                     "WHERE s.IdSolicitud=f.IdSolicitud and u.IdUser=f.IdUser";
        datos = jdbctemplate.queryForList(sql);
        return datos;        
    }
    
    public void insertar(Factura f){
        String sql = "insert into factura (IdSolicitud, IdUser, Fecha) values (?, ?, ?)";
        jdbctemplate.update(sql,f.getIdSolicitud(), f.getIdUser(), f.getFecha());
    }
    
    public List buscar(int IdFactura){
        String sql = "select * from factura where IdFactura="+IdFactura;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void actualizar(Factura f){
        String sql = "update factura set IdSolicitud=?, IdUser=?, Fecha=? where Idciudad=?";
        jdbctemplate.update(sql,f.getIdSolicitud(), f.getIdUser(),f.getIdFactura());
    }
    
    public void eliminar(int IdFactura){
        String sql = "delete from ciudad where IdFactura =" + IdFactura;
        this.jdbctemplate.update(sql);
    }
}
