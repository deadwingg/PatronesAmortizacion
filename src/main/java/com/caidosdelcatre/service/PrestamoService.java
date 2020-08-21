/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service;

import com.caidosdelcatre.domain.Prestamo;

/**
 *
 * @author gomez
 */
public interface PrestamoService {

    Prestamo obtenerPrestamo(double interesAnual, double capital, String tipoDeAmortizacion, int nroCuotas);

    void guardarPrestamo(String nombreDeArchivo, Prestamo prestamo);

    String obtenerRepresentacion(Prestamo prestamo);
}
