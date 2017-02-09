package com.calculator.exceptions;

public class CalculatorException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3405458513836101512L;

	public CalculatorException() {
        super();
    }

    public CalculatorException(final String message, final Throwable cause,
            final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CalculatorException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CalculatorException(final String message) {
        super(message);
    }

    public CalculatorException(final Throwable cause) {
        super(cause);
    }

}
