/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.representation;

import com.caidosdelcatre.domain.Prestamo;

/**
 *
 * @author gomez
 */
public interface PresentadorDePrestamo {

    public String obtenerRepresentacion(Prestamo prestamo);

    public String obtenerExtension();
}
