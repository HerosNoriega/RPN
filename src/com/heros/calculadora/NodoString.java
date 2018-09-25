package com.heros.calculadora;

import com.heros.calculadora.util.Ecuacion;

public class NodoString {
    Ecuacion data;
    NodoString link;

	public NodoString() {
    }

    public NodoString(Ecuacion data) {
        this.data = data;
        link = null;
    }
    
    /**
     * getData() es una funcion para obtener el dato ingresado en un nodo 
     * @return retorna el dato de tipo Ecuacion en el nodo actual 
     */
	public Ecuacion getData() {
		return data;
	}

	/**
	 * setData() ingresa el tipo de dato Ecuacion al nodo 
	 * @param data es el que recive el tipo de dato a ingresar Ecuacion
	 */
	public void setData(Ecuacion data) {
		this.data = data;
	}

	/**
	 * getLink() obtiene el siguiente nodo que le sigue al actual 
	 * @return retorna el nodo siguiente 
	 */
	public NodoString getLink() {
		return link;
	}
	
	/**
	 * setLink() es una funcion para ingresar el nodo siguiente 
	 * @param link obtiene como dato tipo NodoString el cual sera dado como el siguiente nodo 
	 */
	public void setLink(NodoString link) {
		this.link = link;
	}
}
