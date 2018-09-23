package com.heros.calculadora;

public class Pila {
	NodoDouble cima;
	int tamanio;


	public Pila(){
		cima = null;
	}

	public void push(NodoDouble nodo){
		nodo.link = cima;
		cima = nodo;
		tamanio++;
	}


	public NodoDouble pop(){
		if(tamanio == 0){
			System.out.println("Stack Empty");
			return null;
    } else {
    	NodoDouble nodo = cima;
    	cima = cima.link;
    	tamanio--;
    	return nodo;
    }
  }

  public void print(){
	 NodoDouble auxiliar = cima;
    for(int i = 0; i< tamanio; i++){
      System.out.println(auxiliar.data);
      auxiliar = auxiliar.link;
    }
    System.out.println();
  }
}
