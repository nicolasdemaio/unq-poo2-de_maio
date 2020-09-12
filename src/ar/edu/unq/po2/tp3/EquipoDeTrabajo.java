package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.util.ArrayList;

public class EquipoDeTrabajo {

	private String nombre;
	private ArrayList<Persona> integrantes;
	
	public EquipoDeTrabajo(String nombre) {
		integrantes = new ArrayList<>();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Persona> getIntegrantes(){
		return integrantes;
	}
	
	public void agregarIntegrantes(Persona persona) {
		integrantes.add(persona);
	}
	
	public int promedioEdad() {
		
		int cantIntegrantes = integrantes.size();
		
		int sumaEdades = 0;
		
		for (Persona persona : integrantes) {
			sumaEdades += persona.getEdad();
		}
		
		return (sumaEdades/cantIntegrantes);
		
	}
	
	public static void main(String[] args) {
		
		LocalDate fp1 = LocalDate.of(2018, 10, 30);
		LocalDate fp2 = LocalDate.of(2016, 10, 30);
		LocalDate fp3 = LocalDate.of(2014, 10, 30);
		
		Persona p1 = new Persona("Nico", "Nico", fp1);
		Persona p2 = new Persona("Nico", "Nico", fp2);
		Persona p3 = new Persona("Nico", "Nico", fp3);
		
		EquipoDeTrabajo equipo = new EquipoDeTrabajo("arco");
		
		equipo.agregarIntegrantes(p1);
		equipo.agregarIntegrantes(p2);
		equipo.agregarIntegrantes(p3);
		
		System.out.println(equipo.promedioEdad());
		
	}
	
}
