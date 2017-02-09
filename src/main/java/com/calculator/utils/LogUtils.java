package com.calculator.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LogUtils {

	/**
	 *
	 * Retrieves a custom logger.
	 *
	 * @param loggerName
	 * @return
	 */
	public static Logger getLogger(String loggerName) {
		return LogManager.getLogger(loggerName);
	}
}
