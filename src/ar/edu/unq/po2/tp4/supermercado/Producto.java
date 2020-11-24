package ar.edu.unq.po2.tp4.supermercado;

public class Producto {

	protected String nombre;
	protected Double precio;
	protected boolean esPrecioCuidado;
	
	public Producto(String nombre, Double precio, boolean esPrecioCuidado) {
		setNombre(nombre);
		setPrecio(precio);
		setEsPrecioCuidado(esPrecioCuidado);
	}
	
	public Producto(String nombre, Double precio) {
		setNombre(nombre);
		setPrecio(precio);
		setEsPrecioCuidado(false);
	}
	
	public boolean esPrecioCuidado() {
		return this.esPrecioCuidado;
	}
	
	public void aumentarPrecio(Double cantidad) {
		this.setPrecio(this.precio + cantidad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setEsPrecioCuidado(boolean esPrecioCuidado) {
		this.esPrecioCuidado = esPrecioCuidado;
	}
	

	
}
