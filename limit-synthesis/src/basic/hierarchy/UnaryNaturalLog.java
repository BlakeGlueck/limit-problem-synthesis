//Class which represents log base e of an expression.
//Requires only 1 expression
package hierarchy;

import java.util.ArrayList;
import java.util.Map;

public class UnaryNaturalLog implements UnaryOperator {

    private Expression _exp = null;
    private int _locationRelativeToPreviousOperator = -1;
    private Expression _previousOperator = null;
    
    public UnaryNaturalLog(Expression e)
    {
        _exp = e;
        _exp.setLocationRelativeToPreviousOperator(0);
        _exp.setPreviousOperator(this);
    }
        
    public double evaluate(Map<Variable,Double> variableMap) throws IllegalArgumentException
    {
        if(_exp == null) throw new IllegalArgumentException("This NaturalLog has not been initialized");
        
        return Math.log(_exp.evaluate(variableMap));
    }
    public void append(Expression e)
    {
        _exp = e;
    }
    
    @Override
    public boolean isContinuousAt(Map<Variable,Double> variableMap)
    {
    	boolean result = true;
    	if(_exp.evaluate(variableMap) <= 0)
    	{
    		result = false;
    	}
    	return (result && _exp.isContinuousAt(variableMap));
    }
    
    public String unParse()
    {
    	String str = "(ln(" + _exp.unParse() + "))";
    	return str;
    }
    
    public String toWolf()
    {
    	String str = "(Log[" + _exp.toWolf() + "])";
    	return str;
    }
    
    public String getClassName()
    {
    	return "UnaryNaturalLog";
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
