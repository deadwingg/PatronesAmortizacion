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
public class CreditoAmericano extends Credito {

    public CreditoAmericano(double capital, double interes) {
        super(capital, interes);
    }

    @Override
    public void calcularCuotas() {
        double valorCuotaIntermedia = capital * obtenerInteresMensual();
        double valorCuotaFinal = capital + valorCuotaIntermedia;
        double resto = capital + valorCuotaIntermedia * 11;

        for (int i = 0; i < 11; i++, resto -= valorCuotaIntermedia) {
            cuotas.add(new Cuota(i + 1, valorCuotaIntermedia, resto));
        }

        cuotas.add(new Cuota(12, valorCuotaFinal, resto - capital));
    }

    @Override
    public String obtenerSistemaDeAmortizacion() {
        return "Americano";
    }
}
