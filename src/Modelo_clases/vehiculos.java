/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_clases;

/**
 *
 * @author ikerr
 */
public abstract class vehiculos {
    
    protected String cii, marca, proveedor;
    protected int anyoCompra;
    protected String estado;

    public vehiculos(String cii, String marca, String proveedor, int anyoCompra, String estado) {
        this.cii = cii;
        this.marca = marca;
        this.proveedor = proveedor;
        this.anyoCompra = anyoCompra;
        this.estado = estado;
    }

    public String getCii() {
        return cii;
    }

    public void setCii(String cii) {
        this.cii = cii;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getAnyoCompra() {
        return anyoCompra;
    }

    public void setAnyoCompra(int anyoCompra) {
        this.anyoCompra = anyoCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

