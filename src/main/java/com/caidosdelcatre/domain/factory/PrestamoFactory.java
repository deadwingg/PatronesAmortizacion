/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.domain.factory;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.domain.amortization.SistemaDeAmortizacion;
import com.caidosdelcatre.domain.amortization.impl.SistemaAleman;
import com.caidosdelcatre.domain.amortization.impl.SistemaAmericano;
import com.caidosdelcatre.domain.amortization.impl.SistemaFrances;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gomez
 */
public class PrestamoFactory {

    private static final Map<String, SistemaDeAmortizacion> sistemas;

    static {
        sistemas = new HashMap<>();
        sistemas.put("Americano", new SistemaAmericano());
        sistemas.put("Aleman", new SistemaAleman());
        sistemas.put("Frances", new SistemaFrances());
    }

    public static Prestamo obtenerPrestamo(double interesAnual, double capital, String tipoDeAmortizacion, int nroCuotas) {
        SistemaDeAmortizacion sistemaPedido = sistemas.get(tipoDeAmortizacion);
        if (sistemaPedido == null) {
            throw new RuntimeException("Sistema no encontrado");
        } else {
            return new Prestamo(interesAnual, capital, sistemaPedido, nroCuotas);
        }
    }
}
