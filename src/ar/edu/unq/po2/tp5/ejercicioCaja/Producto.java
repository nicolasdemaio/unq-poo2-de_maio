package ar.edu.unq.po2.tp5.ejercicioCaja;

public class Producto implements Registrable {

	private String nombre;
	protected double precio;
	private int stock;
	
	public Producto(String nombre, double precio, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void decrementarStock() {
		stock --;
	}

	@Override
	public double registrarse() {
		this.decrementarStock();
		return getPrecio();
	}
	
}
