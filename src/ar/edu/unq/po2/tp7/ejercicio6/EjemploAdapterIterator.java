package ar.edu.unq.po2.tp7.ejercicio6;

import java.util.ArrayList;
import java.util.Enumeration;

    public class EjemploAdapterIterator {
    	
        public static void main(String[] args) {
            
        	/* Creo un ArrayList y le añado elementos. */
        	
            ArrayList <String> array = new ArrayList <String>();
            array.add("Juan");
            array.add("Carlos");
            array.add("Pepe");
            
            /* Creo un IteratorAdapter y le paso el array.
    	 	   IteratorAdapter tipa con Enumeration porque implementa dicha interface.
    	 	   Y además, recibe un arrayList que es el Adaptado. */
            
            Enumeration <String> enumer = new IteratorAdapter <String> (array);
            
            
            System.out.println(enumer.hasMoreElements()); // Imprime true, tiene elementos.
            
            System.out.println(enumer.nextElement()); // Imprime "Juan"
            System.out.println(enumer.nextElement()); // Imprime "Carlos"
            System.out.println(enumer.nextElement()); // Imprime "Pepe"
            
            System.out.println(enumer.hasMoreElements()); // Imprime false, ya no tiene elementos que iterar.
        }
        
}