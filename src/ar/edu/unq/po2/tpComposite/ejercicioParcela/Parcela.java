package ar.edu.unq.po2.tpComposite.ejercicioParcela;

/* COMPONENT */

public abstract class Parcela {
	
	public void añadirParcela(Parcela parcela) throws Exception {
        throw new Exception ("Solo se puede añadir parcelas a parcelas mixtas");
    }
    
    public void removerParcela (Parcela parcela) throws Exception {
        
        throw new Exception ("Solo se puede remover parcelas a parcelas mixtas");
    }
    
    public abstract Double gananciaAnual();
    
}