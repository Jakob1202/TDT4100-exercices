package oving5;

import java.time.LocalDateTime;

public class PeriodTicket implements Ticket {

    LocalDateTime startTime;
    LocalDateTime endTime;

    /**
     * Constructor for this period ticket
     * 
     * @param startTime the start time to this period ticket
     * @param endTime   the end time to this period ticket
     */
    public PeriodTicket(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time of this period ticket cannot be after the end time ");
        }

        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Method to scan this period ticket
     * 
     * @return true if this period ticket is valid, false otherwise
     */
    @Override
    public boolean scan() {
        if (LocalDateTime.now().isAfter(this.startTime) && LocalDateTime.now().isBefore(this.endTime)) {
            return true;
        } else {
            return false;
        }
    }

}
