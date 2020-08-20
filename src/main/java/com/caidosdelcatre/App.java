/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.representation.PresentadorDePrestamo;
import com.caidosdelcatre.representation.impl.PresentadorConTemplateMustache;
import com.caidosdelcatre.service.factory.SistemaDeAmortizacionFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import com.caidosdelcatre.service.SistemaDeAmortizacion;

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
        final String sistema = args[2];
        SistemaDeAmortizacion sistemaDeAmortizacion
                = SistemaDeAmortizacionFactory.obtenerSistema(sistema);

        Prestamo prestamo
                = new Prestamo(interesAnual, capital, sistemaDeAmortizacion, nroCuotas);

        PresentadorDePrestamo presentador
                = new PresentadorConTemplateMustache("cuotasAPagar");
//                = new PresentadorConGson();
        File path = new File("prestamo" + presentador.obtenerExtension());
        try {
            FileUtils.write(path, presentador.obtenerRepresentacion(prestamo), Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
