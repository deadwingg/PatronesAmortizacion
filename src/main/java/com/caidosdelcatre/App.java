/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.representation.PresentadorDePrestamo;
import com.caidosdelcatre.representation.impl.PresentadorConJson;
import com.caidosdelcatre.service.factory.SistemaDeAmortizacionFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import com.caidosdelcatre.service.SistemaDeAmortizacion;
import com.google.gson.Gson;

/**
 *
 * @author gomez
 */
public class App {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("uso java -jar <App.jar> <capital> <interes anual> <sistema>");
            return;
        }

        final double capital = Double.parseDouble(args[0]);
        final double interesAnual = Double.parseDouble(args[1]);
        final String sistema = args[2];
        SistemaDeAmortizacion sistemaDeAmortizacion
                = SistemaDeAmortizacionFactory.obtenerCalculador(sistema);

        Prestamo prestamo = new Prestamo(interesAnual, capital, sistemaDeAmortizacion);

        PresentadorDePrestamo presentador
                //       = new PresentadorConTablaHTML("cuotasAPagar", prestamo);
                = new PresentadorConJson(new Gson(), prestamo);
        File path = new File("prestamo" + presentador.obtenerExtension());
        try {
            FileUtils.write(path, presentador.obtenerRepresentacion(), Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
