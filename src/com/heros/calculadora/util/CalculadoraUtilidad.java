package com.heros.calculadora.util;

import java.util.Scanner;

public class CalculadoraUtilidad {
	
	public static boolean operacionValida(String operacion) {
		boolean operacionValidada = false;
		
		
		
		return operacionValidada;
	}
	
	public static int validarRespuestaMenu(int min, int max) {
        //Reads user response
        Scanner input = new Scanner(System.in);

        //Validates response if int
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Prueba de nuevo una opcion valida");
        }

        int response = input.nextInt();

        //Validate range of response
        while (response < min || response > max) {
            System.out.println("Prueba de nuevo una opcion valida");

            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Prueba de nuevo una opcion valida");
            }
            response = input.nextInt();
        }
        System.out.println("As seleccionado: " + response + "\n");
        return response;
    }
}
