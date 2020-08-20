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
public class SistemaAmericano implements SistemaDeAmortizacion {

    @Override
    public List<Cuota> calcularCuotas(double capital, double interes, int nroCuotas) {
        double alicuota = interes / 100 / 365 * 30;
        double valorCuotaIntermedia = capital * alicuota;
        double valorCuotaFinal = capital + valorCuotaIntermedia;
        double resto = capital + valorCuotaIntermedia * nroCuotas - 1;

        List<Cuota> cuotas = new ArrayList();
        for (int i = 0; i < nroCuotas - 1; i++, resto -= valorCuotaIntermedia) {
            cuotas.add(new Cuota(i + 1, valorCuotaIntermedia, resto));
        }

        cuotas.add(new Cuota(nroCuotas, valorCuotaFinal, resto - capital));
        return cuotas;
    }

    @Override
    public String getName() {
        return "Americano";
    }
}
