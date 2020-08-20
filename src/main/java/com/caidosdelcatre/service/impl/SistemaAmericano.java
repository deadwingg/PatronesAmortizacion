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
public class SistemaAmericano implements CalculadorDeFinanciacion {

    @Override
    public List<Cuota> obtenerCuotas(double capital, double interes) {
        double alicuota = interes/100/365*30;
        double valorCuotaIntermedia = capital * alicuota;
        double valorCuotaFinal = capital + valorCuotaIntermedia;
        double resto = capital + valorCuotaIntermedia * 11;
        
        List<Cuota> cuotas = new ArrayList();
        for (int i = 0; i < 11; i++, resto-=valorCuotaIntermedia) {
            cuotas.add(new Cuota(i+1, valorCuotaIntermedia, resto));
        }
        
        cuotas.add(new Cuota(12,valorCuotaFinal, resto-capital));
        return cuotas;
    }
    
}
