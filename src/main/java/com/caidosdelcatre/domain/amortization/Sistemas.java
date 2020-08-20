/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.domain.amortization;

/**
 *
 * @author gomez
 */
public enum Sistemas {
    AMERICANO("Americano"), ALEMAN("Aleman"), FRANCES("Frances");
    String tipo;

    private Sistemas(String tipo) {
        this.tipo = tipo;
    }

    public String getName() {
        return tipo;
    }
}
