package ar.edu.unq.po2.tp2;

import java.util.List;

public class Empresa {

	private String nombre;
	private String cuit;
	private List<Empleado> empleados;
	private List<ReciboDeHaberes> recibos;
	
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	public int montoSueldosNetos() {
		int monto = empleados.stream().mapToInt(empleado -> empleado.sueldoNeto()).sum();
		return monto;	
	}
	
	public int montoSueldosBrutos() {
		int monto = 0;
		
		for (Empleado empleado : empleados) {
			monto += empleado.sueldoBruto();
		}
		
		return monto;
	}
	
	public int montoRetenciones() {
		int monto = 0;
		
		for (Empleado empleado : empleados) {
			monto += empleado.retenciones();
		}
		
		return monto;
	}
	
	public void liquidarSueldos() {
		
		for (Empleado empleado : empleados) {
			this.generarRecibo(empleado);
		}
		
	}
	
	public void generarRecibo(Empleado empleado) 
	{
		ReciboDeHaberes recibo = new ReciboDeHaberes(empleado);
		recibos.add(recibo);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public String getCuit() {
		return cuit;
	}
	
	public List<Empleado> empleados(){
		return empleados;
	}
	
	public List<ReciboDeHaberes> recibos(){
		return recibos;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	
}
