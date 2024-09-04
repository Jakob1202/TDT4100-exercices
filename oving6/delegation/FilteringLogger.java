package oving6.delegation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringLogger implements ILogger {
    private ILogger logger;
    private List<String> severities;

    /**
     * Constructor for filtering logger
     * 
     * @param logger     the logger
     * @param severities the severities
     */
    public FilteringLogger(ILogger logger, String... severities) {
        this.logger = logger;
        this.severities = new ArrayList<>(Arrays.asList(severities));
    }

    /**
     * Method to check if logging is turned on for the severity to this filtering
     * logger
     * 
     * @param severity the severity
     * @return true if logging is turned on, false otherwise
     */
    public boolean isLogging(String severity) {
        return this.severities.contains(severity);
    }

    /**
     * Metho to turn logging on for the severity to this filtering logger
     * 
     * @param severity the severity
     * @param value    true to turn on logging or false to turn off logging
     */
    public void setIsLogging(String severity, boolean value) {
        if (value && !this.severities.contains(severity)) {
            this.severities.add(severity);
        }

        if (!value && this.severities.contains(severity)) {
            this.severities.remove(severity);
        }
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        if (isLogging(severity)) {
            logger.log(severity, message, exception);
        }
    }
}
