/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.util;

import com.caidosdelcatre.service.Credito;
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
public class GeneradorDeTablaHTML {
    private String template;
    private Credito credito;

    public GeneradorDeTablaHTML(String template, Credito credito) {
        this.template = template;
        this.credito = credito;
    }

    public String obtenerHTML() {
        Mustache mustache = new DefaultMustacheFactory().compile(template + ".mustache");
        Writer stringWriter = new StringWriter();
        Map<String, Object> context = new HashMap<>();
        context.put("cuotas", credito.obtenerCuotas());
        context.put("sistema", credito.obtenerSistemaDeAmortizacion());
        context.put("tasa", credito.obtenerInteresAnual());
        context.put("capital", credito.obtenerCapital());
        mustache.execute(stringWriter, context);
        return stringWriter.toString();
    }
    
}
