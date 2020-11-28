package ar.edu.unq.po2.tp7.ejercicio6;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class IteratorAdapter <E> implements Enumeration <E>  {
   
	private Iterator <E> iterator;
    
	//Constructor, tomo una coleccion para que tenga elementos.
    IteratorAdapter (Collection <E> coleccion){
        iterator = coleccion.iterator();
    }
    
    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }
    
    @Override
    public E nextElement () {
        return iterator.next();
    }
}

/*
	IteratorAdapter es el adaptador.
	Enumeration es el target.
	Iterator es el adaptado.
	
	Los mensajes son implementados por la interface Enumeration.
	Y colabora con el iterator (que conoce, colab. interno) con .hasNext() y .next()
*/
