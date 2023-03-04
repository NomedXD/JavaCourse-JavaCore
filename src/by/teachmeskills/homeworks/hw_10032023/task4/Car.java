package by.teachmeskills.homeworks.hw_10032023.task4;

import by.teachmeskills.homeworks.hw_10032023.Task1.Main;

public class Car {
    private CarBrandType carBrand;
    private int carSpeed;
    private int carCost;

    public Car(CarBrandType carBrand, int carSpeed, int carCost) {
        this.carBrand = carBrand;
        this.carSpeed = carSpeed;
        this.carCost = carCost;
    }

    // Конструктор по умолчанию:
    public Car() {

    }

    public CarBrandType getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrandType carBrand) {
        this.carBrand = carBrand;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }

    public int getCarCost() {
        return carCost;
    }

    public void setCarCost(int carCost) {
        this.carCost = carCost;
    }

    public enum CarBrandType {
        BMW("Bmw"),
        AUDI("Audi"),
        FERRARI("Ferrari");
        private final String str;

        CarBrandType(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    public void start() throws CarStartException {
        if ((int) (Math.random() * 21) % 2 == 0) {
            throw new CarStartException("Машина не завелась, ей крышка");
        } else System.out.println("Машина завелась");
    }

}
