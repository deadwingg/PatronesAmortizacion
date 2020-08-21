/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.domain;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author gomez
 */
public class Prestamo {

    private String sistema;
    private double interesAnual;
    private double capital;
    private List<Cuota> cuotas;

    public Prestamo(double interesAnual, double capital, List<Cuota> cuotas, int nroCuotas, String tipo) {
        this.interesAnual = interesAnual;
        this.capital = capital;
        this.cuotas = cuotas;
        this.sistema = tipo;
    }

    public List<Cuota> getCuotas() {
        return Collections.unmodifiableList(cuotas);
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public double getCapital() {
        return capital;
    }

    public String getNombreDeSistema() {
        return sistema;
    }
}
