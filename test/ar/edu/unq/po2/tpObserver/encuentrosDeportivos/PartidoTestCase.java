package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PartidoTestCase {
	private Partido partido;
	private String resultado;
	private List <String> contrincantes;
	private String deporte;

	@BeforeEach
	void setUp() throws Exception {
		resultado = "3 - 2";
		contrincantes = Arrays.asList("Argentina", "Suecia");
		deporte = "Futbol";
		
		partido = new Partido (resultado, contrincantes, deporte);
	}

	@Test
	void testConstructor() {
		assertEquals(resultado, partido.getResultado());
		assertEquals(contrincantes, partido.getContrincantes());
		assertEquals(deporte, partido.getDeporte());
	}
	
	@Test
	void testDatosDelPartido() {
		ArrayList<String> datosEsperados = new ArrayList<String>();
		datosEsperados.add(deporte);
		datosEsperados.addAll(contrincantes);
		
		assertEquals(datosEsperados, partido.datosDelPartido());
		
	}
	

}
