package ar.edu.unq.po2.tpComposite.ejercicioShapeShifter;

import java.util.List;

/* COMPONENT */

public interface IShapeShifter {
    
    public IShapeShifter compose (IShapeShifter figura);
    
    public Integer deepest();
    
    public IShapeShifter flat ();
    
    public List <Integer> values();
}