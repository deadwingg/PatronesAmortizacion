/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.fileoutput;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.util.conversor.ConversorATexto;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author gomez
 */
public class GuardadorDePrestamos {

    private ConversorATexto conversor;

    public GuardadorDePrestamos(ConversorATexto conversor) {
        this.conversor = conversor;
    }

    public void setConversor(ConversorATexto conversor) {
        this.conversor = conversor;
    }

    public void guardar(String nombreDeArchivo, Prestamo prestamo) {
        File path = new File(nombreDeArchivo + conversor.obtenerExtension());
        try {
            FileUtils.write(path,
                    conversor.obtenerRepresentacion(prestamo),
                    Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(GuardadorDePrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
