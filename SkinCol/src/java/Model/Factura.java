/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author angel
 */
public class Factura {
    private int IdFactura;
    private int IdSolicitud;
    private Solicitud Solicitud;
    private int IdUser;
    private Usuario Usuario;
    private String Fecha;

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public int getIdSolicitud() {
        return IdSolicitud;
    }

    public void setIdSolicitud(int IdSolicitud) {
        this.IdSolicitud = IdSolicitud;
    }

    public Solicitud getSolicitud() {
        return Solicitud;
    }

    public void setSolicitud(Solicitud Solicitud) {
        this.Solicitud = Solicitud;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
   
}
