//Class which represents an multiplicative inverse value of an expression.
//Requires only 1 expression
package hierarchy;

import java.util.ArrayList;
import java.util.Map;

public class UnaryReciprocal implements UnaryOperator {

    private Expression _exp = null;
    private int _locationRelativeToPreviousOperator = -1;
    private Expression _previousOperator = null;
    
    public UnaryReciprocal(Expression e)
    {
        _exp = e;
        _exp.setLocationRelativeToPreviousOperator(0);
        _exp.setPreviousOperator(this);
    }
        
    public double evaluate(Map<Variable,Double> variableMap) throws IllegalArgumentException
    {
        if(_exp == null) throw new IllegalArgumentException("This Reciprocal has not been initialized");
        
        return 1/(_exp.evaluate(variableMap));
    }
    public void append(Expression e)
    {
        _exp = e;
    }
    
    @Override
    public boolean isContinuousAt(Map<Variable,Double> variableMap)
    {
    	boolean result = true;
    	if(_exp.evaluate(variableMap) == 0)
    	{
    		result = false;
    	}
    	return (result && _exp.isContinuousAt(variableMap));
    }
    
    public String unParse()
    {
    	String str = "(reciprocal("+  _exp.unParse() + "))";
    	return str;
    }
    
    public String toWolf()
    {
    	String str = "(1/" + _exp.toWolf() + ")";
    	return str;
    }
    
    public String getClassName()
    {
    	return "UnaryReciprocal";
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
