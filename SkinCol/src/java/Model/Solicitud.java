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
public class Solicitud {
    private int IdSolicitud;
    private int IdSkin;
    private Skin Skin;
    private int IdDispositivo;
    private Dispositivo Dispositivo;
    private int IdUser;
    private Usuario Cliente;
    private int IdAdmin;
    private Usuario Administrador;
    private double CostoSkin;

    public int getIdSolicitud() {
        return IdSolicitud;
    }

    public void setIdSolicitud(int IdSolicitud) {
        this.IdSolicitud = IdSolicitud;
    }

    public int getIdSkin() {
        return IdSkin;
    }

    public void setIdSkin(int IdSkin) {
        this.IdSkin = IdSkin;
    }

    public Skin getSkin() {
        return Skin;
    }

    public void setSkin(Skin Skin) {
        this.Skin = Skin;
    }

    public int getIdDispositivo() {
        return IdDispositivo;
    }

    public void setIdDispositivo(int IdDispositivo) {
        this.IdDispositivo = IdDispositivo;
    }

    public Dispositivo getDispositivo() {
        return Dispositivo;
    }

    public void setDispositivo(Dispositivo Dispositivo) {
        this.Dispositivo = Dispositivo;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public Usuario getCliente() {
        return Cliente;
    }

    public void setCliente(Usuario Cliente) {
        this.Cliente = Cliente;
    }

    public int getIdAdmin() {
        return IdAdmin;
    }

    public void setIdAdmin(int IdAdmin) {
        this.IdAdmin = IdAdmin;
    }

    public Usuario getAdministrador() {
        return Administrador;
    }

    public void setAdministrador(Usuario Administrador) {
        this.Administrador = Administrador;
    }

    public double getCostoSkin() {
        return CostoSkin;
    }

    public void setCostoSkin(double CostoSkin) {
        this.CostoSkin = CostoSkin;
    }
  
}
