package ar.edu.unq.po2.tpObserver.concursoPreguntas;

public interface ReceptorDeRespuestas {

	void recibirRespuesta(String pregunta, String respuesta, IJugador jugador) throws Exception;
	
}
