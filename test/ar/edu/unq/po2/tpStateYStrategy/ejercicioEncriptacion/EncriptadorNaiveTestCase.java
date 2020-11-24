package ar.edu.unq.po2.tpStateYStrategy.ejercicioEncriptacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncriptadorNaiveTestCase {

	
	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testConstructor() {
		EstrategiaDeEncriptacion estrategia = new EncriptacionDeVocales();
		EncriptadorNaive encriptador = new EncriptadorNaive (estrategia);
		
		assertEquals(estrategia, encriptador.getEstrategia());
	}
	
	@Test
	void testCambioDeEstrategia() {
		EstrategiaDeEncriptacion estrategia = new EncriptacionDeVocales();
		EncriptadorNaive encriptador = new EncriptadorNaive (estrategia);
		EstrategiaDeEncriptacion estrategiaNueva = new EncriptacionNumerica();
		
		encriptador.setEstrategia(estrategiaNueva);
		
		assertEquals (estrategiaNueva, encriptador.getEstrategia());
		
	}
	
	@Test
	void testEncriptarCuandoLaEstrategiaEsLaEncriptacionDeVocales() {
		EstrategiaDeEncriptacion estrategia = new EncriptacionDeVocales();
		EncriptadorNaive encriptador = new EncriptadorNaive (estrategia);
		
		String textoEncriptado1 = encriptador.encriptar("aeioubcd");
		String textoEsperado1 = "eiouabcd";
		
		String textoEncriptado2 = encriptador.encriptar("bnm");
		String textoEsperado2 = "bnm";
		
		assertEquals(textoEsperado1, textoEncriptado1);
		assertEquals(textoEsperado2, textoEncriptado2);
	}
	
	@Test
	void testEncriptarCuandoLaEstrategiaEsLaEncriptacionNumerica() {
		EstrategiaDeEncriptacion estrategia = new EncriptacionNumerica();
		EncriptadorNaive encriptador = new EncriptadorNaive (estrategia);
		
		String textoEncriptado1 = encriptador.encriptar("ab c");
		String textoEsperado1 = "1,2,0,3";
		
		String textoEncriptado2 = encriptador.encriptar("diego");
		String textoEsperado2 = "4,9,5,7,15";
		
		assertEquals(textoEsperado1, textoEncriptado1);
		assertEquals(textoEsperado2, textoEncriptado2);
	}
	
	@Test
	void testDesencriptarCuandoLaEstrategiaEsLaEncriptacionNumerica() {
		EstrategiaDeEncriptacion estrategia = new EncriptacionNumerica();
		EncriptadorNaive encriptador = new EncriptadorNaive (estrategia);
		
		String textoDesencriptado1 = encriptador.desencriptar("1,2,3");
		String textoEsperado1 = "abc";
		
		String textoDesencriptado2 = encriptador.desencriptar("4,9,5,7,15");
		String textoEsperado2 = "diego";
		
		assertEquals(textoEsperado1, textoDesencriptado1);
		assertEquals(textoEsperado2, textoDesencriptado2);
	}
	
	@Test
	void testDesencriptarCuandoLaEstrategiaEsLaEncriptacionDeVocales() {
		EstrategiaDeEncriptacion estrategia = new EncriptacionDeVocales();
		EncriptadorNaive encriptador = new EncriptadorNaive (estrategia);
		
		String textoDesencriptado1 = encriptador.desencriptar("eiouabcd");
		String textoEsperado1 = "aeioubcd";
		
		String textoDesencriptado2 = encriptador.desencriptar("bnm");
		String textoEsperado2 = "bnm";
		
		assertEquals(textoEsperado1, textoDesencriptado1);
		assertEquals(textoEsperado2, textoDesencriptado2);
	}
	

}
