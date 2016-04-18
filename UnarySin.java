//Class which represents the sine of an expression. Requires only one expression to function.
package hierarchy;

import java.util.Map;

public class UnarySin implements UnaryOperator {

    private Expression _exp = null;
    
    public UnarySin(Expression e)
    {
        _exp = e;
    }
    
    public double evaluate(Map<Variable,Double> variableMap) throws IllegalArgumentException
    {
        if(_exp == null) throw new IllegalArgumentException("This Sin has not been initialized");
        
        return Math.sin(_exp.evaluate(variableMap));
    }
    public void append(Expression e)
    {
        _exp = e;
    }
    public String unParse()
    {
    	String str = "(sin(" + _exp.unParse()+ "))";
    	return str;
    }
    
    public String toWolf()
    {
    	String str = "(Sin[" + _exp.toWolf()+ "])";
    	return str;
    }
}