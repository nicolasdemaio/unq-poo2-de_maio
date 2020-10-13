package ar.edu.unq.po2.tp4.supermercado;

public class ProductoPrimeraNecesidad extends Producto{

	private int descuento;
	
	public ProductoPrimeraNecesidad(String nombre, Double precio, boolean esPrecioCuidado, int descuento) {
		super(nombre, precio, esPrecioCuidado);
		setDescuento(descuento);
	}
	
	public ProductoPrimeraNecesidad(String nombre, Double precio, int descuento) {
		super(nombre, precio);
		setDescuento(descuento);
	}

	public int getDescuento() {
		return this.descuento;
	}
	
	public void setDescuento(int descuento) {
		if(descuento >= 0 && descuento <= 100) {
			this.descuento = descuento;
		}
		else {
			this.descuento = 100;
		}
	}

	@Override
	public Double getPrecio() {
		Double precioConDescuento = this.precio - ((this.precio * getDescuento())/100);
		return precioConDescuento;
	}

	
}
