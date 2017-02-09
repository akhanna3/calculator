package com.calculator.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;

import com.calculator.exceptions.CalculatorException;

public final class MathUtils {

	/** Class Logger */
	private static Logger logger = LogUtils.getLogger(MathUtils.class.getCanonicalName().toUpperCase());

	/**
	 * Apply an operation on the two operable's. If operation is not one of
	 * these '+', '-', '*' or '/' then exception is thrown
	 * 
	 * @param ops
	 *            Operation
	 * @param a
	 *            Operable 1
	 * @param b
	 *            Operable 2
	 * @return Result
	 * @throws CalculatorException
	 */
	public final static Integer applyOperation(final Character ops, final Integer a, final Integer b)
			throws CalculatorException {

		if (StringUtils.isBlank(ops.toString())) {
			throw new CalculatorException("Failed to calculate operation due to: Operation cannot be NULL or EMPTY");
		}

		logger.info("Applying operation '{}' on '{}' and '{}'", ops, a, b);
		switch (ops) {
		case '+':
			return add(a, b);
		case '-':
			return subtract(a, b);
		case '*':
			return multiply(a, b);
		case '/':
			return divide(a, b);
		default:
			throw new CalculatorException("Operation " + ops + " not supported");
		}
	}

	/**
	 * Add two integers
	 * 
	 * @param a
	 *            Operable 1
	 * @param b
	 *            Operable 2
	 * @return Result
	 */
	public final static Integer add(final int a, final int b) {
		logger.trace("Adding '{}' and '{}'", a, b);
		return a + b;
	}

	/**
	 * Subtract two integers
	 * 
	 * @param a
	 *            Operable 1
	 * @param b
	 *            Operable 2
	 * @return Result
	 */
	public final static Integer subtract(final int a, final int b) {
		logger.trace("Subtracting '{}' and '{}'", a, b);
		return a - b;
	}

	/**
	 * Multiple two integers
	 * 
	 * @param a
	 *            Operable 1
	 * @param b
	 *            Operable 2
	 * @return Result
	 */
	public final static Integer multiply(final int a, final int b) {
		logger.trace("Multiplying '{}' and '{}'", a, b);
		return a * b;
	}

	/**
	 * Divide two integers. If second operable is zero then exception thrown.
	 *
	 * @param a
	 *            Operable 1
	 * @param b
	 *            Operable 2
	 * @return Result
	 * @throws CalculatorException
	 */
	public final static Integer divide(final int a, final int b) throws CalculatorException {
		if (b == 0)
			throw new CalculatorException("Invalid Operation. Cannot divide by zero.");
		logger.trace("Dividing '{}' and '{}'", a, b);
		return a / b;
	}
}
