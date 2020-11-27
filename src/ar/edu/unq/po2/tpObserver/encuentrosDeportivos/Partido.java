package ar.edu.unq.po2.tpObserver.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class Partido {
	
	String resultado;
	List <String> contrincantes;
	String deporte;
	
	public Partido(String resultado, List<String> contrincantes, String deporte) {
		this.resultado = resultado;
		this.contrincantes = contrincantes;
		this.deporte = deporte;
	}

	public ArrayList<String> datosDelPartido() {
		ArrayList<String> datosDelPartido = new ArrayList<String>();
		datosDelPartido.add(this.getDeporte());
		datosDelPartido.addAll(this.getContrincantes());
		return datosDelPartido;
	}
	
	public String getResultado() {
		return resultado;
	}


	public List<String> getContrincantes() {
		return contrincantes;
	}


	public String getDeporte() {
		return deporte;
	}



}
