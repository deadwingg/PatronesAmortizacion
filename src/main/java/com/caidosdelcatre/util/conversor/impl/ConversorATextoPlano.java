/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.util.conversor.impl;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.util.conversor.ConversorATexto;

/**
 *
 * @author gomez
 */
public class ConversorATextoPlano implements ConversorATexto {

    @Override
    public String obtenerRepresentacion(Prestamo prestamo) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Prestamo con sistema ")
                .append(prestamo.getNombreDeSistema())
                .append(System.lineSeparator())
                .append("Cuotas: ")
                .append(prestamo.getCuotas().size())
                .append(" - Interes anual: ")
                .append(prestamo.getInteresAnual())
                .append(" - Capital: ")
                .append(prestamo.getCapital())
                .append(System.lineSeparator());

        prestamo.getCuotas().forEach((cuota) -> {
            buffer.append(cuota.toString())
                    .append(System.lineSeparator());
        });
        return buffer.toString();
    }

    @Override
    public String obtenerExtension() {
        return ".txt";
    }

}
