//Class which represents subtraction. Requires two expressions to function.
package hierarchy;

import java.util.ArrayList;
import java.util.Map;

public class BinaryMinus implements BinaryOperator {

    private Expression _exp1 = null;
    private Expression _exp2 = null;
    private int _locationRelativeToPreviousOperator = -1;
    private Expression _previousOperator = null;
    
    public BinaryMinus(Expression subtractFrom, Expression subtractHowMuch)
    {
        _exp1= subtractFrom;
        _exp2= subtractHowMuch;
    	_exp1.setPreviousOperator(this);
    	_exp2.setPreviousOperator(this);
    	_exp1.setLocationRelativeToPreviousOperator(1);
    	_exp2.setLocationRelativeToPreviousOperator(2);        
    }
    
    public double evaluate(Map<Variable,Double> variableMap) throws IllegalArgumentException
    {
        if(_exp1 == null || _exp2 == null) throw new IllegalArgumentException("This Minus has not been initialized");
        
        return _exp1.evaluate(variableMap) - _exp2.evaluate(variableMap);
    }
    
    @Override
    public boolean isContinuousAt(Map<Variable,Double> variableMap)
    {
    	boolean result = true;
    	return (result && _exp1.isContinuousAt(variableMap) && _exp2.isContinuousAt(variableMap));
    }
    
    public String unParse()
    {
    	String str = "(" + _exp1.unParse() + "-" + _exp2.unParse() + ")";
    	return str;
    }
    
    public String toWolf()
    {
    	String str = "(" + _exp1.toWolf() + "-" + _exp2.toWolf() + ")";
    	return str;
    }
    
    public String getClassName()
    {
    	return "BinaryMinus";
    }
    
    public int size()
    {
    	return 1 + _exp1.size() + _exp2.size();
    }
    
    public String getExpType()
    {
    	return "Binary";
    }
    
    public Expression getExp1()
    {
    	return _exp1;
    }
    
    public Expression getExp2()
    {
    	return _exp2;
    }
    
    public void setExp1(Expression anExp)
    {
    	_exp1 = anExp;
    	_exp1.setLocationRelativeToPreviousOperator(1);
    	_exp1.setPreviousOperator(this);
    }
    
    public void setExp2(Expression anExp)
    {
    	_exp2 = anExp;
    	_exp2.setLocationRelativeToPreviousOperator(2);
    	_exp2.setPreviousOperator(this);
    }
    
    public ArrayList<Expression> toPreOrderAL()
    {
    	_exp1.setLocationRelativeToPreviousOperator(1);
    	_exp1.setPreviousOperator(this);
    	_exp2.setLocationRelativeToPreviousOperator(2);
    	_exp2.setPreviousOperator(this);
    	ArrayList<Expression> result = new ArrayList<Expression>();
    	result.add(this);
    	result.addAll(_exp1.toPreOrderAL());
    	result.addAll(_exp2.toPreOrderAL());
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
