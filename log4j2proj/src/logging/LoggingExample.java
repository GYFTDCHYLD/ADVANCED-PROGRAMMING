package logging;
// Import log4j packages/library
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {
	// Create Logger object and use the LogManager to get and assign the 
	//object a logger for the CLASS it is logging for
	private static final Logger logger = LogManager.getLogger(LoggingExample.class);

	public static void main(String[] args) {
		// Use the log object to log messages to the console
		logger.info("Test Info message");
		logger.debug("Test Debug message");
		logger.error("Test Error message");
		logger.trace("Test Trace message");
		logger.fatal("Test Fatal message");
		logger.warn("Test Warning message");
	}

}
