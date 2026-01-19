/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo_clases;

/**
 *
 * @author ikerr
 */
public class moto extends vehiculos {
    
    private String matricula;
    private int revision;
    private double bateria;

    public moto(String matricula, int revision, double bateria, String cii, String marca, String proveedor, int anyoCompra, String estado) {
        super(cii, marca, proveedor, anyoCompra, estado);
        this.matricula = matricula;
        this.revision = revision;
        this.bateria = bateria;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }
    
}
