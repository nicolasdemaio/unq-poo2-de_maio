package ar.edu.unq.po2.tp6.ejercicioBanco;

import java.util.List;

public class BancoSectorContable implements SectorContable {

	@Override
	public double totalADesembolsar(List<SolicitudCredito> solicitudesAceptables) {
		return solicitudesAceptables.stream()
									.mapToDouble(SolicitudCredito::getMonto)
									.sum();
	}

	
	
}
