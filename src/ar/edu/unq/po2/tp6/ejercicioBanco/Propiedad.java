package ar.edu.unq.po2.tp6.ejercicioBanco;

public class Propiedad implements Garantia {

	private String descripcion, direccion;
	private double valorFiscal;
	
	public Propiedad(String descripcion, String direccion, double valorFiscal) {
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.valorFiscal = valorFiscal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setValorFiscal(double valorFiscal) {
		this.valorFiscal = valorFiscal;
	}

	@Override
	public double valorFiscal() {
		return valorFiscal;
	}

}
