package ar.edu.unq.po2.tp8.ejercicio2;

public class Carta {

	Integer valor;
	Character palo;
	
	public Carta(Integer valor, Character palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public Integer getValor() {
        return valor;
    }

    public Character getPalo() {
        return palo;
    }

    public Boolean esMayor(Carta otraCarta) {
        return this.getValor() > otraCarta.getValor();
    }

    public Boolean esMismoPalo(Carta otraCarta) {
        return this.getPalo().equals(otraCarta.getPalo());
    }
  
}
