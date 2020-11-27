package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class GestorDePartidosTestCase {
	GestorDePartidos gestor;

	@BeforeEach
	void setUp() throws Exception {
		gestor = new GestorDePartidos();
	}

	@Test
	void testConstructor() {
		assertTrue(gestor.getPartidos().isEmpty());
		assertTrue(gestor.getAspectos().isEmpty());
	}
	
	@Test
	void testAgregarObserver() {
		IObserver observer = mock(IObserver.class);
		Set<String> intereses = new HashSet<String>();
		intereses.add("Football");
		intereses.add("RicardoFort");
		
		gestor.agregarObserver(observer, intereses);
		
		assertTrue(gestor.suscriptoresDelAspecto("Football").contains(observer));
		assertTrue(gestor.suscriptoresDelAspecto("RicardoFort").contains(observer));
		
	}
	
	@Test
	void testRecibirPartido() {
		//SETUP
		IObserver observerConIntereses = mock(IObserver.class);
		IObserver observerSinIntereses = mock(IObserver.class);
		Set<String> interesesQueImportan = new HashSet<String>();
		interesesQueImportan.add("Football");
		interesesQueImportan.add("RicardoFort");
		Set<String> interesesQueNoImportan = new HashSet<String>();
		interesesQueImportan.add("Brasil");
		interesesQueImportan.add("Alemania");
		Partido partido = mock(Partido.class);
		ArrayList<String> interesesQueImportanL = new ArrayList <String>();
		interesesQueImportanL.add("Football");
		interesesQueImportanL.add("RicardoFort");
		
		when(partido.datosDelPartido()).thenReturn(interesesQueImportanL);
		
		gestor.agregarObserver(observerConIntereses, interesesQueImportan);
		gestor.agregarObserver(observerSinIntereses, interesesQueNoImportan);
		
		//Excercise 
		
		gestor.recibirPartido(partido);
		
		//Verify
		
		verify(observerConIntereses,times(2)).update(partido);
		verify(observerSinIntereses,never()).update(partido);
		assertTrue(gestor.getPartidos().contains(partido));
		
		
	}

}
