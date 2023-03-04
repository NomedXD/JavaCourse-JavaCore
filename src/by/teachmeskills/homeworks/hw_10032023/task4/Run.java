package by.teachmeskills.homeworks.hw_10032023.task4;

public class Run {
    public static void main(String[] args) {
        Car[] cars = {new Car(Car.CarBrandType.BMW, 180, 15000), new Car(), new Car(Car.CarBrandType.FERRARI, 270, 90000)};
        for (Car car : cars) {
            try {
                car.start();
            } catch (CarStartException e) {
                System.out.println(e);
            }
        }
    }
}
