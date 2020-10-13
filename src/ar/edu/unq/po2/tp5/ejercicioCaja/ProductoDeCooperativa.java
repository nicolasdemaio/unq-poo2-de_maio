package ar.edu.unq.po2.tp5.ejercicioCaja;

public class ProductoDeCooperativa extends Producto {

	public ProductoDeCooperativa(String nombre, double precio, int stock) {
		super(nombre, precio, stock);
	}
	
	public double getPrecio() {
		double precioConDescuento = this.precio * 0.9;
		return precioConDescuento;
	}
	
	public double registrarse() {
		this.decrementarStock();
		return this.getPrecio();
	}

}
