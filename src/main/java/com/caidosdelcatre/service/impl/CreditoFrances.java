/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.impl;

import com.caidosdelcatre.domain.Cuota;
import com.caidosdelcatre.service.Credito;

/**
 *
 * @author gomez
 */
public class CreditoFrances extends Credito {

    public CreditoFrances(double capital, double interes) {
        super(capital, interes);
    }

    @Override
    public void calcularCuotas() {
        final double interesMensual = obtenerInteresMensual();

        double valorCuota = capital
                * (interesMensual * Math.pow(interesMensual + 1, 12)
                / (Math.pow(interesMensual + 1, 12) - 1));
        double resto = valorCuota * 11;

        for (int i = 0; i < 12; i++, resto -= valorCuota) {
            cuotas.add(new Cuota(i + 1, valorCuota, resto));
        }
    }

    @Override
    public String obtenerSistemaDeAmortizacion() {
        return "Frances";
    }

}
