package ar.edu.unq.po2.tpStateYStrategy.ejercicioEncriptacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EncriptacionNumerica implements EstrategiaDeEncriptacion {


	@Override
	public String encriptar(String texto) {
		
		List <Integer> output = new ArrayList <Integer> ();
		
		for (Character letra : texto.toCharArray()) {
			if (letra.equals(' ')) {
				output.add(0);
			}else {
				int letraModificada = letra - 'a' + 1; // como la letra a tiene que ser el numero 1, a - a es 0, por eso le sumamos 1. Con el resto de las letras pasa lo mismo, b - a es 1 y si le sumamos 1 es 2.
				output.add(letraModificada);}
			}
		return output.stream()           
                     .map(String::valueOf)  
                     .collect(Collectors.joining(","));
	}

	@Override
	public String desencriptar(String texto) {
		
		List <Character> output = new ArrayList <Character> ();
		
		String [] listaString = texto.split(",");
		
		for (int i = 0; i < listaString.length; i++) {
			if (listaString[i].equals("0")) {
				output.add(' ');
			} else {
				Integer valorNumericoLetra = Integer.parseInt(listaString[i]); //Se obtiene el valor del numero que esta en el string.
				Character letraModificada =(char) (valorNumericoLetra + 'a' - 1); // Ya conociendo el valor del numero, lo convertimos en letra con la tecnica explicada anteriormente.
				output.add(letraModificada);
			}
		}
		
		return 	output.stream()
				      .map(String::valueOf)  
                      .collect(Collectors.joining());
	}

}