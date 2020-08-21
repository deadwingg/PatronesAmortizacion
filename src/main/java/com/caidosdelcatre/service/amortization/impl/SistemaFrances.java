/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.amortization.impl;

import com.caidosdelcatre.service.amortization.SistemaDeAmortizacion;
import com.caidosdelcatre.domain.Cuota;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomez
 */
public class SistemaFrances implements SistemaDeAmortizacion {

    private final String tipo = "FRANCES";

    @Override
    public List<Cuota> calcularCuotas(double capital, double interes, int nroCuotas) {
        final double interesMensual = interes / 100 / 365 * 30;

        double valorCuota = capital
                * (interesMensual * Math.pow(interesMensual + 1, nroCuotas)
                / (Math.pow(interesMensual + 1, nroCuotas) - 1));
        double resto = valorCuota * 11;

        List<Cuota> cuotas = new ArrayList<>();
        for (int i = 0; i < nroCuotas; i++) {
            cuotas.add(new Cuota(i + 1, valorCuota, resto));
            resto -= valorCuota;
        }
        return cuotas;
    }

    @Override
    public String obtenerTipo() {
        return tipo;
    }
}
