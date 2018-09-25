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

	public Ecuacion getData() {
		return data;
	}

	public void setData(Ecuacion data) {
		this.data = data;
	}

	public NodoString getLink() {
		return link;
	}

	public void setLink(NodoString link) {
		this.link = link;
	}
}
