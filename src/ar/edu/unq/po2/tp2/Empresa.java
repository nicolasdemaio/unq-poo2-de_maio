package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private String nombre;
	private String cuit;
	private List<Empleado> empleados;
	private List<ReciboDeHaberes> recibos;
	
	public Empresa(String nombre, String cuit) {
		this.empleados = new ArrayList<>();
		this.recibos = new ArrayList<>();
		this.nombre = nombre;
		this.cuit = cuit;
	}
	
	public int montoSueldosNetos() 
	{
		return empleados.stream().mapToInt(Empleado::sueldoNeto).sum();
	}
	
	public int montoSueldosBrutos() 
	{
		return empleados.stream().mapToInt(Empleado::sueldoBruto).sum();
	}
	
	public int montoRetenciones() 
	{
		return empleados.stream().mapToInt(Empleado::retenciones).sum();
	}
	
	public void liquidarSueldos() {
		
		empleados.stream().forEach(this::generarRecibo); // Un stream de empleados, por cada uno, this (Empresa) genera recibo.
	}
	
	public void generarRecibo(Empleado empleado) 
	{
		recibos.add(new ReciboDeHaberes(empleado));
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
	
	
	// Muestra de codigo, ejercicio parte c)
	public static void main(String[] args) {
		Empresa empresa = new Empresa("Bernal", "123-4");
		
		Empleado unEmpleado = new EmpleadoPlantaPermanente("Pepe", "Bernal", "Soltero", LocalDate.now(), 10000, 2);
		Empleado otroEmpleado = new EmpleadoContratado("Jose", "Quilmes", "Soltero", LocalDate.now(), 20000, 1, "Tarjeta");
	
		empresa.agregarEmpleado(unEmpleado);
		empresa.agregarEmpleado(otroEmpleado);
		
		System.out.println("- Monto de Sueldos Netos total -");
		System.out.println(empresa.montoSueldosNetos());
		
		System.out.println("- Generacion de Recibos -");
		empresa.liquidarSueldos();

		for (ReciboDeHaberes recibo : empresa.recibos()) {
			System.out.println(recibo);
		}
	}
	
}
