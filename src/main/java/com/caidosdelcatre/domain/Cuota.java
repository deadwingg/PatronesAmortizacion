/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.domain;

/**
 *
 * @author gomez
 */
public class Cuota {

    private final int numero;
    private final double monto;
    private final double resto;

    public Cuota(int numero, double monto, double resto) {
        this.numero = numero;
        this.monto = Math.round(monto * 100) / 100.0;
        this.resto = Math.round(resto * 100) / 100.0;
    }

    public double getMonto() {
        return monto;
    }

    public int getNumero() {
        return numero;
    }

    public double getResto() {
        return resto;
    }

    @Override
    public String toString() {
        return "Cuota numero:" + numero + ", monto:" + monto + ", resto:" + resto;
    }

}
