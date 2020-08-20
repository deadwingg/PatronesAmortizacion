/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre;

import com.caidosdelcatre.util.GeneradorDeTablaHTML;
import com.caidosdelcatre.service.factory.CreditoFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import com.caidosdelcatre.service.Credito;

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
        final String sistema = args[2];
        final double interesAnual = Double.parseDouble(args[1]);
        final double capital = Double.parseDouble(args[0]);

        Credito credito
                = CreditoFactory.obtenerCredito(sistema, capital, interesAnual);

        GeneradorDeTablaHTML genHTML
                = new GeneradorDeTablaHTML("cuotasAPagar", credito);

        File path = new File("cuotas.html");
        try {
            FileUtils.write(path, genHTML.obtenerHTML(), Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
