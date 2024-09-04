package oving7;

import java.util.ArrayList;

public class Train {
    private ArrayList<TrainCar> trainCars;

    /**
     * Constructor for train
     */
    public Train() {
        this.trainCars = new ArrayList<>();
    }

    /**
     * Method to add a train car to this train
     * 
     * @param trainCar the train card
     */
    public void addTrainCar(TrainCar trainCar) {
        if (this.trainCars.contains(trainCar)) {
            throw new IllegalArgumentException("The train car is already in the train");
        } else {
            this.trainCars.add(trainCar);
        }
    }

    /**
     * Method to check if this train contains a train car
     * 
     * @param trainCar the train car
     * @return true if this train contains train car, false otherwise
     */
    public boolean contains(TrainCar trainCar) {
        return this.trainCars.contains(trainCar);
    }

    /**
     * Method to get the total weight to this train
     * 
     * @return the total weight
     */
    public int getTotalWeight() {
        return this.trainCars.stream().mapToInt(TrainCar -> TrainCar.getTotalWeight()).sum();
    }

    /**
     * Method to get the passenger count to this train
     * 
     * @return the passenger count
     */
    public int getPassengerCount() {
        return this.trainCars.stream()
                .filter(TrainCar -> TrainCar instanceof PassengerCar)
                .mapToInt(PassengerCar -> ((PassengerCar) PassengerCar).getPassengerCount())
                .sum();
    }

    /**
     * Method to get the cargo weight to this train
     * 
     * @return the cargo weight
     */
    public int getCargoWeight() {
        return this.trainCars.stream()
                .filter(TrainCar -> TrainCar instanceof CargoCar)
                .mapToInt(CargoCar -> ((CargoCar) CargoCar).getCargoWeight())
                .sum();
    }
}
