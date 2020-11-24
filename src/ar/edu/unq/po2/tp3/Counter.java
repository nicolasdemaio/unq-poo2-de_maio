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
	
	public int cantidadDePares() 
	{
		Integer cantNrosPares = (int) this.numeros.stream().map(numero -> numero % 2 == 0).count();
		
		return cantNrosPares;
	}
	
	public int cantidadDeImpares() {
		
		Integer cantNrosPares = (int) this.numeros.stream().map(numero -> numero % 2 != 0).count();
		
		return cantNrosPares;
	}
	
	public int cantidadDeMultiplos(int unNumero) {
		
		Integer cantMultiplos = (int) this.numeros.stream().map(numero -> esMultiplo(unNumero, numero)).count();
		
		return cantMultiplos;
	}
	
	private boolean esMultiplo(int unNumero, int otroNumero) {
		
		return (unNumero % otroNumero == 0);
	}
}
