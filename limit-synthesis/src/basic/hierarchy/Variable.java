//The other of two possible ends to a syntax tree of an expression
//A class which represents a variable. 
//(Provide a given value by providing it in the constructor
// or by mapping this variable to a given value)
package hierarchy;

import java.util.ArrayList;
import java.util.Map;

public class Variable implements Expression
{
    private double _given;
    private String _name;
    private int _locationRelativeToPreviousOperator = -1;
    private Expression _previousOperator = null;

    public Variable()
    {
        _given = 1.0;
        _name = "x";
    }
    public Variable(double aGiven)
    {
        _given = aGiven;
        _name = "x";
    }
    public Variable(String name)
    {
    	_given = 1.0;
    	_name = name;
    }
    
    public String getName()
    {
    	return _name;
    }
    
    public double evaluate(Map<Variable,Double> variableMap) 
    {
        return variableMap.get(this);
    }
    
    @Override
    public boolean isContinuousAt(Map<Variable,Double> variableMap)
    {
    	return true;
    }

    public String unParse()
    {
    	return _name;
    }
    
    public String toWolf()
    {
    	return _name;
    }
    
    public String getClassName()
    {
    	return "Variable";
    }
    
    public int size()
    {
    	return 1;
    }
    
    public String getExpType()
    {
    	return "Variable";
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
