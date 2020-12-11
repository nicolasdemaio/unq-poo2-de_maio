package ar.edu.unq.po2.tpComposite.ejercicioShapeShifter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* COMPOSITE */

public class ShapeShifterCompuesto implements IShapeShifter {
	
    private List <IShapeShifter> figuras;
   
    public ShapeShifterCompuesto (List <IShapeShifter> figuras) {
        this.figuras = figuras;
    }

	@Override
    public IShapeShifter compose(IShapeShifter figura) {
        
        List <IShapeShifter> lista = Arrays.asList(this,figura);

        return new ShapeShifterCompuesto(lista);
    }

    @Override
    public Integer deepest() {
        
        return this.figuras.stream() 
                           .mapToInt(figura -> figura.deepest() + 1) // Un stream de las profundidades de cada ShapeShifter
                           .max().orElseThrow(NoSuchElementException::new); // la excepcion va porque sino es un optional Int
        
        					// Agarra el maximo de las profundidades, que es el maximo de profundidad de este ShapeShifter.
    }
    

    @Override
    public IShapeShifter flat() {
        
        List <IShapeShifter> shapesAtomicas = new ArrayList<>(); // Lista vacia de IShapeShifter
        
        this.values().stream().
                      forEach(valor -> shapesAtomicas.add(new ShapeShifterSimple(valor))); //Por cada valor, creo un ShapeShifterSimple y lo agrego a la lista.
        
        return new ShapeShifterCompuesto(shapesAtomicas);
    }

    public List <IShapeShifter> getFiguras(){
        return this.figuras;
    }
    
    @Override
    public List<Integer> values() {
        List<Integer> valores = new ArrayList<>();
        this.figuras.stream()
                    .forEach(figura -> valores.addAll(figura.values())); // A la lista creada le agrega los valores de la figura del for.
        
        return valores;
    }
    
    public static void main(String[] args) {
        IShapeShifter a = new ShapeShifterSimple(1);
        IShapeShifter b = new ShapeShifterSimple(2);
        IShapeShifter c = a.compose(b); // ShapeShifterCompuesto
        
        System.out.println(a.deepest()); // Debe dar 0
        System.out.println(c.deepest()); // Debe dar 1
    }
}