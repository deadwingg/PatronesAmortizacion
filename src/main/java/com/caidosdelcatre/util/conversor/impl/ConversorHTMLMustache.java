/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.util.conversor.impl;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.util.conversor.ConversorATexto;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gomez
 */
public class ConversorHTMLMustache implements ConversorATexto {

    private Mustache mustache;

    public ConversorHTMLMustache() {
        this.mustache = new DefaultMustacheFactory().compile("prestamos.mustache");
    }

    @Override
    public String obtenerRepresentacion(Prestamo prestamo) {
        Writer stringWriter = new StringWriter();
        Map<String, Object> context = new HashMap<>();
        context.put("cuotas", prestamo.getCuotas());
        context.put("sistema", prestamo.getNombreDeSistema());
        context.put("tasa", prestamo.getInteresAnual());
        context.put("capital", prestamo.getCapital());
        mustache.execute(stringWriter, context);
        return stringWriter.toString();
    }

    @Override
    public String obtenerExtension() {
        return ".html";
    }
}
