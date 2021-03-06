/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service.impl;

import com.caidosdelcatre.domain.Cuota;
import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.service.amortization.SistemaDeAmortizacion;
import com.caidosdelcatre.fileoutput.GuardadorDePrestamos;
import com.caidosdelcatre.service.amortization.factory.SistemaDeAmortizacionFactory;
import com.caidosdelcatre.service.PrestamoService;
import java.util.List;

/**
 *
 * @author gomez
 */
public class PrestamoServiceImpl implements PrestamoService {

    GuardadorDePrestamos guardador;

    public PrestamoServiceImpl(GuardadorDePrestamos guardador) {
        this.guardador = guardador;
    }

    @Override
    public Prestamo obtenerPrestamo(double interesAnual, double capital, String tipoDeAmortizacion, int nroCuotas) {
        SistemaDeAmortizacion sistemaPedido
                = SistemaDeAmortizacionFactory.getSistema(tipoDeAmortizacion.trim());
        List<Cuota> cuotas
                = sistemaPedido.calcularCuotas(capital, interesAnual, nroCuotas);
        return new Prestamo(interesAnual, capital, cuotas, nroCuotas, tipoDeAmortizacion);
    }

    @Override
    public void guardarPrestamo(String nombreDeArchivo, Prestamo prestamo) {
        guardador.guardar(nombreDeArchivo, prestamo);
    }

    @Override
    public String obtenerRepresentacion(Prestamo prestamo) {
        return (guardador.representar(prestamo));
    }

}
