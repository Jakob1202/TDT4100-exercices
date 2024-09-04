package oving7;

public class TrainCar {
    private int deadWeight;
    private int totalWeight;
    
    /**
     * Constructor for train car
     * 
     * @param deadWeight the deadweight to this train car
     */
    public TrainCar(int deadWeight) {
        if (deadWeight <= 0) {
            throw new IllegalArgumentException("The dead weight to this train car cannot be zero or negative");
        } else {
            this.deadWeight = deadWeight;
            this.totalWeight = deadWeight;
        }
    }

    /**
     * Method to set the total weight to this train car
     * 
     * @return the new total weight
     */
    public void setTotalWeight(int newTotalWeight) {
        this.totalWeight = newTotalWeight;
    }

    /**
     * Method to get the total weight to this train car
     * 
     * @return the total weight
     */
    public int getTotalWeight() {
        return this.totalWeight;
    }
    
    /**
     * Method to set the deadweight weight to this train car
     * 
     * @return the new deadweight
     */
    public void setDeadWeight(int newDeadWeight) {
        if (newDeadWeight <= 0) {
            throw new IllegalArgumentException("The dead weight to this train car cannot be zero or negative");
        } else {
            this.totalWeight += newDeadWeight - this.deadWeight;
            this.deadWeight = newDeadWeight;
        }
    }

    /**
     * Method to get the dead weight to this train car
     * 
     * @return the dead weight
     */
    public int getDeadWeight() {
        return this.deadWeight;
    }
}
