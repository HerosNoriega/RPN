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
			
			//nodoTemporal.setData(ecuacion + " Resultado: " + resultadoString);
			//nodoTemporal.setResultado(resultado);
			agregarALista(nodoTemporal);
		}
	}
	
	public static void agregarALista(Ecuacion ecuacion) {
		if (lista.isEmpty()) {
			lista.addFirst(ecuacion);
			counter++;
		} else {
			lista.add(ecuacion, counter);
			counter++;
		}
	}
	
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
	
	public static void escribirReporte(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		String contenido = " ";
		for(int i = 0; i < Calculadora.counter - 1; i++) {
			contenido = contenido + "\n" + "Ecuación: " + Calculadora.lista.get(i+1).data.getEcuacion() +
										" Resultado: " + Calculadora.lista.get(i+1).data.getResultado() ;
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

