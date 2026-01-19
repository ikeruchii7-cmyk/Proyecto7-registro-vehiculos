/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_clases;

/**
 *
 * @author ikerr
 */
public class patin extends vehiculos {
   
    protected int numerolicencia;
    protected double potencia, velocidadmaxima, bateria;

    public patin(int numerolicencia, double potencia, double velocidadmaxima, double bateria, String cii, String marca, String proveedor, int anyoCompra, String estado) {
        super(cii, marca, proveedor, anyoCompra, estado);
        this.numerolicencia = numerolicencia;
        this.potencia = potencia;
        this.velocidadmaxima = velocidadmaxima;
        this.bateria = bateria;
    }

    public int getNumerolicencia() {
        return numerolicencia;
    }

    public void setNumerolicencia(int numerolicencia) {
        this.numerolicencia = numerolicencia;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getVelocidadmaxima() {
        return velocidadmaxima;
    }

    public void setVelocidadmaxima(double velocidadmaxima) {
        this.velocidadmaxima = velocidadmaxima;
    }

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }
    
}
