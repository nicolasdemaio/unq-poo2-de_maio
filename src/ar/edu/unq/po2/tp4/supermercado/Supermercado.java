package ar.edu.unq.po2.tp4.supermercado;

import java.util.ArrayList;

public class Supermercado {

	private String nombre, direccion;
	private ArrayList<Producto> productos;
	
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
		Double precioTotal = 0.0;
		
		for (Producto producto : productos) {
			precioTotal += producto.getPrecio();
		}
		
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

	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
}
