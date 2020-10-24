package ar.edu.unq.po2.tp7.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {
	
    private String titular;
    private int saldo;
    private List<String> movimientos;
    
    public CuentaBancaria(String titular){
        this.titular=titular;
        this.saldo=0;
        this.movimientos=new ArrayList<String>();
    }
    
    public String getTitular(){
        return this.titular;
    }
    
    public int getSaldo(){
        return this.saldo;
    }
    
    protected void setSaldo(int monto){
        this.saldo=monto;
    }
    
    public void agregarMovimientos(String movimiento){
        this.movimientos.add(movimiento);
    }
    
    public final void extraer(int monto) { //Template Method
        if(puedeExtraer(monto)){ // Operación Primitiva
            this.setSaldo(this.getSaldo()-monto); // Operación Concreta
            this.agregarMovimientos("Extraccion"); // Operacion Concreta
        }
    }
    
    public abstract boolean puedeExtraer(int monto);
}