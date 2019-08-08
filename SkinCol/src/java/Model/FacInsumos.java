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
public class FacInsumos {
    private int IdFacturaInsumos;
    private int IdProveedor;
    private Proveedor Proveedor;
    private int IdMaterial;
    private Material Material;
    private int Cantidad;
    private double Costo;

    public int getIdFacturaInsumos() {
        return IdFacturaInsumos;
    }

    public void setIdFacturaInsumos(int IdFacturaInsumos) {
        this.IdFacturaInsumos = IdFacturaInsumos;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public Proveedor getProveedor() {
        return Proveedor;
    }

    public void setProveedor(Proveedor Proveedor) {
        this.Proveedor = Proveedor;
    }

    public int getIdMaterial() {
        return IdMaterial;
    }

    public void setIdMaterial(int IdMaterial) {
        this.IdMaterial = IdMaterial;
    }

    public Material getMaterial() {
        return Material;
    }

    public void setMaterial(Material Material) {
        this.Material = Material;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }
    
    
    
}
