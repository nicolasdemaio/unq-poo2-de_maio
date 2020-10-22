package ar.edu.unq.po2.tp3;

public class Cuadrado extends Rectangulo {
	
	public Cuadrado(Point esquinaInferiorIzquierda, int lado) {
		super(esquinaInferiorIzquierda, lado, lado);
	}
	
	public int perimetro() {
		return base() * 4;
	}

}
