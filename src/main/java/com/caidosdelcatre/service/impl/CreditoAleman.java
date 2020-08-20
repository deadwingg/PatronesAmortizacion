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
public class CreditoAleman extends Credito {

    public CreditoAleman(double capital, double interes) {
        super(capital, interes);
    }

    @Override
    public void calcularCuotas() {
        final double cuotaDeAmortizacion = capital / 12;
        final double interesMensual = obtenerInteresMensual();

        double restoDeCapital = capital - cuotaDeAmortizacion;
        double cuotaDeInteres = restoDeCapital * interesMensual;

        for (int i = 0; i < 12; i++, restoDeCapital -= cuotaDeAmortizacion, cuotaDeInteres = restoDeCapital * interesMensual) {
            cuotas.add(new Cuota(i + 1, cuotaDeAmortizacion + cuotaDeInteres, restoDeCapital));
        }
    }

    @Override
    public String obtenerSistemaDeAmortizacion() {
        return "Aleman";
    }

}
