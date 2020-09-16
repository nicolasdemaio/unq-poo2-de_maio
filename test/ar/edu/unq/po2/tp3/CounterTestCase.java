package ar.edu.unq.po2.tp3;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterTestCase {

	private Counter counter;
	
	/**
	 * Crea un escenario de test
	 * Un contador con 5 numeros agregados (enteros).
	 * 
	 * @throws Exception
	 */
	
	@BeforeEach
	public void setUp() throws Exception{
		
		// Se crea el contador
		
		counter = new Counter();
		
		// Se agregan los 5 numeros  enteros
		
		counter.agregarNumero(1);
		counter.agregarNumero(2);
		counter.agregarNumero(3);
		counter.agregarNumero(4);
		counter.agregarNumero(5);
		
	}
	
	/**
	 * Se consulta al contador la cantidad de pares
	 */
	
	@Test
	public void testCantidadDePares() {
		
		// Se obtiene la cantidad de pares
		int cantidadPares = counter.cantidadDePares();
		
		// Se chequea que la cantidad de pares sea igual a la esperada
		assertEquals(cantidadPares, 2);
		
	}
	
	@Test
	public void testCantidadDeImpares() {
		
		// Se obtiene la cantidad de impares
		int cantidadDeImpares = counter.cantidadDeImpares();
		
		// Se chequea que la cantidad de impares es igual a la esperada
		assertEquals(cantidadDeImpares, 3);
		
	}
	
	@Test
	public void testCantidadDeMultiplosDelNumero5() {
		
		// Se obtiene la cantidad de multiplos del 5
		int cantidadMultiplosDe5 = counter.cantidadDeMultiplos(5);
		
		// Se chequea que la cantidad de multiplos sea igual a la esperada
		assertEquals(cantidadMultiplosDe5, 2);
		
	}
	
}