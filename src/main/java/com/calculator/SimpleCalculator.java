package com.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;

import com.calculator.exceptions.CalculatorException;
import com.calculator.utils.LogUtils;
import com.calculator.utils.MathUtils;

/**
 * This class simulates basic functions of a calculator.
 * 
 * @author akhanna
 *
 */
public final class SimpleCalculator {

	/** Class Logger */
	private static Logger logger = LogUtils.getLogger(SimpleCalculator.class.getCanonicalName().toUpperCase());

	/** Stack to hold the operable's */
	private Stack<Integer> operables = new Stack<Integer>();

	/** Stack to hold the operations */
	private Stack<Character> ops = new Stack<Character>();

	public void run(InputStream input, PrintStream consoleOutput) throws CalculatorException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String expression = null;

		try {
			while (true) {
				// Clear stack from last operation.
				operables.clear();
				ops.clear();
				System.out.printf("Calculator>");
				expression = reader.readLine();

				if (expression == null) {
					break;
				}

				expression.trim();
				try {
					consoleOutput.println(eval(expression));
				} catch (CalculatorException e) {
					consoleOutput.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			logger.error("Failed to read line: {}", e.getMessage());
			throw new CalculatorException("Failed to read line", e);
		}
	}

	public int eval(final String expression) throws CalculatorException {

		if (StringUtils.isBlank(expression)) {
			throw new CalculatorException("Failed to evaluate expression due to: Expression cannot be NULL or EMPTY");
		}

		logger.debug("Calculating expression: '{}'", expression);

		char[] chars = expression.toCharArray();
		int length = chars.length;
		int a, b = 0;

		try {
			for (int i = 0; i < length; i++) {

				Character token = chars[i];
				logger.trace("Token: '{}'", token);

				// Continue if white space
				if (StringUtils.isWhitespace(token.toString())) {
					continue;
				}

				// Check if the token is a digit
				if (Character.isDigit(token)) {
					StringBuilder number = new StringBuilder();
					try {
						getNumber(chars, i, length, number);
						logger.trace("Got Number: '{}'", number);
						// Incrementing the loop since we went ahead to get the
						// whole digit
						i += number.length() - 1;
						// Push value to the stack
						operables.push(Integer.parseInt(number.toString()));
					} catch (NumberFormatException e) {
						logger.error("Failed to convert string {} to integer", number);
					}
				}

				// Check if token is an operation
				if (token == '+' || token == '-' || token == '*' || token == '/') {
					// Check if there is an operation exist or not and has
					// precedence over this operation
					while (!ops.isEmpty() && hasPrecedence(token, ops.peek())) {
						b = operables.pop();
						a = operables.pop();
						operables.push(MathUtils.applyOperation(ops.pop(), a, b));
					}

					// Push the operation in ops stack
					ops.push(token);
				}

			}

			while (!ops.isEmpty()) {
				if (operables.size() <= 1)
					throw new CalculatorException("Invalid expression");
				else {
					b = operables.pop();
					a = operables.pop();
					operables.push(MathUtils.applyOperation(ops.pop(), a, b));
				}
			}
		} catch (EmptyStackException e) {
			logger.error("Failed to retrieve value from operables or operation stack since it was empty", e);
			throw new CalculatorException("Invalid expresssion", e);
		}

		return operables.pop();
	}

	private boolean hasPrecedence(char op1, char op2) {
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	private void getNumber(char[] chars, int current, int length, StringBuilder number) {

		// Check if we have reached the end of expression or if the next token
		// is not a digit.
		if (current == length || !Character.isDigit(chars[current]))
			return;

		Character token = chars[current];

		// Check if the token is a digit or not.
		if (Character.isDigit(token)) {
			number.append(token);
			getNumber(chars, current + 1, length, number);
		}
	}
}
