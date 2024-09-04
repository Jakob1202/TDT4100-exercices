package oving2;

import java.util.ArrayList;
import java.util.Arrays;

public class Vehicle {
    private char vehicleType;
    private char fuelType;
    private String registrationNumber;
    private ArrayList<String> vehicleTypes = new ArrayList<>(Arrays.asList("M", "C"));
    private ArrayList<String> fuelTypes = new ArrayList<>(Arrays.asList("H", "E", "D", "G"));

    /**
     * Constructor for vehicle
     * 
     * @param vehicleType        the type to this vehiche
     * @param fuelType           the fule type to this vehicle
     * @param registrationNumber the registration number to this vehicle
     */
    public Vehicle(char vehicleType, char fuelType, String registrationNumber) {
        if (vehicleTypes.contains(String.valueOf(vehicleType)) && fuelTypes.contains(String.valueOf(fuelType))
                && checkRegistrationNumber(vehicleType, fuelType, registrationNumber)) {
            this.vehicleType = vehicleType;
            this.fuelType = fuelType;
            this.registrationNumber = registrationNumber;
        } else {
            throw new IllegalArgumentException("");
        }
    }

    /**
     * Method to validate the registration number to this vehicle
     * 
     * @param vehicleType        the type to this vehiche
     * @param fuelType           the fule type to this vehicle
     * @param registrationNumber the registration number to this vehicle
     * @return true if the registration number is valid, false otherwise
     */
    public boolean checkRegistrationNumber(char vehicleType, char fuelType, String registrationNumber) {
        if (!registrationNumber.substring(0, 2).matches("[A-Z]+")
                || !registrationNumber.substring(2).matches("[0-9]+")) {
            return false;
        }

        if (vehicleType == 'M' && registrationNumber.substring(0, 2).equals("HY")) {
            return false;
        }

        if (registrationNumber.contains("Æ") || registrationNumber.contains("Ø") || registrationNumber.contains("Å")) {
            return false;
        }

        if ((vehicleType == 'M' && registrationNumber.length() != 6)
                || (vehicleType == 'C' && registrationNumber.length() != 7)) {
            return false;
        }

        if (fuelType == 'E' && (!registrationNumber.substring(0, 2).equals("EL")
                && !registrationNumber.substring(0, 2).equals("EK"))) {
            return false;
        }

        if (fuelType == 'H' && !registrationNumber.substring(0, 2).equals("HY")) {
            return false;
        }

        if ((fuelType == 'D' || fuelType == 'G')
                && (registrationNumber.substring(0, 2).equals("EK") || registrationNumber.substring(0, 2).equals("EL")
                        || registrationNumber.substring(0, 2).equals("HY"))) {
            return false;
        }

        return true;
    }

    /**
     * Method to set the new registration number to this vehicle
     * 
     * @param newRegistrationnumer the new registration number
     */
    public void setRegistrationNumber(String newRegistrationnumer) {
        if (checkRegistrationNumber(this.vehicleType, this.fuelType, newRegistrationnumer)) {
            this.registrationNumber = newRegistrationnumer;
        } else {
            throw new IllegalArgumentException("");
        }
    }

    /**
     * Method to get the vehicle type to this vehicle
     * 
     * @return the vehicle type
     */
    public char getVehicleType() {
        return this.vehicleType;
    }

    /**
     * Method to get the fuel type to this vehicle
     * 
     * @return the fuel type
     */
    public char getFuelType() {
        return this.fuelType;
    }

    /**
     * Method to get the registration number to this vehicle
     * 
     * @return the registration number
     */
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle('M', 'E', "EL1234");
    }
}
