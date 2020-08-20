/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre;

import com.caidosdelcatre.domain.Cuota;
import com.caidosdelcatre.util.GeneradorDeTablaHTML;
import com.caidosdelcatre.service.CalculadorDeFinanciacion;
import com.caidosdelcatre.service.factory.SistemaDeAmortizacionFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author gomez
 */
public class App {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("uso java -jar <App.jar> <capital> <interes anual> <sistema>");
            return;
        }
        final String sistema = args[2];
        CalculadorDeFinanciacion calculador = 
                SistemaDeAmortizacionFactory.obtenerCalculador(sistema);
        
        final double interesAnual = Double.parseDouble(args[1]);
        final double capital = Double.parseDouble(args[0]);
        
        List<Cuota> cuotasAPagar = 
                calculador.obtenerCuotas(capital, interesAnual);
        
        GeneradorDeTablaHTML genHTML = 
                new GeneradorDeTablaHTML("cuotasAPagar", cuotasAPagar);
        
        File path = new File(sistema + " - cuotas.html");
        try {
            FileUtils.write(path, genHTML.obtenerHTML(), Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
