package com.heros.calculadora;

public class NodoDouble {
    Double data;
    NodoDouble link;

    public NodoDouble() {
    }

    public NodoDouble(Double data) {
        this.data = data;
        link = null;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public NodoDouble getLink() {
        return link;
    }

    public void setLink(NodoDouble next) {
        this.link = next;
    }
}
