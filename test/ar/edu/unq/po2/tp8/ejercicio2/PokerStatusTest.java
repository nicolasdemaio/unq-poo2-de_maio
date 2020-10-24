package ar.edu.unq.po2.tp8.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTest {

	private String carta2Diamante, carta2Trebol, carta2Corazones, carta2Picas, carta10Picas, carta1Trebol, carta8Picas, carta5Picas, carta4Picas;
	
	@BeforeEach
	void setUp() throws Exception {
		carta2Diamante = "2D";
		carta2Trebol = "2T";
		carta2Corazones = "2C";
		carta2Picas = "2P";
		carta10Picas = "10P";
		carta8Picas = "8P";
		carta5Picas = "5P";
		carta4Picas = "4P";
		carta1Trebol = "AT";
	}

	@Test
	void cuando4CartasSonDelMismoValor_EntoncesEsPoker() {
		
		// Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		// Verify
		assertEquals("Poker", pokerStatus.verificar(carta2Diamante, carta2Trebol, carta2Corazones, carta2Picas, carta1Trebol));
	}
	
	@Test
	void cuando4CartasSonDeDistintoValor_NoEsPoker() {
		
		// Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		// Verify
		assertEquals("Nada", pokerStatus.verificar(carta2Diamante, carta2Trebol, carta1Trebol, carta1Trebol, carta10Picas));
	}
	
	@Test
	void cuando5Cartas_NoSonDelMismoColorYPalo_NoEsColor() {
		
		// Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		// Verify
		assertEquals("Nada", pokerStatus.verificar(carta2Diamante, carta1Trebol, carta2Corazones, carta1Trebol, carta10Picas));
	}
	
	@Test
	void cuando5Cartas_SonDelMismoColorYPalo_EsColor() {
		
		// Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		// Verify
		assertEquals("Color", pokerStatus.verificar(carta5Picas, carta5Picas, carta8Picas, carta2Picas, carta10Picas));
	}
	
	@Test
	void cuando3CartasSonDeDistintoValor_NoEsTrio() {
		
		// Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		// Verify
		assertEquals("Nada", pokerStatus.verificar(carta5Picas, carta2Trebol, carta2Diamante, carta1Trebol, carta10Picas));
	}
	
	@Test
	void cuando3CartasPoseenElMismoValor_EsTrio() {
		
		//  Setup
		PokerStatus pokerStatus = new PokerStatus();
		
		// Verify
		assertEquals("Trio", pokerStatus.verificar(carta2Trebol, carta2Diamante, carta2Picas, carta5Picas, carta1Trebol));
	}

}
