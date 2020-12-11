package ar.edu.unq.po2.tpRefactoring.automotor;


import java.time.LocalDate;

public class RegistroAutomotor {

	public Boolean debeRealizarVtv(Vehiculo vehiculo, LocalDate fecha) 
	{
		return (vehiculo.debeRealizarVtv(fecha));
	}
}

/* Bad Smells: 
 * Feature Envy: "A method accesses the data of another object more than its own data." - RegistroAutomor consulta todo al vehiculo para #debeRealizarVtv.
 * Vehiculo era un Data Class (clase que almacena datos y solo tiene getters y setters)
 * 
 * Refactors: 
 * - Se le delego la funcionalidad al vehiculo, se le pregunta a este si debe realizar VTV.
 * Esto es dado que el vehiculo sabra verificando sus variables de instancias para las condiciones necesarias para saber si debe realizar vtv.
 * - Se realizo extract method en la clase Vehiculo para hacer mas coherente la implementacion.
 * 
 * Se soluciono el Data Class de Vehiculo pero se originó el Inline Class el RegistroAutomotor.
 * El Inline Class es debido a que no tiene otra responsabilidad que preguntarle a un vehiculo (que mismo el vehiculo puede saber) si debe realizar vtv.
 * Una solucion seria borrarla y que responda el vehiculo, pero no pasarian los tests.
 */
 