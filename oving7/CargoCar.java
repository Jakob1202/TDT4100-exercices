package oving7;

public class CargoCar extends TrainCar {
    private int cargoWeight;
    /**
     * Constructor for cargo car
     * 
     * @param deadWeight  the deadweight to this cargo car
     * @param cargoWeight the cargoweight to this cargo car
     */
    public CargoCar(int deadWeight, int cargoWeight) {
        super(deadWeight);
        this.setCargoWeight(cargoWeight);
    }


    /**
     * Method to set the cargo weight to this train car
     * 
     * @param newCargoWeight new cargo weight
     */
    public void setCargoWeight(int newCargoWeight) {
        if (newCargoWeight <= 0) {
            throw new IllegalArgumentException("The new total weight to this train car cannot be zero or negative");
        } else {
            this.cargoWeight = newCargoWeight;
        }
    }

    /**
     * Method to get the cargo weight to this train car
     * 
     * @return the cargo weight
     */
    public int getCargoWeight() {
        return this.cargoWeight;
    }

    @Override
    public int getTotalWeight() {
        return super.getDeadWeight() + this.getCargoWeight();
    }
}
