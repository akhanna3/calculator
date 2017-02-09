package com.calculator;

import org.apache.logging.log4j.Logger;

import com.calculator.exceptions.CalculatorException;
import com.calculator.utils.LogUtils;

/**
 * This class is the entry point for the Calculator.
 * 
 * @author akhanna
 *
 */
public class Main {

	/** Class Logger */
	private static Logger logger = LogUtils.getLogger(Main.class.getCanonicalName().toUpperCase());

	/**
	 * Main entry point for Calculator
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			logger.info("Starting calculator..");

			// SimpleCalculator calc = new SimpleCalculator();
			ExpressionCalculator calc = new ExpressionCalculator();
			calc.run(System.in, System.out);
		} catch (CalculatorException | Exception e) {
			String errorMsg = "Failed to start calculator or calculator crashed due to: " + e.getMessage();
			logger.fatal(errorMsg, e);
			System.err.println(errorMsg);
			System.exit(-1);
		}
	}
}
