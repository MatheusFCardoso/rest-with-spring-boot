package br.com.hazforge.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hazforge.converters.NumberConverter;
import br.com.hazforge.exceptions.UnsupportedMathOperationException;
import br.com.hazforge.math.SimpleMath;

@RestController
public class MathController {

	private static final String template = "Hello, %s !!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception  {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		};
		
		return SimpleMath.sum(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Pleate set a numeric value!");
		}
		
		return SimpleMath.minus(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiply(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Pleate set a numeric value!");
		}
				
		return SimpleMath.multiply(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divide(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Pleate set a numeric value!");
		}
		
		return SimpleMath.divide(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Pleate set a numeric value!");
		}
		
		return SimpleMath.average(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "numberOne") String numberOne
			) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Pleate set a numeric value!");
		}
		
		return SimpleMath.squareRoot(NumberConverter.convertToDouble(numberOne));
	}

	
	
}
