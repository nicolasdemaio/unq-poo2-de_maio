package ar.edu.unq.po2.tpComposite.ejercicioParcela;

import java.util.ArrayList;
import java.util.List;

/* COMPOSITE */

public class ParcelaMixta extends Parcela {

	private List<Parcela> hijos;
	
	/**
	 * La parcela Mixta esta divida en 4 regiones de parcelas, no puede ser mas de 4.
	 * Por esto decidi pedir por constructor las 4.
	 */
	public ParcelaMixta(Parcela parcela1, Parcela parcela2, Parcela parcela3, Parcela parcela4) {
		hijos = new ArrayList<Parcela>();
		this.añadirParcela(parcela1);
		this.añadirParcela(parcela2);
		this.añadirParcela(parcela3);
		this.añadirParcela(parcela4);
	}
	
	@Override
	public void añadirParcela(Parcela parcela) throws RuntimeException {
		if(hijos.size() <= 4) {
			hijos.add(parcela);
		}
		else {
			throw new RuntimeException("Las parcelas mixtas solo pueden tener hasta 4 parcelas");
		}
	}
	
	@Override
    public void removerParcela (Parcela parcela) throws Exception {
        this.hijos.remove(parcela);
    }
	
	@Override
	public Double gananciaAnual() {
		return this.hijos.stream().mapToDouble(parcela -> parcela.gananciaAnual()/4).sum();
	}

}
