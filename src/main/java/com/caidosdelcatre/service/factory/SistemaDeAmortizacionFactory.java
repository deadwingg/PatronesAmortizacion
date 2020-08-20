/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.factory;
import com.caidosdelcatre.service.CalculadorDeFinanciacion;
import com.caidosdelcatre.service.impl.SistemaAmericano;
import com.caidosdelcatre.service.impl.SistemaFrances;
import com.caidosdelcatre.service.impl.SistemaAleman;
/**
 *
 * @author gomez
 */
public class SistemaDeAmortizacionFactory {
    public static CalculadorDeFinanciacion obtenerCalculador(String tipo){
        switch(tipo){
            case "Americano":
                return new SistemaAmericano();
            case "Aleman":
                return new SistemaAleman();
            case "Frances":
                return new SistemaFrances();
            default:
                throw new UnsupportedOperationException(tipo + " no es un sistema valido");
        }
    }
}
