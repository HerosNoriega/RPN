package com.heros.calculadora;

public class NodoString {
    String data;
    NodoString link;

    public NodoString() {
    }

    public NodoString(String data) {
        this.data = data;
        link = null;
    }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public NodoString getLink() {
		return link;
	}

	public void setLink(NodoString link) {
		this.link = link;
	}
}
