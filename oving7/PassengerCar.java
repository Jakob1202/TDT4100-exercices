package oving7;

public class PassengerCar extends TrainCar {
    private int weightPassenger = 80;
    private int passengerCount;

    /**
     * Constructor for passenger car
     * 
     * @param deadWeight     the deadweight to this passenger car
     * @param passengerCount the passenger count to this passenger car
     */
    public PassengerCar(int deadWeight, int passengerCount) {
        super(deadWeight);
        this.setPassengerCount(passengerCount);
    }

    /**
     * Method to set the passenger count to this train car
     * 
     * @param newPassengerCount the new passenger count
     */
    public void setPassengerCount(int newPassengerCount) {
        if (newPassengerCount < 0) {
            throw new IllegalArgumentException("The passenger car cannot have negative amount of passengers");
        } else {
            this.passengerCount = newPassengerCount;
        }
    }

    /**
     * Method to get the passenger count to this train car
     * 
     * @return the passenger count
     */
    public int getPassengerCount() {
        return this.passengerCount;
    }

    @Override
    public int getTotalWeight() {
        return super.getDeadWeight() + (this.weightPassenger * this.getPassengerCount());
    }

}
