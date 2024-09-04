package oving6.delegation;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger {
    private String logMessage;
    private String format = "%s: %s (%s)";
    private OutputStream stream;

    /**
     * Constructor for this stream logger
     * @param stream
     */
    public StreamLogger(OutputStream stream) {
        this.stream = stream;
    }
    /**
     * Method to set the format string to this stream logger
     * @param formatString the format string
     */
    public void setFormatString(String formatString) {
        this.format = formatString;
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        logMessage = String.format(format, severity, message, exception);
        try {
            stream.write(logMessage.getBytes());
        } catch (IOException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }
}
