//One of two possible ends to a syntax tree of an expression
//represents a double
package hierarchy;

import java.util.ArrayList;
import java.util.Map;

public class Number implements Expression
{
    private double _num = 0;
    private boolean _init = false;
    private int _locationRelativeToPreviousOperator = -1;
    private Expression _previousOperator = null;

    public Number(double aNum)
    {
        _num = aNum;
        _init = true;
    }
    
    public double evaluate(Map<Variable,Double> variableMap) throws IllegalArgumentException
    {
        if(_init == false) throw new IllegalArgumentException("This Number has not been initialized");
        return _num;
    }
    
    @Override
    public boolean isContinuousAt(Map<Variable,Double> variableMap)
    {
    	return true;
    }
    
    public String unParse()
    {
    	String str;
    	if(_num == Math.PI)
    	{
    		str = "#Pi";
    	}
    	else if(_num == Math.E)
    	{
    		str = "#E";
    	}
    	else
    	{
    		str = ((Double)_num).toString();
    	}
    	return str;
    }
    
    public String toWolf()
    {
    	String str;
    	if(_num == Math.PI)
    	{
    		str = "Pi";
    	}
    	else if(_num == Math.E)
    	{
    		str = "E";
    	}
    	else
    	{
    		str = ((Double)_num).toString();
    	}
    	return str;
    }
    
    public String getClassName()
    {
    	return "Number";
    }
    
    public int size()
    {
    	return 1;
    }
    public String getExpType()
    {
    	return "Number";
    }
    
    public ArrayList<Expression> toPreOrderAL()
    {
    	ArrayList<Expression> result = new ArrayList<Expression>();
    	result.add(this);
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