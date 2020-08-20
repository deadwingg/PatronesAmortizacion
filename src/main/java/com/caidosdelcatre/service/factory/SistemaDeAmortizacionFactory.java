/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.factory;

import com.caidosdelcatre.service.impl.SistemaAmericano;
import com.caidosdelcatre.service.impl.SistemaFrances;
import com.caidosdelcatre.service.impl.SistemaAleman;
import com.caidosdelcatre.service.SistemaDeAmortizacion;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gomez
 */
public class SistemaDeAmortizacionFactory {

    private static final Map<String, SistemaDeAmortizacion> sistemas;

    static {
        sistemas = new HashMap<>();
        sistemas.put("Americano", new SistemaAmericano());
        sistemas.put("Aleman", new SistemaAleman());
        sistemas.put("Frances", new SistemaFrances());
    }

    public static SistemaDeAmortizacion obtenerSistema(String tipo) {
        SistemaDeAmortizacion sistemaPedido = sistemas.get(tipo);
        if (sistemaPedido == null) {
            throw new RuntimeException("Sistema no encontrado");
        } else {
            return sistemaPedido;
        }
    }
}
