package ar.edu.unq.po2.tp5.ultimaConsigna;

public class Mascota implements SerVivo {

	private String nombre, raza;
	
	public Mascota(String nombre, String raza) {
		this.nombre = nombre;
		this.raza = raza;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getRaza() {
		return raza;
	}

}
