package com.heros.calculadora;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.heros.calculadora.util.CalculadoraUtilidad;
import com.heros.makereport.Report;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showMenu();

	}
	
	public static void showMenu() {
		int salir = 0;
		
		
		do {
			System.out.println("\n CALCULADORA RPN(Reverse Polish Notation)");
            System.out.println(" ");
            System.out.println("Selecciona tu opcion: ");
            System.out.println("1. Calcular");
            System.out.println("2. Reporte");
            System.out.println("3. Reporte Hoy");
            System.out.println("0. Salir");
            
            int seleccionDeUsuario = CalculadoraUtilidad.validarRespuestaMenu(0, 3) ;
            
            switch (seleccionDeUsuario) {
			case 0:
				salir = 0;
				break;
			case 1:
				obtenerEcuacion();
				showMenu();
				break;
			case 2:
				makeReport();
				break;
			case 3:
				break;
			default:
				System.out.println("\n Select an option!...\n");
                salir = 1;
				break;
			}
		} while(salir != 0);
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
	
	public static void obtenerEcuacion() {
		Scanner scan = new Scanner(System.in);
		boolean ecuacionValida = false;
		
		do {
			System.out.println("Ingresa una ecuacion: ");
			String ecuacion = scan.nextLine();
			
			System.out.println("Esta es la ecuacion: " + "\n" + ecuacion);
			
			String[] tokens = getTokens(ecuacion);
			Calculadora.calcularOperacion(tokens);
			

		} while (ecuacionValida != false);
	}
	
	public static void makeReport() {
		Report report = new Report();
		String contentReport = " ";
		
		if(report.getNameFile() != null) {
			
			for(int i = 0; i < Calculadora.counter - 1; i++) {
				contentReport = contentReport + "\n" + Calculadora.lista.get(i+1).data + " " ;
			}
			
		} else {
			report.setNameFile("Historial");
			report.setTitle("Historial");
			report.setExtension("txt");
							
			for(int i = 0; i < Calculadora.counter - 1; i++) {
				contentReport = contentReport + "\n" + Calculadora.lista.get(i+1).data + " " ;
			}
			
			report.setContent(contentReport);
			report.makeReport();
			System.out.println(":: Report Generated!");
		}
		
		
	}
}
