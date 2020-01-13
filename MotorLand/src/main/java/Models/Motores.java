/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author kekor
 */
public class Motores {
   private  String modelo, fabricante;
   private int potencia, cantidad, peso;

    public Motores(String modelo, String fabricante, int potencia, int cantidad, int peso) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.potencia = potencia;
        this.cantidad = cantidad;
        this.peso = peso;
    }

    public Motores() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
   
   
}
