package by.teachmeskills.homeworks.hw_10032023.task4;

import by.teachmeskills.homeworks.hw_10032023.task4.exceptions.CarNotStartedException;

public class Run {
    public static void main(String[] args) {
        Car[] cars = {new Car(Car.CarBrandType.BMW, 180, 15000), new Car(), new Car(Car.CarBrandType.FERRARI, 270, 90000)};
        for (Car car : cars) {
            try {
                car.start();
            } catch (CarNotStartedException e) {
                System.out.println(e);
            }
        }
    }
}
