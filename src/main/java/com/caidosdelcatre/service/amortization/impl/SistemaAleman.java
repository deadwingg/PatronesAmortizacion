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
public class SistemaAleman implements SistemaDeAmortizacion {

    private final String tipo = "ALEMAN";

    @Override
    public List<Cuota> calcularCuotas(double capital, double interes, int nroCuotas) {
        final double cuotaDeAmortizacion = capital / nroCuotas;
        final double interesMensual = interes / 100 / 365 * 30;
        double restoDeCapital = capital - cuotaDeAmortizacion;
        double cuotaDeInteres = capital * interesMensual;
        List<Cuota> cuotas = new ArrayList<>();
        for (int i = 0; i < nroCuotas; i++) {
            cuotas.add(new Cuota(i + 1, cuotaDeAmortizacion + cuotaDeInteres, restoDeCapital));
            cuotaDeInteres = restoDeCapital * interesMensual;
            restoDeCapital -= cuotaDeAmortizacion;
        }
        return cuotas;
    }

    @Override
    public String obtenerTipo() {
        return tipo;
    }

}
