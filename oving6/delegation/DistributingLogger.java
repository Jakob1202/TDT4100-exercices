package oving6.delegation;

import java.util.HashMap;
import java.util.Map;

public class DistributingLogger implements ILogger {
    private Map<String, ILogger> loggers;

    /**
     * Constructor for distributing logger
     * 
     * @param errorLogger   the logger for messages with severity ERROR
     * @param warningLogger the logger for messages with severity WARNING
     * @param infoLogger    the logger for messages with severity INFO
     */
    public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
        this.loggers = new HashMap<>();
        this.loggers.put(ILogger.ERROR, errorLogger);
        this.loggers.put(ILogger.WARNING, warningLogger);
        this.loggers.put(ILogger.INFO, infoLogger);
    }

    /**
     * Method to set a logger for a severity
     * 
     * @param severity the severity
     * @param logger   the severity
     */
    public void setLogger(String severity, ILogger logger) {
        if (this.loggers.containsKey(severity)) {
            this.loggers.remove(severity);
            this.loggers.put(severity, logger);

        } else {
            this.loggers.put(severity, logger);
        }
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        ILogger logger = loggers.get(severity);
        logger.log(severity, message, exception);
    }

}
