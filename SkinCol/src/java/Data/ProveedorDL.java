/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Proveedor;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author angel
 */
public class ProveedorDL {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;
    
    public List listar(){
        String sql = "select * from proveedor";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
    
    public void insertar(Proveedor p){
        try{
        String sql = "insert into proveedor (Nombre, NIT, Direccion, Correo, Telefono) values (?, ?, ?, ?, ?)";
        jdbctemplate.update(sql,p.getNombre(),p.getNIT(),p.getDireccion(),p.getCorreo(),p.getTelefono());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List buscar(int IdProveedor){
       
        String sql = "select * from proveedor where IdProveedor="+IdProveedor;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;        
    }
    public void actualizar(Proveedor p){
        try{
        String sql = "update proveedor set Nombre=?, NIT=?, Direccion=?, Correo=?, Telefono=? where IdCategoria=?";
        jdbctemplate.update(sql,p.getNombre(),p.getNIT(),p.getDireccion(),p.getCorreo(),p.getTelefono(),p.getIdProveedor());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void eliminar(int IdProveedor){
        String sql = "delete from proveedor where IdProveedor =" + IdProveedor;
        this.jdbctemplate.update(sql);
    }
    
}
