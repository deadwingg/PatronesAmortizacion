/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.util;

import com.caidosdelcatre.domain.Cuota;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gomez
 */
public class GeneradorDeTablaHTML {
    private String template;
    private List<Cuota> cuotas;

    public GeneradorDeTablaHTML(String template, List<Cuota> cuotas) {
        this.template = template;
        this.cuotas = cuotas;
    }

    public String obtenerHTML() {
        Mustache mustache = new DefaultMustacheFactory().compile(template + ".mustache");
        Writer stringWriter = new StringWriter();
        Map<String, Object> context = new HashMap<>();
        context.put("cuotas", cuotas);
        mustache.execute(stringWriter, context);
        return stringWriter.toString();
    }
    
}
