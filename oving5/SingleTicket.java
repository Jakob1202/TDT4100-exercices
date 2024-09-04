package oving5;

public class SingleTicket implements Ticket {

    private boolean scannedTicket = false;

    /**
     * Method to scan this singe ticket
     * 
     * @return true the first time this ticked has been scanned, false otherwise
     */
    @Override
    public boolean scan() {
        if (this.scannedTicket) {
            return false;
        } else {
            this.scannedTicket = true;
            return true;
        }
    }

}
