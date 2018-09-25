package com.heros.calculadora;

public class Pila {
	NodoDouble cima;
	int tamanio;

	

	public Pila(){
		cima = null;
	}

	/**
	 * push es una funcion de la clase pila para ingresar un dato a la pila 
	 * @param nodo NodoDouble de tipo Double es ingresado a la pila 
	 */
	public void push(NodoDouble nodo){
		nodo.link = cima;
		cima = nodo;
		tamanio++;
	}

	/**
	 * pop es un metodo para obtener el dato mas reciente ingresado
	 * @return retorna NodoDouble de tipo Double 
	 */
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

	/**
	 * print es una funcion para imprimir los datos en una pila 
	 */
  public void print(){
	 NodoDouble auxiliar = cima;
    for(int i = 0; i< tamanio; i++){
      System.out.println(auxiliar.data);
      auxiliar = auxiliar.link;
    }
    System.out.println();
  }
}
