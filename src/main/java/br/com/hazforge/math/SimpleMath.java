package br.com.hazforge.math;

public class SimpleMath {

	public static Double sum (Double numberOne, Double numberTwo ) {
		return numberOne + numberTwo;
	}
	
	public static Double minus (Double numberOne, Double numberTwo ) {
		return numberOne - numberTwo;
	}
	
	public static Double multiply (Double numberOne, Double numberTwo ) {
		return numberOne * numberTwo;
	}
	
	public static Double divide (Double numberOne, Double numberTwo ) {
		return numberOne / numberTwo;
	}

	public static Double average(Double numberOne, Double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}

	public static Double squareRoot(Double numberOne) {
		return Math.sqrt(numberOne);
	}
	
}
