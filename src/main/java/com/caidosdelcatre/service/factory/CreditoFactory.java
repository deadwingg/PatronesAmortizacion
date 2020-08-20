/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.factory;
import com.caidosdelcatre.service.impl.CreditoAmericano;
import com.caidosdelcatre.service.impl.CreditoFrances;
import com.caidosdelcatre.service.impl.CreditoAleman;
import com.caidosdelcatre.service.Credito;
/**
 *
 * @author gomez
 */
public class CreditoFactory {
    public static Credito obtenerCredito(String tipo, double capital, double interesAnual){
        switch(tipo){
            case "Americano":
                return new CreditoAmericano(capital, interesAnual);
            case "Aleman":
                return new CreditoAleman(capital, interesAnual);
            case "Frances":
                return new CreditoFrances(capital, interesAnual);
            default:
                throw new UnsupportedOperationException(tipo + " no es un sistema valido");
        }
    }
}
