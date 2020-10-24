package ar.edu.unq.po2.tp7.ejercicio5;

public class CuentaCorriente extends CuentaBancaria {
	
    private int descubierto;
    
    public CuentaCorriente(String titular, int descubierto){
            super(titular);
            this.descubierto=descubierto;
    }
    
    public int getDescubierto(){
        return this.descubierto;
    }
    
    public boolean puedeExtraer(int monto) {
        return this.getSaldo()+this.getDescubierto()>=monto;
    }
    
}