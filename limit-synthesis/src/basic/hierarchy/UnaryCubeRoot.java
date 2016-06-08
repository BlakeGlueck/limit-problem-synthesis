package hierarchy;

import java.util.ArrayList;
import java.util.Map;

public class UnaryCubeRoot implements Expression, UnaryOperator {
	
	private Expression _exp = null;
	private int _locationRelativeToPreviousOperator = -1;
    private Expression _previousOperator = null;
	
	public UnaryCubeRoot(Expression anExp)
	{
		_exp = anExp;
		_exp.setLocationRelativeToPreviousOperator(0);
        _exp.setPreviousOperator(this);
	}

	@Override
	public Expression getExp() {
		return _exp;
	}

	@Override
	public void setExp(Expression anExp) {
		_exp = anExp;
		_exp.setLocationRelativeToPreviousOperator(0);
    	_exp.setPreviousOperator(this);
	}

	@Override
	public double evaluate(Map<Variable, Double> variableMap) 
	{
		if(_exp == null) throw new IllegalArgumentException("This CubeRoot has not been initialized");
        
        return Math.cbrt(_exp.evaluate(variableMap));
	}

	@Override
	public boolean isContinuousAt(Map<Variable, Double> variableMap) {
		boolean result = true;
    	return (result && _exp.isContinuousAt(variableMap));
	}

	@Override
	public String toWolf() {
		String str = "(CubeRoot[" + _exp.toWolf() + "])";
    	return str;
	}

	@Override
	public String unParse() {
    	String str = "(cbrt(" + _exp.unParse() + "))";
    	return str;
	}

	@Override
	public String getClassName() {
		return "CubeRoot";
	}

	@Override
	public int size() {
		return 1 + _exp.size();
	}

	@Override
	public String getExpType() {
		return "Unary";
	}

	@Override
	public ArrayList<Expression> toPreOrderAL() {
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
