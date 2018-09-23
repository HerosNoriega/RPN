package com.heros.calculadora;

public class Calculadora {
	
	NodoString nodoString = new NodoString();
	NodoDouble nodoDouble = new NodoDouble();
	public static Lista lista = new Lista();
	static int counter = 1;
	
	public static NodoString calcularOperacion(String[] tokens){
		
		boolean error = false;
		Pila pila = new Pila();
		String ecuacion = "";
		NodoString nodoTemporal = new NodoString();
		String resultadoString = " ";
		
		for(String token : tokens){			
			
			Double tokenNum = null;
			
			try{
				tokenNum = Double.parseDouble(token);
			}catch(NumberFormatException e){}
			
			if(tokenNum != null){				
				
				pila.push(new NodoDouble(Double.parseDouble(token+"")));
				
			}else if(token.equals("TIMES")){
				
				double operando2 = pila.pop().data;
				double operando1 = pila.pop().data;
				pila.push(new NodoDouble(operando1 * operando2));
				
			}else if(token.equals("DIV")){
				
				double operando2 = pila.pop().data;
				double operando1 = pila.pop().data;
				pila.push(new NodoDouble(operando1 / operando2));
				
			}else if(token.equals("LESS")){
				
				double operando2 = pila.pop().data;
				double operando1 = pila.pop().data;
				pila.push(new NodoDouble(operando1 - operando2));
				
			}else if(token.equals("PLUS")){
				
				double operando2 = pila.pop().data;
				double operando1 = pila.pop().data;
				pila.push(new NodoDouble(operando1 + operando2));
				
			}else{
				
				error = true;
				if(error) {
					System.out.println("Error ecuacion no valida");
				}
			}
			ecuacion = ecuacion + " " + token;
		}
		
		Double resultado = pila.pop().data;
		
		if(tokens.length < 3) {
			error = true;
		} else {
			System.out.println("Solucion: " + resultado);
			resultadoString = String.valueOf(resultado);
			
		}
		
		nodoTemporal.setData(ecuacion + " " + resultadoString);
		agregarALista(nodoTemporal);
		return nodoTemporal;
	}
	
	public static void agregarALista(NodoString nodo) {
		if (lista.isEmpty()) {
			lista.addFirst(nodo);
			counter++;
		} else {
			lista.add(nodo, counter);
			counter++;
		}
	}
}
