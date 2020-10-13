package ar.edu.unq.po2.tp6.ejercicioEmail;

import java.util.ArrayList;

public class ClienteEmail {
	
	 IServidorCorreo servidor;
	 String nombreUsuario;
	 String passusuario;
	 ArrayList<Enviable> inbox;
	private ArrayList<Enviable> borrados;
	
	public ClienteEmail(IServidorCorreo servidor, String nombreUsuario, String pass){
		this.servidor=servidor;
		this.nombreUsuario=nombreUsuario;
		this.passusuario=pass;
		this.inbox = new ArrayList<Enviable>();
		this.borrados = new ArrayList<Enviable>();
		this.conectar();
	}
	
	public void conectar(){
		this.servidor.conectar(this.nombreUsuario,this.passusuario);
	}
	
	public void borrarCorreo(Enviable enviable){
		this.inbox.remove(enviable);
		this.borrados.remove(enviable);
	}
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Enviable enviable){
		this.borrados.remove(enviable);
	}
	
	public void recibirNuevos(){
		this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
	}
	
	public void enviarCorreo(Enviable enviable){
		this.servidor.enviar(enviable);
	}

}