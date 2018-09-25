package com.heros.calculadora.util;

public class Ecuacion {
	
	private String ecuacion;
	private Double resultado;
	
	public Ecuacion() {
		
	}
	
	public Ecuacion(String ecuacion, Double resultado) {
		super();
		this.ecuacion = ecuacion;
		this.resultado = resultado;
	}
	
	/**
	 * Obtiene la ecuacion 
	 * @return regresa tipo de dato String con la ecuacion 
	 */
	public String getEcuacion() {
		return ecuacion;
	}
	
	/**
	 * agrega la ecuacion 
	 * @param ecuacion el dato a ingresar de tipo String con la informacion de la ecuacion 
	 */
	public void setEcuacion(String ecuacion) {
		this.ecuacion = ecuacion;
	}
	
	/**
	 * obtiene el resultado obtenido en la ecuacion 
	 * @return tipo de dato Double con el resultado de la ecuacion 
	 */
	public Double getResultado() {
		return resultado;
	}
	
	/**
	 * agrega el resultado a la clase Ecuacion 
	 * @param resultado devuelve el resultado en tipo de dato Double
	 */
	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	
	
}
