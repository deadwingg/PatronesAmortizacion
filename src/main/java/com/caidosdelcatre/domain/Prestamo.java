/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.domain;

import com.caidosdelcatre.domain.amortization.SistemaDeAmortizacion;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author gomez
 */
public class Prestamo {

    private double interesAnual;
    private double capital;
    private List<Cuota> cuotas;
    private SistemaDeAmortizacion sistema;

    public Prestamo(double interesAnual, double capital, SistemaDeAmortizacion sistema, int nroCuotas) {
        this.interesAnual = interesAnual;
        this.capital = capital;
        this.sistema = sistema;
        cuotas = sistema.calcularCuotas(capital, interesAnual, nroCuotas);
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
        return sistema.obtenerTipo();
    }

}
