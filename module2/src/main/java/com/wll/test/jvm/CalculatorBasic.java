package com.wll.test.jvm;

public class CalculatorBasic implements ICalculator {

	public String calculate(String expression) {
		return expression;
	}

	public String getVersion() {
		return "1.0";
	}

}
