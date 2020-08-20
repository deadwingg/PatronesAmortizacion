/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.service;

import com.caidosdelcatre.domain.Cuota;
import java.util.List;

/**
 *
 * @author gomez
 */
public interface CalculadorDeFinanciacion {
    List<Cuota> obtenerCuotas(double capital, double interes);
}
