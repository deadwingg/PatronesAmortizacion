/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caidosdelcatre.util.conversor;

/**
 *
 * @author gomez
 */
public enum Conversores {
    PLAIN("TextoPlano"), HTMLMUSTACHE("HTMLMustache"), JSONGSON("JsonGson");
    String tipo;

    private Conversores(String tipo) {
        this.tipo = tipo;
    }

    public String getName() {
        return tipo;
    }
}
