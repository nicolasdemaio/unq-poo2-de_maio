package ar.edu.unq.po2.tp8.ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PokerStatus {
	
	public String verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		
		if (this.esPoker(carta1, carta2, carta3, carta4, carta5)) {
			return "Poker";
	    } else if (this.esColor(carta1, carta2, carta3, carta4, carta5)) {
	    	return "Color";
	    } else if (this.esTrio(carta1, carta2, carta3, carta4, carta5)) {
	    	return "Trio";
	    } else {
	    	return "Nada";
	    }
	}
		
	public Boolean esPoker(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		ArrayList<Carta> cartas = this.crearMano(carta1, carta2, carta3, carta4, carta5);
		return cartas.stream()
				.anyMatch(carta -> this.hayPokerDe(carta, cartas));
	}
		
	public Boolean esTrio(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		ArrayList<Carta> cartas = this.crearMano(carta1, carta2, carta3, carta4, carta5);
		return cartas.stream().anyMatch(x -> this.hayTrio(x, cartas));
	}
	
	public Boolean esColor(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		ArrayList<Carta> cartas = this.crearMano(carta1, carta2, carta3, carta4, carta5);
		return cartas.stream().anyMatch(x -> this.hayColor(x, cartas));
	}


	private Boolean hayColor(Carta carta, ArrayList<Carta> cartas) {
		return cartas.stream()
				.filter(x -> x.getPalo().equals(carta.getPalo()))
				.count() == 5;
	}

	private Boolean hayTrio(Carta unaCarta, ArrayList<Carta> cartas) {
		return cartas.stream()
			   .filter(carta -> carta.getValorNumerico() == unaCarta.getValorNumerico())
			   .count() == 3;
	}

	private ArrayList<Carta> crearMano(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		ArrayList<Carta> cartas = new ArrayList<Carta>
		(Arrays.asList(carta1, carta2, carta3, carta4, carta5)); 
		return cartas;
	}


	public Boolean hayPokerDe(Carta unaCarta, ArrayList<Carta> cartas) {
		return cartas.stream()
				   .filter(carta -> carta.getValorNumerico() == unaCarta.getValorNumerico())
				   .count() == 4;
	}

	public Jugada jugadaGanadoraContra(Jugada jugada1, Jugada jugada2) {
		String resultado1 = this.verificar(jugada1.getCartas().get(0), jugada1.getCartas().get(1), jugada1.getCartas().get(2), jugada1.getCartas().get(3), jugada1.getCartas().get(4));
		String resultado2 = this.verificar(jugada2.getCartas().get(0), jugada2.getCartas().get(1), jugada2.getCartas().get(2), jugada2.getCartas().get(3), jugada2.getCartas().get(4));
		if (resultado1.equals(resultado2)) {
			return this.ganadorPorValorEntre(jugada1, jugada2);
		} else {
			return this.ganadorEntre(jugada1, jugada2);
		}
	}

	private Jugada ganadorPorValorEntre(Jugada jugada1, Jugada jugada2) {
		Integer resultado1 = this.getValorNumericoTotal(jugada1.getCartas());
		Integer resultado2 = this.getValorNumericoTotal(jugada2.getCartas());
		if (resultado1 > resultado2) {
			return jugada1;
		} else {
			return jugada2;
		}
	}

	private Integer getValorNumericoTotal(ArrayList<Carta> cartas) {
		return cartas.stream()
				.mapToInt(Carta::getValorNumerico)
				.sum();
	}

	private Jugada ganadorEntre(Jugada jugada1, Jugada jugada2) {
		String resultado1 = this.verificar(jugada1.getCartas().get(0), jugada1.getCartas().get(1), jugada1.getCartas().get(2), jugada1.getCartas().get(3), jugada1.getCartas().get(4));
		String resultado2 = this.verificar(jugada2.getCartas().get(0), jugada2.getCartas().get(1), jugada2.getCartas().get(2), jugada2.getCartas().get(3), jugada2.getCartas().get(4));
		if (resultado1.equals("Poker") && !(resultado2.equals("Poker"))) {
			return jugada1;
		} else if (resultado1.equals("Color") && resultado2.equals("Trio")) {
			return jugada1;
		} else if (resultado1.equals("Trio") && resultado2.equals("Nada")) {
			return jugada1;
		} else {
			return jugada2;
		}
	}
}
