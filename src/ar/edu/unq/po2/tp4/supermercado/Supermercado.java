package ar.edu.unq.po2.tp4.supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	private String nombre, direccion;
	private List<Producto> productos;
	
	public Supermercado(String nombre, String direccion) {
		setNombre(nombre);
		setDireccion(direccion);
		productos = new ArrayList<>();
	}
	
	public void agregarProducto(Producto unProducto) {
		productos.add(unProducto);
	}
	
	public int getCantidadDeProductos() {
		return productos.size();
	}
	
	public Double getPrecioTotal() {

		double precioTotal = productos.stream().mapToDouble(Producto::getPrecio).sum();
		
		return precioTotal;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Producto> getProductos() {
		return productos;
	}
	
}
