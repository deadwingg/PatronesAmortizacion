/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service;

import com.caidosdelcatre.domain.Cuota;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomez
 */
public abstract class Credito {

    protected double interesAnual;
    protected double capital;
    protected List<Cuota> cuotas;

    public Credito(double capital, double interes) {
        this.capital = capital;
        this.interesAnual = interes;
        this.cuotas = new ArrayList<>();
        calcularCuotas();
    }

    protected double obtenerInteresMensual() {
        return interesAnual / 100 / 365 * 30;
    }

    public List<Cuota> obtenerCuotas() {
        return cuotas;
    }

    public abstract String obtenerSistemaDeAmortizacion();

    public Double obtenerInteresAnual() {
        return interesAnual;
    }

    public double obtenerCapital() {
        return capital;
    }

    protected abstract void calcularCuotas();
}
