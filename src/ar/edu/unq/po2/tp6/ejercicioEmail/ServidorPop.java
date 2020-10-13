package ar.edu.unq.po2.tp6.ejercicioEmail;

import java.util.ArrayList;
import java.util.List;

public class ServidorPop implements IServidorCorreo {

	public List<Correo> recibirNuevos(String user, String pass) {
		List<Correo> retorno = new ArrayList<Correo>();
	  //Verificar autenticidad de usuario.
		//obtener emails Nuevos del usuario.
		//asignar a retorno la lista de los nuevos e-mails.
		return retorno;
	}

	public void conectar(String nombreUsuario, String passusuario) {
	   //Verifica que el usuario sea valido y establece la conexion.
		
	}

	public void enviar(Enviable enviable) {
      //realiza lo necesario para enviar el correo.		
	}

}