/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_clases;

/**
 *
 * @author ikerr
 */
public class coche extends vehiculos {
    
    private String matricula, codigoIdentificacion;
    private double bateria;

    public coche(String matricula, String codigoIdentificacion, double bateria, String cii, String marca, String proveedor, int anyoCompra, String estado) {
        super(cii, marca, proveedor, anyoCompra, estado);
        this.matricula = matricula;
        this.codigoIdentificacion = codigoIdentificacion;
        this.bateria = bateria;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public void setCodigoIdentificacion(String codigoIdentificacion) {
        this.codigoIdentificacion = codigoIdentificacion;
    }

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }
    
}
