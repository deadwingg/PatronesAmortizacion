/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.impl;

import com.caidosdelcatre.domain.Cuota;
import com.caidosdelcatre.service.CalculadorDeFinanciacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomez
 */
public class SistemaAleman implements CalculadorDeFinanciacion{

    @Override
    public List<Cuota> obtenerCuotas(double capital, double interes) {
        final double cuotaDeAmortizacion = capital / 12;
        final double interesMensual = interes/100/365*30;
        double restoDeCapital = capital - cuotaDeAmortizacion;
        double cuotaDeInteres = restoDeCapital * interesMensual;
        List<Cuota> cuotas = new ArrayList<>();
        for (int i = 0; i < 12; i++, restoDeCapital -= cuotaDeAmortizacion, cuotaDeInteres = restoDeCapital*interesMensual) {
            cuotas.add(new Cuota(i+1, cuotaDeAmortizacion + cuotaDeInteres,restoDeCapital));
        }
        return cuotas;
    }
    
}
