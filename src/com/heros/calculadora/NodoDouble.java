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
    
    /**
     * getData() retorna el dato en el nodo 
     * @return retorna data de tipo Double que es el dato de el nodo actual
     */
    public Double getData() {
        return data;
    }
    
    /**
     * setData() agrega el dato al Nodo 
     * @param data resive el dato de tipo Double para agregarlo a NodoDouble
     */
    public void setData(Double data) {
        this.data = data;
    }

    /**
     * getLink() obtiene el siguiente NodoDouble de el actual posicionado
     * @return retorna el nodo siguiente un tipo de dato NodoDouble
     */
    public NodoDouble getLink() {
        return link;
    }

    /**
     * setLink() agrega un tipo de dato NodoDouble como el siguiente del actual posicionado 
     * @param next recive un dato de tipo NodoDouble
     */
    public void setLink(NodoDouble next) {
        this.link = next;
    }
}
