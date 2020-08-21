/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.factory;

import com.caidosdelcatre.fileoutput.GuardadorDePrestamos;
import com.caidosdelcatre.service.PrestamoService;
import com.caidosdelcatre.service.impl.PrestamoServiceImpl;
import com.caidosdelcatre.util.conversor.ConversorATexto;
import com.caidosdelcatre.util.conversor.Conversores;
import com.caidosdelcatre.util.conversor.factory.ConversorFactory;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gomez
 */
public class PrestamoServiceFactory {

    public static PrestamoService getService(Conversores tipoSalida) {
        return new PrestamoServiceImpl(new GuardadorDePrestamos(ConversorFactory.obtenerConversor(tipoSalida)));
    }

    public static PrestamoService getService(List<Conversores> tipoSalida) {
        List<ConversorATexto> conversores = tipoSalida.stream()
                .map(ConversorFactory::obtenerConversor)
                .collect(Collectors.toList());
        return new PrestamoServiceImpl(new GuardadorDePrestamos(conversores));
    }
}
