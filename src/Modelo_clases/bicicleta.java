/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_clases;

/**
 *
 * @author ikerr
 */
public class bicicleta extends vehiculos {
    
    private int caducidadLlantas;
    private double bateria;

    public bicicleta(int caducidadLlantas, double bateria, String cii, String marca, String proveedor, int anyoCompra, String estado) {
        super(cii, marca, proveedor, anyoCompra, estado);
        this.caducidadLlantas = caducidadLlantas;
        this.bateria = bateria;
    }

    public int getCaducidadLlantas() {
        return caducidadLlantas;
    }

    public void setCaducidadLlantas(int caducidadLlantas) {
        this.caducidadLlantas = caducidadLlantas;
    }

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }

    
}
