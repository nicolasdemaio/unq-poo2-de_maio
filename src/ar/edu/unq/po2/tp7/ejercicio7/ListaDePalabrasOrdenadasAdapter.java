package ar.edu.unq.po2.tp7.ejercicio7;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import java.util.List;

public class ListaDePalabrasOrdenadasAdapter extends DefaultListModel {

	private ListaDePalabrasOrdenadas lista;
	
	public ListaDePalabrasOrdenadasAdapter(ListaDePalabrasOrdenadas lista) {
		this.lista = lista;
	}
	
    public List <String> elementos () {
        List <String> list = new ArrayList <String> ();
        for (int i = 0; i < this.lista.cantidadDePalabras(); i++) {
            list.add(lista.getPalabraDePosicion(i));
        }
        return list;
    }
    
    @Override
    public void addElement(Object element) {
        this.lista.agregarPalabra((String)element);
        this.removeAllElements();
        this.addAll(this.elementos());
    }
    
    /* 
     Tuve un problema, no me ordenaba las palabras en orden.
     Esto era porque no se actualizaba el vector interno que tiene DefaultlistModel y, a su vez,
     mi clase Adapter ya que extiende de DefaultlistModel.
     Para resolver: 
     1) Agrego palabras a la lista Adaptee.
     2) Remuevo todos los elementos del vector interno.
     3) Y Agrego toda slas palabras que tengo en la clase Adaptada list a una Lista que retorna
     el metodo #elementos(). */
	
}
