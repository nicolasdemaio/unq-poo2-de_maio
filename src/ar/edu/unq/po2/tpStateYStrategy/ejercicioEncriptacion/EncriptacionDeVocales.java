package ar.edu.unq.po2.tpStateYStrategy.ejercicioEncriptacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EncriptacionDeVocales implements EstrategiaDeEncriptacion {

	@Override
	public String encriptar(String texto) {
		
		List <Character> output = new ArrayList <Character> ();
		
		for (Character letra : texto.toCharArray()) {
			switch (letra) {
	           case 'a': 
	        	   output.add('e') ;
	        	   break;   
	           case 'e':
	        	   output.add('i') ;
	        	   break;
	           case 'i':
	        	   output.add('o') ;
	        	   break;
	           case 'o':
	        	   output.add('u') ;
	        	   break;
	           case 'u':
	        	   output.add('a') ;
	        	   break;
	           default:
	        	   output.add(letra);
			}
		}
		return output.stream()           
                     .map(String::valueOf)  
                     .collect(Collectors.joining());
	}

	@Override
	public String desencriptar(String texto) 
	{
		List <Character> output = new ArrayList <Character> ();
		
		for (Character letra : texto.toCharArray()) {
			switch (letra) {
	           case 'a': 
	        	   output.add('u') ;
	        	   break;   
	           case 'e':
	        	   output.add('a') ;
	        	   break;
	           case 'i':
	        	   output.add('e') ;
	        	   break;
	           case 'o':
	        	   output.add('i') ;
	        	   break;
	           case 'u':
	        	   output.add('o') ;
	        	   break;
	           default:
	        	   output.add(letra);
			}
		}
		return output.stream()           
                     .map(String::valueOf)  
                     .collect(Collectors.joining());
	}
	
}
