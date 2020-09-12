package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Counter {

	private ArrayList<Integer> numeros;
	
	public Counter() {
		numeros = new ArrayList<Integer>();
	}
	
	public void agregarNumero(int numero) {
		numeros.add(numero);
	}
	
	public int cantidadDePares() {
		
		int nrosPares = 0;
		
		for (Integer numero : numeros) {
			
			if(numero % 2 == 0) {
				nrosPares++;
			}
			
		}
		
		return nrosPares;
		
	}
	
	public int cantidadDeImpares() {
		
		int nrosImpares = 0;
		
		for (Integer numero : numeros) {
			
			if(numero % 2 != 0) {
				nrosImpares++;
			}
			
		}
		
		return nrosImpares;
		
	}
	
	public int cantidadDeMultiplos(int unNumero) {
		
		int cantidadDeMultiplos = 0;
		
		for (Integer numero : numeros) {
			
			if(esMultiplo(unNumero, numero)) {
				cantidadDeMultiplos++;
			}
			
		}
		
		return cantidadDeMultiplos;
		
	}
	
	private boolean esMultiplo(int unNumero, int otroNumero) {
		
		return (unNumero % otroNumero == 0);
		
	}
	
}
