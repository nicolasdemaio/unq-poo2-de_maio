package ar.edu.unq.po2.tp8.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void cuando4CartasSonDelMismoValor_EntoncesEsPoker() {
		
		//Setup
		// SUT
		PokerStatus pokerStatus = new PokerStatus();
		
		//DOC
		Carta carta2Diamante = mock(Carta.class);
		Carta carta2Trebol = mock(Carta.class);
		Carta carta2Corazones = mock(Carta.class);
		Carta carta2Picas = mock(Carta.class);
		Carta carta1Trebol = mock(Carta.class);
		
		when(carta2Diamante.getValorNumerico()).thenReturn(2);
        when(carta2Corazones.getValorNumerico()).thenReturn(2);
        when(carta2Picas.getValorNumerico()).thenReturn(2);
        when(carta2Trebol.getValorNumerico()).thenReturn(2);
        when(carta1Trebol.getValorNumerico()).thenReturn(1);
        
        when(carta2Diamante.getPalo()).thenReturn("D");
        when(carta2Corazones.getPalo()).thenReturn("C");
        when(carta2Picas.getPalo()).thenReturn("P");
        when(carta2Trebol.getPalo()).thenReturn("T");
        when(carta1Trebol.getPalo()).thenReturn("T");
		
		//Verify
		assertEquals("Poker", pokerStatus.verificar(carta2Diamante, carta2Trebol, carta2Corazones, carta2Picas, carta1Trebol));
	}
	
	@Test
	void cuandoNoEsPokerNiColorNiTrio_EsNada() {
		
		// Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		Carta carta2Diamante = mock(Carta.class);
		Carta carta2Trebol = mock(Carta.class);
		Carta carta10Picas = mock(Carta.class);
		Carta carta1Trebol = mock(Carta.class);
		
		when(carta2Diamante.getValorNumerico()).thenReturn(2);
        when(carta10Picas.getValorNumerico()).thenReturn(10);
        when(carta2Trebol.getValorNumerico()).thenReturn(2);
        when(carta1Trebol.getValorNumerico()).thenReturn(1);
        
        when(carta2Diamante.getPalo()).thenReturn("D");
        when(carta10Picas.getPalo()).thenReturn("P");
        when(carta2Trebol.getPalo()).thenReturn("T");
        when(carta1Trebol.getPalo()).thenReturn("T");
		
		// Verify
		assertEquals("Nada", pokerStatus.verificar(carta2Diamante, carta2Trebol, carta1Trebol, carta1Trebol, carta10Picas));
	}
	
	@Test
	void cuando5Cartas_SonDelMismoColorYPalo_EsColor() {
		
		// Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		Carta carta5Picas = mock(Carta.class);
		Carta carta8Picas = mock(Carta.class);
		Carta carta2Picas = mock(Carta.class);
		Carta carta10Picas = mock(Carta.class);
		
		when(carta5Picas.getPalo()).thenReturn("P");
        when(carta8Picas.getPalo()).thenReturn("P");
        when(carta2Picas.getPalo()).thenReturn("P");
        when(carta10Picas.getPalo()).thenReturn("P");
		
		// Verify
		assertEquals("Color", pokerStatus.verificar(carta5Picas, carta5Picas, carta8Picas, carta2Picas, carta10Picas));
	}
	
	@Test
	void cuando3CartasPoseenElMismoValor_EsTrio() {
		
		//  Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		Carta carta5Picas = mock(Carta.class);
		Carta carta2Trebol = mock(Carta.class);
		Carta carta2Diamante = mock(Carta.class);
		Carta carta1Trebol = mock(Carta.class);
		Carta carta2Picas = mock(Carta.class);
		
		when(carta5Picas.getValorNumerico()).thenReturn(5);
        when(carta2Trebol.getValorNumerico()).thenReturn(2);
        when(carta2Diamante.getValorNumerico()).thenReturn(2);
        when(carta1Trebol.getValorNumerico()).thenReturn(1);
        when(carta2Picas.getValorNumerico()).thenReturn(2);
        
        when(carta5Picas.getPalo()).thenReturn("P");
        when(carta2Trebol.getPalo()).thenReturn("T");
        when(carta2Diamante.getPalo()).thenReturn("D");
        when(carta1Trebol.getPalo()).thenReturn("T");
        when(carta2Picas.getPalo()).thenReturn("P");
		
		// Verify
		assertEquals("Trio", pokerStatus.verificar(carta5Picas, carta2Trebol, carta2Diamante, carta1Trebol, carta2Picas));
	}
	
	@Test
	void cuandoUnaJugadaEsPokerYLaOtraEsDistintoDePoker_GanaLaPrimeraJugada() {
		//SETUP
		//SUT
		PokerStatus status = new PokerStatus();
		
		//DOC
		Carta carta2Diamante = mock(Carta.class);
		Carta carta2Trebol = mock(Carta.class);
		Carta carta2Corazones = mock(Carta.class);
		Carta carta2Picas = mock(Carta.class);
		Carta carta1Trebol = mock(Carta.class);
		Carta carta5Trebol = mock(Carta.class);
		
		when(carta2Diamante.getValorNumerico()).thenReturn(2);
        when(carta2Corazones.getValorNumerico()).thenReturn(2);
        when(carta2Picas.getValorNumerico()).thenReturn(2);
        when(carta2Trebol.getValorNumerico()).thenReturn(2);
        when(carta1Trebol.getValorNumerico()).thenReturn(1);
        when(carta5Trebol.getValorNumerico()).thenReturn(5);
        
        when(carta2Diamante.getPalo()).thenReturn("D");
        when(carta2Corazones.getPalo()).thenReturn("C");
        when(carta2Picas.getPalo()).thenReturn("P");
        when(carta2Trebol.getPalo()).thenReturn("T");
        when(carta1Trebol.getPalo()).thenReturn("T");
        when(carta5Trebol.getPalo()).thenReturn("T");
		
		Jugada jugadaConPoker = new Jugada(carta2Diamante, carta2Trebol, carta2Corazones, carta2Picas, carta1Trebol);
		Jugada jugadaSinPoker = new Jugada(carta5Trebol, carta1Trebol, carta2Picas, carta2Corazones, carta2Diamante);
		
		//Verify
		assertEquals(jugadaConPoker, status.jugadaGanadoraContra(jugadaConPoker, jugadaSinPoker));
		
	}
	
	@Test
	void cuando2JugadasSonIguales_GanaLaQueMayorValorDeManoTenga() {
		//SETUP
				//SUT
				PokerStatus status = new PokerStatus();
				
				//DOC
				Carta carta2Diamante = mock(Carta.class);
				Carta carta2Trebol = mock(Carta.class);
				Carta carta2Corazones = mock(Carta.class);
				Carta carta2Picas = mock(Carta.class);
				Carta carta1Trebol = mock(Carta.class);
				
				Carta carta4Trebol = mock(Carta.class);
				Carta carta4Corazones = mock(Carta.class);
				Carta carta4Picas = mock(Carta.class);
				Carta carta4Diamante = mock(Carta.class);
				Carta carta5Corazones = mock(Carta.class);
				
				when(carta2Diamante.getValorNumerico()).thenReturn(2);
		        when(carta2Corazones.getValorNumerico()).thenReturn(2);
		        when(carta2Picas.getValorNumerico()).thenReturn(2);
		        when(carta2Trebol.getValorNumerico()).thenReturn(2);
		        when(carta1Trebol.getValorNumerico()).thenReturn(1);
		        
		        when(carta4Trebol.getValorNumerico()).thenReturn(4);
		        when(carta4Corazones.getValorNumerico()).thenReturn(4);
		        when(carta4Picas.getValorNumerico()).thenReturn(4);
		        when(carta4Diamante.getValorNumerico()).thenReturn(4);
		        when(carta5Corazones.getValorNumerico()).thenReturn(5);
		        
		        when(carta2Diamante.getPalo()).thenReturn("D");
		        when(carta2Corazones.getPalo()).thenReturn("C");
		        when(carta2Picas.getPalo()).thenReturn("P");
		        when(carta2Trebol.getPalo()).thenReturn("T");
		        when(carta1Trebol.getPalo()).thenReturn("T");
		        
		        when(carta4Trebol.getPalo()).thenReturn("T");
		        when(carta4Corazones.getPalo()).thenReturn("C");
		        when(carta4Picas.getPalo()).thenReturn("P");
		        when(carta4Diamante.getPalo()).thenReturn("D");
		        when(carta5Corazones.getPalo()).thenReturn("C");
				
				Jugada jugadaConValorMasAlto = new Jugada(carta4Trebol, carta4Corazones, carta4Picas, carta4Diamante, carta5Corazones);
				Jugada jugadaConValorMasBajo = new Jugada(carta2Diamante, carta2Trebol, carta2Corazones, carta2Picas, carta1Trebol);
				
				//Verify
				assertEquals(jugadaConValorMasAlto, status.jugadaGanadoraContra(jugadaConValorMasAlto, jugadaConValorMasBajo));
	}
	
	// Utilicé los test doubles STUB: El propósito de un Stub es el de proveer valores concretos para guiar al test en una determinada dirección.
	

}
