package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultioperadorTestCase {

	private Multioperador calculador;
	
	/**
	 * Crea un escenario para el Multioperador
	 * con 5 enteros.
	 * @throws Exception
	 */
	
	@BeforeEach
	public void setUp() throws Exception{
		
		// Se crea el contador
		
		calculador = new Multioperador();
		
		// Se agregan los 5 numeros  enteros
		
		calculador.agregarNumero(1);
		calculador.agregarNumero(2);
		calculador.agregarNumero(3);
		calculador.agregarNumero(4);
		calculador.agregarNumero(5);
		
	}
	
	/**
	 * Se suman todos los numeros en el calculador
	 */
	
	@Test
	public void testSumaDeNumeros() {
		
		// Se obtiene la cantidad de pares
		int sumaDeNumeros = calculador.sumarNumeros();
		
		// Se chequea que la suma sea igual a la esperada
		assertEquals(sumaDeNumeros, 15);
		
	}
	
	@Test
	public void testRestaDeNumeros() {
		
		// Se obtiene la cantidad de pares
		int restaDeNumeros = calculador.restarNumeros();
		
		// Se chequea que la resta sea igual a la esperada
		assertEquals(restaDeNumeros, (-13));
		
	}
	
	@Test
	public void testMultiplicacionaDeNumeros() {
		
		// Se obtiene la cantidad de pares
		int restaDeNumeros = calculador.multiplicarNumeros();
		
		// Se chequea que la multiplicacion sea igual a la esperada
		assertEquals(restaDeNumeros, 120);
		
	}
	
}
