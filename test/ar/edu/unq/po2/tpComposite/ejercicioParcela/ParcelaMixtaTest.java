package ar.edu.unq.po2.tpComposite.ejercicioParcela;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParcelaMixtaTest {

	@BeforeEach
    void setUp() throws Exception {
        
    }

    @Test
    void testGananciaAnual() {
        Parcela parcelaSoja1  = new ParcelaDeSoja();
        Parcela parcelaSoja2  = new ParcelaDeSoja();
        Parcela parcelaSoja3  = new ParcelaDeSoja();
        Parcela parcelaTrigo1 = new ParcelaDeTrigo();
        Parcela parcelaTrigo2 = new ParcelaDeTrigo();
        Parcela parcelaMixta1 = new ParcelaMixta(parcelaSoja1, parcelaSoja2, parcelaTrigo1, parcelaTrigo2);
        Parcela parcelaMixta2 = new ParcelaMixta(parcelaMixta1, parcelaSoja3, parcelaSoja1, parcelaSoja2);
        
        
        assertEquals (400, parcelaMixta1.gananciaAnual());
        assertEquals (475, parcelaMixta2.gananciaAnual());
    }

}