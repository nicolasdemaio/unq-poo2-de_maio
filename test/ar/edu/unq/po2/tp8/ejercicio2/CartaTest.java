package ar.edu.unq.po2.tp8.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testConstructor() {
		Carta carta4Diamante = new Carta("4", "D");
		//Verify
        assertEquals(4,carta4Diamante.getValorNumerico());
        assertEquals("D",carta4Diamante.getPalo());
    }
    
    @Test
    void testElValorDeUnaCarta_EsMayor_AlValorDeOtraCarta() {
        //Setup 
        Carta carta4Diamante = new Carta("4","D");
        Carta carta5Diamante = new Carta("5", "D");
        //Verify
        assertTrue(carta5Diamante.esDeValorSuperiorA(carta4Diamante));
        assertFalse(carta4Diamante.esDeValorSuperiorA(carta5Diamante));
    }
    
    @Test
    void testDosCartas_PoseenElMismoPalo() {
        //Setup
        Carta carta10Picas    =    new Carta ("10","P");
        Carta carta2Picas     =    new Carta ("2","P");
        Carta carta5Corazones =    new Carta ("5","C");
        //Verify
        assertTrue(carta10Picas.esMismoPalo(carta2Picas));
        assertFalse(carta10Picas.esMismoPalo(carta5Corazones)); 
    }

}
