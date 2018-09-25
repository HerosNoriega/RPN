package com.heros.calculadora.util;

import java.util.Scanner;

public class CalculadoraUtilidad {
	
	/**
	 * validarRespuestaMenu Valida la respuesta del usuario en un rango determinado 
	 * por los parametros min y max 
	 * @param min valida el minimo valor para aceptar como respuesta de seleccion
	 * @param max valida el maximo valor para aceptar como respuesta de seleccion
	 * @return retorna la respuesta del usuario si esta entre el rango determinado 
	 * 			por los parametros min y max de lo cotrario pide ingresar de nuevo
	 * 			una respuesta a ser validada.
	 */
	
	public static int validarRespuestaMenu(int min, int max) {

        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Prueba de nuevo una opcion valida");
        }

        int response = input.nextInt();

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
