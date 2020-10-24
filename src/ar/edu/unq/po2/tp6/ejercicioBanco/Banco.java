package ar.edu.unq.po2.tp6.ejercicioBanco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

	private SectorContable sectorContable;
	private List<Cliente> clientes;
	private List<SolicitudCredito> solicitudes;
	
	public Banco(SectorContable sectorContable) {
		setSectorContable(sectorContable);
		clientes = new ArrayList<>();
		solicitudes = new ArrayList<>();
	}
	
	public void registrarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void registrarSolicitud(SolicitudCredito solicitud) {
		solicitudes.add(solicitud);
	}
	
	public List<SolicitudCredito> solicitudesAceptables()
	{
		return solicitudes.
				stream().
				filter(solicitud -> solicitud.esAceptable()).
				collect(Collectors.toList());
	}
	
	public double totalADesembolsar() {
		return sectorContable.totalADesembolsar(solicitudesAceptables());
	}
	
	public void setSectorContable(SectorContable sectorContable) {
		this.sectorContable = sectorContable;
	}

	public List<Cliente> getClientes(){
		return clientes;
	}
	
	public List<SolicitudCredito> getSolicitudes(){
		return solicitudes;
	}
	
}
