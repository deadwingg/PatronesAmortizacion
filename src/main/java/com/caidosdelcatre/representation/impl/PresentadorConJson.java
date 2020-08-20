/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.representation.impl;

import com.caidosdelcatre.domain.Prestamo;
import com.caidosdelcatre.representation.PresentadorDePrestamo;
import com.google.gson.Gson;

/**
 *
 * @author gomez
 */
public class PresentadorConJson implements PresentadorDePrestamo{

    private Gson gson;
    private Prestamo prestamo;

    public PresentadorConJson(Gson gson, Prestamo prestamo) {
        this.gson = gson;
        this.prestamo = prestamo;
    }
    
    @Override
    public String obtenerRepresentacion() {
        return gson.toJson(prestamo);
    }

    @Override
    public String obtenerExtension() {
        return ".json";
    }
    
}
