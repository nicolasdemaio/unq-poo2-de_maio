package ar.edu.unq.po2.tp8.ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PokerStatus {

	public String verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		String jugada = "Nada";
		
		if(esPoker(carta1, carta2, carta3, carta4, carta5)) {
			jugada = "Poker";
		}
		else if(esColor(carta1, carta2, carta3, carta4, carta5)) {
			jugada = "Color";
		}
		else if(esTrio(carta1, carta2, carta3, carta4, carta5)) {
			jugada = "Trio";
		}
		
		return jugada;
	}

	private Boolean esTrio(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		List<String> cartas = this.crearMano(carta1, carta2, carta3, carta4, carta5);
		List<String> valoresDeCartas = valoresDeCartas(cartas);
		
		return valoresDeCartas.stream().anyMatch(valor -> this.hayTrioDe(valor, valoresDeCartas));
	}

	private Boolean hayTrioDe(String valorDado, List<String> valoresDeCartas) {
		return valoresDeCartas.stream()
                .filter(valorDeCarta -> valorDeCarta.equals(valorDado))
                .count() == 3;
	}

	private Boolean esColor(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		List <String> cartas = this.crearMano(carta1,carta2,carta3,carta4,carta5);
		
		ArrayList<String> palosDeCartas = obtenerPalosDeCartas(cartas);
		
		List<String> palosDeJuego = Arrays.asList("P", "C", "D", "T");
		
		return palosDeJuego.stream().anyMatch(palo -> todosLosPalosDeCartasSonDelPalo(palosDeCartas, palo));
	}

	private ArrayList<String> obtenerPalosDeCartas(List<String> cartas) {
		return (ArrayList<String>) cartas.stream().map(carta -> carta.substring(carta.length() - 1)).collect(Collectors.toList());
	}

	private Boolean todosLosPalosDeCartasSonDelPalo(ArrayList<String> paloDeCartas, String palo) {
		return paloDeCartas.stream().allMatch(paloDeCarta -> paloDeCarta.equals(palo));
	}

	private Boolean esPoker(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		List <String> cartas = this.crearMano(carta1,carta2,carta3,carta4,carta5);
		
		ArrayList<String> cartasSoloValor = valoresDeCartas(cartas);
		
		return cartasSoloValor.stream().filter(carta -> carta.equals(cartasSoloValor.get(0))).count() == 4 ||
				cartasSoloValor.stream().filter(carta -> carta.equals(cartasSoloValor.get(1))).count() == 4;
	}

	private ArrayList<String> valoresDeCartas(List<String> cartas) {
		return (ArrayList<String>) cartas.stream().map(carta -> carta.substring(0, carta.length()-1)).collect(Collectors.toList());
	}

	private List <String> crearMano (String carta1, String carta2, String carta3, String carta4, String carta5){
	       
		List <String> mano = new ArrayList <String> ();
	    mano.add(carta1);
	    mano.add(carta2);
	    mano.add(carta3);
	    mano.add(carta4);
	    mano.add(carta5);
	    return mano;     
	}

}

