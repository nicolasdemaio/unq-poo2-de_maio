package ar.edu.unq.po2.tpComposite.ejercicioParcela;

/* COMPONENT */

public abstract class Parcela {
	
	public void aņadirParcela(Parcela parcela) throws Exception {
        throw new Exception ("Solo se puede aņadir parcelas a parcelas mixtas");
    }
    
    public void removerParcela (Parcela parcela) throws Exception {
        
        throw new Exception ("Solo se puede remover parcelas a parcelas mixtas");
    }
    
    public abstract Double gananciaAnual();
    
}

/*
 * Decidi utilizar una Clase Abstracta (y no interface) porque
 * el cliente si tipa o trata con Parcela, deberia poder mandarle aņadirParcela.
 * Si es Leaf, lanza excepcion.
 * Si es composite, aņade parcela.
 */
