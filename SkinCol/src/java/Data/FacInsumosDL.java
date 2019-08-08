/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.FacInsumos;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class FacInsumosDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    
    public List Listar(){
        String sql = "SELECT f.IdFacturaInsumos, p.Nombre as Proveedor, m.Nombre as Material, f.cantidad, f.costo\n" +
                     "FROM proveedor p, material m, facturainsumos f \n" +
                     "WHERE p.IdProveedor = f.IdProveedor and m.IdMaterial = f.IdMaterial";
        datos = jdbctemplate.queryForList(sql);
        return datos;        
    }
    
    public void insertar(FacInsumos f){
        String sql = "insert into facturainsumos (IdProveedor, IdMaterial, Cantidad, Costo) values (?, ?, ?, ?)";
        jdbctemplate.update(sql,f.getIdProveedor(),f.getIdMaterial(), f.getCantidad(), f.getCosto());
    }
    
    public List buscar(int IdFacturaInsumos){
        String sql = "select * from facturainsumos where IdFacturaInsumos="+IdFacturaInsumos;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void actualizar(FacInsumos f){
        String sql = "update facturainsumos set IdProveedor=?, IdMaterial=?, Cantidad=?, Costo=? where IdFacturaInsumos=?";
        jdbctemplate.update(sql,f.getIdMaterial(), f.getIdProveedor(), f.getCantidad(), f.getCosto(),f.getIdFacturaInsumos());
    }
    
    public void eliminar(int IdFacturaInsumos){
        String sql = "delete from facturainsumos where IdFacturaInsumos =" + IdFacturaInsumos;
        this.jdbctemplate.update(sql);
    }
    
}
