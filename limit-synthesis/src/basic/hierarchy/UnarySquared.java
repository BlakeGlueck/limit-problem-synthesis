//Class which represents raising an expression to the second power. 
//Requires only one expression to function.
package hierarchy;

import java.util.ArrayList;
import java.util.Map;

public class UnarySquared implements UnaryOperator {

    private Expression _exp = null;
    private int _locationRelativeToPreviousOperator = -1;
    private Expression _previousOperator = null;
    
    public UnarySquared(Expression e)
    {
        _exp = e;
        _exp.setLocationRelativeToPreviousOperator(0);
        _exp.setPreviousOperator(this);
    }
    
    public double evaluate(Map<Variable,Double> variableMap) throws IllegalArgumentException
    {
        if(_exp == null) throw new IllegalArgumentException("This Squared has not been initialized");
        
        return (_exp.evaluate(variableMap))*(_exp.evaluate(variableMap));
    }
    public void append(Expression e)
    {
        _exp = e;
    }
    
    @Override
    public boolean isContinuousAt(Map<Variable,Double> variableMap)
    {
    	boolean result = true;
    	return (result && _exp.isContinuousAt(variableMap));
    }
    
    public String unParse()
    {
    	String str = "(square(" + _exp.unParse() + "))";
    	return str;
    }
    
    public String toWolf()
    {
    	String str = "(" + _exp.toWolf() + "^2)";
    	return str;
    }
    
    public String getClassName()
    {
    	return "UnarySquared";
    }
    
    public int size()
    {
    	return 1 + _exp.size();
    }
    
    public String getExpType()
    {
    	return "Unary";
    }
    
    public Expression getExp()
    {
    	return _exp;
    }
    
    public void setExp(Expression anExp)
    {
    	_exp = anExp;
    	_exp.setLocationRelativeToPreviousOperator(0);
        _exp.setPreviousOperator(this);
    }
    
    public ArrayList<Expression> toPreOrderAL()
    {
    	_exp.setLocationRelativeToPreviousOperator(0);
        _exp.setPreviousOperator(this);
    	ArrayList<Expression> result = new ArrayList<Expression>();
    	result.add(this);
    	result.addAll(_exp.toPreOrderAL());
    	return result;
    }
    
    public void setPreviousOperator(Expression e)
    {
    	_previousOperator = e;
    }
    
    public Expression getPreviousOperator()
    {
    	return _previousOperator;
    }
    
    public void setLocationRelativeToPreviousOperator(int i)
    {
    	_locationRelativeToPreviousOperator = i;
    }
    
    public int getLocationRelativeToPreviousOperator()
    {
    	return _locationRelativeToPreviousOperator;
    }
}
