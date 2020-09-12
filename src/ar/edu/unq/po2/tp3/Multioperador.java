package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Multioperador {

	private ArrayList<Integer> numeros;
	
	public Multioperador() {
		numeros = new ArrayList<>();
	}
	
	public void agregarNumero(int unNumero) {
		numeros.add(unNumero);
	}
	
	public int sumarNumeros() {
		
		int resultado = 0;
		
		for (Integer numero : numeros) {
			resultado += numero;
		}
		
		return resultado;
	}
	
	public int restarNumeros() {
			
		/*int resultado = 0;
			
		for (Integer numero : numeros) {
			resultado -= numero;
		}
			
		return resultado;*/
		
		int resultado = numeros.get(0);
		
		for (int i = 1; i < numeros.size(); i++) {
			resultado -= numeros.get(i);
		}
		
		return resultado;
	}
	
	public int multiplicarNumeros() {
		
		int resultado = numeros.get(0);
		
		int i = 1;
		
		while (i < numeros.size()) {
			resultado *= numeros.get(i);
			i++;
		}
		
		return resultado;
	}
	
}
