/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.util.conversor.impl.ConversorConGson;
import com.caidosdelcatre.fileoutput.GuardadorDePrestamos;
import com.caidosdelcatre.domain.factory.PrestamoFactory;
import com.caidosdelcatre.util.conversor.impl.ConversorConMustache;

/**
 *
 * @author gomez
 */
public class App {

    public static void main(String[] args) {
        int nroCuotas;
        if (args.length < 3) {
            System.out.println("uso java -jar <App.jar> <capital> <interes anual> <sistema> [<numero de cuotas>]");
            return;
        }
        if (args.length == 4) {
            nroCuotas = Integer.parseInt(args[3]);
        } else {
            nroCuotas = 12;
        }

        final double capital = Double.parseDouble(args[0]);
        final double interesAnual = Double.parseDouble(args[1]);
        final String sistemaDeAmortizacion = args[2];

        Prestamo prestamo
                = PrestamoFactory.obtenerPrestamo(interesAnual, capital, sistemaDeAmortizacion, nroCuotas);

        ConversorConGson conversorGson = new ConversorConGson();
        ConversorConMustache conversorMustache = new ConversorConMustache("cuotasAPagar");

        //Output
        GuardadorDePrestamos guardador = new GuardadorDePrestamos(conversorGson);
        guardador.guardar("prestamos", prestamo);

        guardador.setConversor(conversorMustache);
        guardador.guardar("prestamos", prestamo);
    }
}
