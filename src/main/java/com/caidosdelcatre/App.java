/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.service.amortization.Sistemas;
import com.caidosdelcatre.service.PrestamoService;
import com.caidosdelcatre.service.factory.PrestamoServiceFactory;
import com.caidosdelcatre.util.conversor.Conversores;

/**
 *
 * @author gomez
 */
public class App {

    public static void main(String[] args) {
        int nroCuotas;
        if (args.length < 3) {
            System.out.println("uso java -jar <App.jar> <capital> <interes anual> <sistema> [<numero de cuotas>]");
            System.out.print("Sistemas de amortizacion disponibles: ");
            for (Sistemas s : Sistemas.values()) {
                System.out.print(s.toString() + " ");
            }
            System.out.println();
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

        PrestamoService prestamoService
                = PrestamoServiceFactory.getService(Conversores.JSONGSON);

        Prestamo prestamo = prestamoService.obtenerPrestamo(interesAnual, capital, sistemaDeAmortizacion, nroCuotas);
        //Output
        prestamoService.guardarPrestamo("prestamos", prestamo);
        prestamoService.mostrarPrestamo(prestamo);
    }
}
