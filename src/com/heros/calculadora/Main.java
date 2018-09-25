package com.heros.calculadora;

import com.heros.calculadora.util.CalculadoraUtilidad;


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
            System.out.println("2. Ordernar Ascendente");
            System.out.println("3. Ordenar Descendente");
            System.out.println("4. Imprimir Lista");
            System.out.println("0. Salir");
            
            int seleccionDeUsuario = CalculadoraUtilidad.validarRespuestaMenu(0, 5) ;
            
            switch (seleccionDeUsuario) {
			case 0:
				Calculadora.escribirReporte("Historial.txt");
				System.out.println("Reporte Generado");
				salir = 0;
				break;
			case 1:
				Calculadora.obtenerEcuacion();
				showMenu();
				break;
			case 2:
				Calculadora.lista.ordenarAscendente();
				showMenu();
				break;
			case 3:
				Calculadora.lista.ordenarDescendente();
				showMenu();
				break;
			case 4:
				Calculadora.lista.print();
				showMenu();
				break;
			default:
				System.out.println("\n Select an option!...\n");
                salir = 1;
				break;
			}
		} while(salir != 0);
	}
}
