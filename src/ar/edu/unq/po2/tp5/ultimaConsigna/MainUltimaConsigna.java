package ar.edu.unq.po2.tp5.ultimaConsigna;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MainUltimaConsigna {

	public static void main(String[] args) {
		
		LocalDate fechaNac1 = LocalDate.of(1999, 1, 7);
		
		Mascota m1 = new Mascota("Kira", "Felino");
		Mascota m2 = new Mascota("Tomi", "Perro");
		
		Persona p1 = new Persona("Nicolas", fechaNac1);
		
		// El polimorfismo se asegura mediante Interface si son dos clases que no tiene lo necesario para pertenecer a una jerarquia en común.
		// Para poder agregar a la coleccion, tanto Persona como Mascota deben pertenecer a una interface/clase.
		
		ArrayList<SerVivo> seresVivos = new ArrayList<>();
		
		seresVivos.add(m1);
		seresVivos.add(m2);
		seresVivos.add(p1);
		
		HashSet<String> nombresSeres = new HashSet<>();
		
		for (SerVivo servivo : seresVivos) {
			nombresSeres.add(servivo.getNombre());
		}
		
		System.out.println(nombresSeres);	
		
	}
	
}
