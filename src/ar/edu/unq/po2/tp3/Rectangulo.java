package ar.edu.unq.po2.tp3;

public class Rectangulo {

	// A la hora de crear la clase Cuadrado deberiamos modificar el constructor, dado que el ancho y alto de un cuadrado es igual.
	// Podría crearse una interface IForma que este implementada por las figuras que se quiera crear y en su protocolo tenga los metodos tales como:
	// #getArea(), #base(), #altura(); #perimetro().
	
	private Point esquinaInferiorIzquierda;
	private Point esquinaSuperiorIzquierda;
	private Point esquinaInferiorDerecha;
	private Point esquinaSuperiorDerecha;
	
	public Rectangulo(Point esquinaInferiorIzquierda, int altura, int ancho) {
		this.esquinaInferiorIzquierda = esquinaInferiorIzquierda;
		this.esquinaSuperiorIzquierda = new Point(this.esquinaInferiorIzquierda.getX(), (this.esquinaInferiorIzquierda.getY() + altura));
		this.esquinaInferiorDerecha = new Point((this.esquinaInferiorIzquierda.getX() + ancho), this.esquinaInferiorIzquierda.getY());
		this.esquinaSuperiorDerecha = new Point(this.esquinaInferiorDerecha.getX(), this.esquinaSuperiorIzquierda.getY());
	}
	
	public String toString() {
		return ("Esq. Inf. Izq.: " + esquinaInferiorIzquierda.getX() + esquinaInferiorIzquierda.getY() +
				" || Esq. Sup. Izq.: " + esquinaSuperiorIzquierda.getX() + esquinaSuperiorIzquierda.getY() +
				" || Esq. Inf. Der.: " + esquinaInferiorDerecha.getX() + esquinaInferiorDerecha.getY() +
				" || Esq. Sup. Der.: " + esquinaSuperiorDerecha.getX() + esquinaSuperiorDerecha.getY());
	}
	
	public int getArea() {
		return base() * altura();
	}
	
	public int base() {
		return (esquinaInferiorIzquierda.getX() - esquinaInferiorDerecha.getX()) * (-1);
	}
	
	public int altura() {
		return (esquinaInferiorIzquierda.getY() - esquinaSuperiorIzquierda.getY()) * (-1);
	}
	
	public int perimetro() {
		return (base() * 2) + (altura() * 2);
	}
	
	/**
	 * Indica el sentido del rectangulo, si es Horizontal o Vertical de acuerdo a sus lados.
	 * @return String
	 */
	public String sentido() {
		if(base() > altura()) {
			return "Sentido Horizontal.";
		}
		else {
			return "Sentido Vertical.";
		}
	}
	
}
