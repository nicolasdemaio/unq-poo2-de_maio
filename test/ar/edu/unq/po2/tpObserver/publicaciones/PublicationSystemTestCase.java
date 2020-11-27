package ar.edu.unq.po2.tpObserver.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PublicationSystemTestCase {

	private PublicationSystem sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = new PublicationSystem();
	}

	@Test
	void testConstructor() {
		assertTrue(sistema.getSuscriptores().isEmpty());
	}
	
	@Test
	void testA�adirSuscriptor() {
		//Setup
		IInvestigador investigador = mock(IInvestigador.class);
		List<String> preferencias = Arrays.asList("Bernal", "Smalltalk");
		
		//Exercise
		sistema.a�adirSuscriptor(investigador, preferencias);
		
		//Verify
		assertTrue(sistema.getSuscriptores().containsKey(investigador));
		assertEquals(preferencias, sistema.preferenciasDe(investigador));
	}
	
	@Test
	void testRemoverSuscriptor() {
		//Setup
		IInvestigador investigador = mock(IInvestigador.class);
		List<String> preferencias = Arrays.asList("Bernal", "Smalltalk");
				
		//Exercise
		sistema.a�adirSuscriptor(investigador, preferencias);
		sistema.removerSuscriptor(investigador);
				
		//Verify
		assertFalse(sistema.getSuscriptores().containsKey(investigador));
	}
	
	@Test
	void testCuandoSeA�adeUnArticulo_SeNotificaALosSuscriptoresConEsosIntereses() {
		//Setup
		IInvestigador investigadorNotificado = mock(IInvestigador.class);
		List<String> preferenciasNotificables = Arrays.asList("Bernal", "Smalltalk");
		
		IInvestigador investigadorNoNotificado = mock(IInvestigador.class);
		List<String> preferenciasNoNotificables = Arrays.asList("Java");
		
		Article articulo = mock(Article.class);
		
		when(articulo.correspondeConLasPreferencias(preferenciasNotificables)).thenReturn(true);
		when(articulo.correspondeConLasPreferencias(preferenciasNoNotificables)).thenReturn(false);
		
		//Exercise
		sistema.a�adirSuscriptor(investigadorNotificado, preferenciasNotificables);
		sistema.a�adirSuscriptor(investigadorNoNotificado, preferenciasNoNotificables);
		
		sistema.addArticle(articulo);
		
		//Verify
		assertTrue(sistema.getArticulos().contains(articulo));
		verify(investigadorNotificado, times(1)).update(articulo);
		verifyNoInteractions(investigadorNoNotificado);
	}
	
	@Test
	void testRemoveArticle() {
		//Setup
		Article articulo = mock(Article.class);
						
		//Exercise
		sistema.removeArticle(articulo);
						
		//Verify
		assertFalse(sistema.getArticulos().contains(articulo));
	}

}
