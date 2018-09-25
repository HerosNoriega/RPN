package com.heros.calculadora;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.heros.calculadora.util.Ecuacion;

public class Calculadora {
	
	NodoString nodoString = new NodoString();
	NodoDouble nodoDouble = new NodoDouble();
	public static Lista lista = new Lista();
	static int counter = 1;
	
	/**
	 * calcularOperacion() calcula la operacion de los datos ingresados en el array 
	 * puede manejar operandos y operadores de tipo string por ejemplo: SUM, LESS, DIV, TIMES.
	 * @param tokens obtiene un array de tipo String
	 */
	public static void calcularOperacion(String[] tokens){
		
		boolean error = false;
		Pila pila = new Pila();
		String ecuacion = "";
		Ecuacion nodoTemporal = new Ecuacion();
		String resultadoString = " ";
		
		for(String token : tokens){			
			
			Double tokenNum = null;
			
			try{
				tokenNum = Double.parseDouble(token);
			}catch(NumberFormatException e){}
			
			if(tokenNum != null){				
				
				pila.push(new NodoDouble(Double.parseDouble(token+"")));
				
			}else if(token.equals("TIMES") || token.equals("times")){
				
				double operando2 = pila.pop().data;
				double operando1 = pila.pop().data;
				pila.push(new NodoDouble(operando1 * operando2));
				
			}else if(token.equals("DIV") || token.equals("div")){
				
				double operando2 = pila.pop().data;
				double operando1 = pila.pop().data;
				pila.push(new NodoDouble(operando1 / operando2));
				
			}else if(token.equals("LESS") || token.equals("less")){
				
				double operando2 = pila.pop().data;
				double operando1 = pila.pop().data;
				pila.push(new NodoDouble(operando1 - operando2));
				
			}else if(token.equals("PLUS") || token.equals("plus")){
				
				double operando2 = pila.pop().data;
				double operando1 = pila.pop().data;
				pila.push(new NodoDouble(operando1 + operando2));
				
			}else{
				
				error = true;
			}
			ecuacion = ecuacion + " " + token;
		}
		
		Double resultado = pila.pop().data;
		
		if(tokens.length < 3 || error == true) {
			error = true;
			System.out.println("Error en la ecuacion!");
		} else {
			System.out.println("Solucion: " + resultado);
			resultadoString = String.valueOf(resultado);
			nodoTemporal.setEcuacion(ecuacion);
			nodoTemporal.setResultado(resultado);
			
			agregarALista(nodoTemporal);
		}
	}
	
	/**
	 * agregarALista() agrega la ecuacion a la lista 
	 * @param ecuacion la ecuacion a obtener para ingresar a la lista 
	 */
	public static void agregarALista(Ecuacion ecuacion) {
		if (lista.estaVacio()) {
			lista.agregarPrimero(ecuacion);
			counter++;
		} else {
			lista.agregar(ecuacion, counter);
			counter++;
		}
	}
	
	/**
	 * obtenerEcuacion() le pedira al usuario ingresar la ecuacion para ser evualada
	 * y resolvida 
	 */
	public static void obtenerEcuacion() {
		Scanner scan = new Scanner(System.in);
		boolean ecuacionValida = false;
		
		do {
			System.out.println("Ingresa una ecuacion: ");
			String ecuacion = scan.nextLine();
			
			System.out.println("Esta es la ecuacion: " + "\n" + ecuacion);
			
			String[] tokens = getTokens(ecuacion);
			if(tokens.length > 2 && balanceEcuacion(tokens)) {
				Calculadora.calcularOperacion(tokens);
			} else {
				System.out.println("No es valida la ecuacion");
				ecuacionValida = false;
			}
			

		} while (ecuacionValida != false);
	}
	
	/**
	 * getTokens obtiene la ecuacion en tipo String y es ingresada el un array de tipo String
	 * @param ecuacion donde ingresaremos la ecuacion de tipo String 
	 * @return retornara un array de String con los tokens esperados y separados por un espacio
	 * siempre siendo analizados si son validos
	 */
	public static String[] getTokens(String ecuacion) {
		
		StringTokenizer tokenizer = new StringTokenizer(ecuacion, " ");
		int size = tokenizer.countTokens();
		String[] tokens = new String[size];
		int counter = 0;
		
		while(tokenizer.hasMoreElements()) {
			
			tokens[counter] = tokenizer.nextToken();
			counter++;
		}		
		return tokens;
	}
	
	/**
	 * escribirReporte() una funcion para escribir archivos en este caso 
	 * un solo archivo y los datos persisten despues de crearse el archivo 
	 * con nombre.
	 * @param nombreArchivo resivira el nombre a darsele al archivo
	 */
	public static void escribirReporte(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		String contenido = " ";
		for(int i = 0; i < Calculadora.counter - 1; i++) {
			contenido = contenido + "\n" + "Ecuación: " + Calculadora.lista.get(i+1).getEcuacion() +
										" Resultado: " + Calculadora.lista.get(i+1).getResultado() ;
		}
		
		try {
			
			if(archivo.exists()) {
				FileWriter w = new FileWriter(archivo, true);
				w.write(contenido);
				w.close();
				
			} else {

				FileWriter w = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				wr.write(contenido);
				wr.close();
				bw.close();
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Archivo no existe!");
		}
	}
	
	/**
	 * balanceEcuacion() obtiene un array de tokens a analizar si existe un balance en la ecuacion
	 * @param tokens tipo Array de strings que seria analizo para verificar el balance
	 * @return retorna variable balance de tipo boolean para confirmar si es balanceado o no.
	 */
	public static boolean balanceEcuacion(String[] tokens) {
		boolean balance;
		
		if(tokens.length % 2 == 0) {
			balance = false;
		} else {
			balance = true;
		}
		
		return balance; 
	}
	
	
}

