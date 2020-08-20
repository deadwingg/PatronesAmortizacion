/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.util.conversor.factory;

import com.caidosdelcatre.util.conversor.ConversorATexto;
import com.caidosdelcatre.util.conversor.Conversores;
import com.caidosdelcatre.util.conversor.impl.ConversorATextoPlano;
import com.caidosdelcatre.util.conversor.impl.ConversorHTMLMustache;
import com.caidosdelcatre.util.conversor.impl.ConversorJsonGson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gomez
 */
public class ConversorFactory {

    private static final Map<Conversores, ConversorATexto> conversores;

    static {
        conversores = new HashMap<>();
        conversores.put(Conversores.PLAIN, new ConversorATextoPlano());
        conversores.put(Conversores.HTMLMUSTACHE, new ConversorHTMLMustache());
        conversores.put(Conversores.JSONGSON, new ConversorJsonGson());
    }

    public static ConversorATexto obtenerConversor(Conversores tipo) {
        return conversores.get(tipo);
    }
}
