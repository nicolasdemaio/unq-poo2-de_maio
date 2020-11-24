package ar.edu.unq.po2.tpComposite.ejercicioShapeShifter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* COMPOSITE */

public class Rectangulito implements IShapeShifter {
	
    private List <IShapeShifter> figuras;
   
    public Rectangulito (List <IShapeShifter> figuras) {
        this.figuras = figuras;
    }

	@Override
    public IShapeShifter compose(IShapeShifter figura) {
        
        List <IShapeShifter> lista = Arrays.asList(this,figura);

        return new Rectangulito(lista);
    }

    @Override
    public Integer deepest() {
        
        return this.figuras.stream()
                           .mapToInt(figura -> figura.deepest() + 1)
                           .max().orElseThrow(NoSuchElementException::new); // la excepcion va porque sino es un optional Int
    }
    

    @Override
    public IShapeShifter flat() {
        
        List <IShapeShifter> shapesAtomicas = new ArrayList <IShapeShifter> ();
        
        this.values().stream().
                      forEach(valor -> shapesAtomicas.add(new Circulito(valor)));
        
        return new Rectangulito(shapesAtomicas);
    }
/*
    @Override
    public IShapeShifter flat() {
        
        return new Rectangulito(this.flatL(this.figuras));
    }
    
    public List <IShapeShifter> flatL(List <IShapeShifter> lista) {
        
        return lista.stream()
                    .map(figura -> figura.flat())
                    .collect(Collectors.toList());
    }
*/
    public List <IShapeShifter> getFiguras(){
        return this.figuras;
    }
    
    @Override
    public List<Integer> values() {
        List<Integer> valores = new ArrayList <Integer> ();
        this.figuras.stream()
                    .forEach(figura -> valores.addAll(figura.values()));
        
        return valores;
    }
    
    public static void main(String[] args) {
        IShapeShifter a = new Circulito(1);
        IShapeShifter b = new Circulito(2);
        IShapeShifter c = a.compose(b);
        
        System.out.println(a.deepest());
        System.out.println(c.deepest());
    }
}