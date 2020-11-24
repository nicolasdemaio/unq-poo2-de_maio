package ar.edu.unq.po2.tpStateYStrategy.ejercicioEncriptacion;

public class EncriptadorNaive {
	
	private EstrategiaDeEncriptacion estrategia;
	
	public EncriptadorNaive (EstrategiaDeEncriptacion estrategia) {
		this.estrategia = estrategia;
	}

	public EstrategiaDeEncriptacion getEstrategia() {

		return this.estrategia;
	}

	public void setEstrategia(EstrategiaDeEncriptacion estrategiaNueva) {
		this.estrategia = estrategiaNueva;
		
	}

	public String encriptar(String texto) {
		
		return estrategia.encriptar(texto);
	}

	public String desencriptar(String texto) {

		return estrategia.desencriptar (texto);
	}
}
