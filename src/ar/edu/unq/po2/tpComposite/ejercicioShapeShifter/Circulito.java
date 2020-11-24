package ar.edu.unq.po2.tpComposite.ejercicioShapeShifter;

import java.util.Arrays;
import java.util.List;

/* LEAF */

public class Circulito implements IShapeShifter{
    
    private Integer valor;
    
    public Circulito (Integer valor) {
        this.valor = valor;
    }

    @Override
    public IShapeShifter compose(IShapeShifter figura) {
        List <IShapeShifter> lista = Arrays.asList(this,figura);
        return new Rectangulito (lista);
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