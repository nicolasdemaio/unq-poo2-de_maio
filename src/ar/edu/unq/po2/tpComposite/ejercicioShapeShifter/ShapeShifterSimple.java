package ar.edu.unq.po2.tpComposite.ejercicioShapeShifter;

import java.util.Arrays;
import java.util.List;

/* LEAF */

public class ShapeShifterSimple implements IShapeShifter{
    
    private Integer valor;
    
    public ShapeShifterSimple (Integer valor) {
        this.valor = valor;
    }

    @Override
    public IShapeShifter compose(IShapeShifter figura) {
        List <IShapeShifter> lista = Arrays.asList(this,figura);
        return new ShapeShifterCompuesto(lista);
    }

    @Override
    public Integer deepest() {
        return 0;
    }

    @Override
    public IShapeShifter flat() {

        return this;
    }

    @Override
    public List<Integer> values() {
        List<Integer> list = Arrays.asList(this.getValor());
        return list;
    }
    
    public Integer getValor() {
        return this.valor;
    }

}