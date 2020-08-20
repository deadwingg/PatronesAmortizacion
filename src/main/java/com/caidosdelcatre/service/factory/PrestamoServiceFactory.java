/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.factory;

import com.caidosdelcatre.fileoutput.GuardadorDePrestamos;
import com.caidosdelcatre.service.PrestamoService;
import com.caidosdelcatre.service.impl.PrestamoServiceImpl;
import com.caidosdelcatre.util.conversor.Conversores;
import com.caidosdelcatre.util.conversor.factory.ConversorFactory;

/**
 *
 * @author gomez
 */
public class PrestamoServiceFactory {

    public static PrestamoService getService(Conversores tipoSalida) {
        return new PrestamoServiceImpl(new GuardadorDePrestamos(ConversorFactory.obtenerConversor(tipoSalida)));
    }
}
