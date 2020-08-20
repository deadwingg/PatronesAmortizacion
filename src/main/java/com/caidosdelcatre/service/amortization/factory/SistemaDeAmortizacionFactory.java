/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.amortization.factory;

import com.caidosdelcatre.service.amortization.SistemaDeAmortizacion;
import com.caidosdelcatre.service.amortization.Sistemas;
import com.caidosdelcatre.service.amortization.impl.SistemaAleman;
import com.caidosdelcatre.service.amortization.impl.SistemaAmericano;
import com.caidosdelcatre.service.amortization.impl.SistemaFrances;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gomez
 */
public class SistemaDeAmortizacionFactory {

    private static final Map<Sistemas, SistemaDeAmortizacion> sistemas;

    static {
        sistemas = new HashMap<>();
        sistemas.put(Sistemas.AMERICANO, new SistemaAmericano());
        sistemas.put(Sistemas.ALEMAN, new SistemaAleman());
        sistemas.put(Sistemas.FRANCES, new SistemaFrances());
    }

    public static SistemaDeAmortizacion getSistema(Sistemas sistema) {
        return sistemas.get(sistema);
    }
}
