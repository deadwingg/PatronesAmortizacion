/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.impl;

import com.caidosdelcatre.domain.Cuota;
import java.util.ArrayList;
import java.util.List;
import com.caidosdelcatre.service.SistemaDeAmortizacion;

/**
 *
 * @author gomez
 */
public class SistemaFrances implements SistemaDeAmortizacion {

    @Override
    public List<Cuota> obtenerCuotas(double capital, double interes) {
        final double interesMensual = interes / 100 / 365 * 30;

        double valorCuota = capital
                * (interesMensual * Math.pow(interesMensual + 1, 12)
                / (Math.pow(interesMensual + 1, 12) - 1));
        double resto = valorCuota * 11;

        List<Cuota> cuotas = new ArrayList<>();
        for (int i = 0; i < 12; i++, resto -= valorCuota) {
            cuotas.add(new Cuota(i + 1, valorCuota, resto));
        }
        return cuotas;
    }

    @Override
    public String getName() {
        return "Frances";
    }
}
