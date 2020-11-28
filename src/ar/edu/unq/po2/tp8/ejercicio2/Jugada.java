package ar.edu.unq.po2.tp8.ejercicio2;

import java.util.ArrayList;

public class Jugada {
    
    private ArrayList<Carta> cartas;
    
    public Jugada (Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
        this.cartas = this.crearCartas(carta1, carta2, carta3, carta4, carta5);
    }

    
    /**
     * Crea una mano con las cartas dadas y la retorna.
     * @param carta1
     * @param carta2
     * @param carta3
     * @param carta4
     * @param carta5
     * @return Lista de cartas
     */
    private ArrayList<Carta> crearCartas(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        return cartas;
    }
    
    public ArrayList<Carta> getCartas(){
        return this.cartas;
    }
    
}