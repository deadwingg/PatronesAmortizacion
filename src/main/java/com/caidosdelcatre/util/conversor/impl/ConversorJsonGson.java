/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.util.conversor.impl;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.util.conversor.ConversorATexto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author gomez
 */
public class ConversorJsonGson implements ConversorATexto {

    private Gson gson;

    public ConversorJsonGson() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String obtenerRepresentacion(Prestamo prestamo) {
        return gson.toJson(prestamo);
    }

    public String obtenerExtension() {
        return ".json";
    }

}
