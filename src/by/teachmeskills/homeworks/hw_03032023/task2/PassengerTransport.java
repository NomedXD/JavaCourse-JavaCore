package by.teachmeskills.homeworks.hw_03032023.task2;

public class PassengerTransport extends GroundTransport {
    private carType typeCar;
    private int passengerCount;

    public PassengerTransport(int power, int maxSpeed, int mass, int wheelNums, int fuelPer100, int passengerCount, carType typecar, Type type) {
        super(power, maxSpeed, mass, wheelNums, fuelPer100, type);
        this.passengerCount = passengerCount;
        this.typeCar = typecar;
    }

    public carType getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(carType typeCar) {
        this.typeCar = typeCar;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public enum carType {
        SEDAN("Седан"),
        ESTATE("Универсал"),
        COUPE("Купе");

        String type;

        carType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    @Override
    protected void printAll() {
        System.out.printf("Все характеристики легкового транспорта: мощность = %d; макс.скорость = %d; масса = %d\n", power, maxSpeed, mass);
        System.out.printf("Количество колес = %d; расход топлива на 100 км = %d; количество пассажиров = %d\n", weelNums, fuelPer100, passengerCount);
        System.out.printf("Марка транспорта = %s; тип автомобиля = %s; мощность в кВт = %f\n\n", type, typeCar, countPower());
    }

    private float howLongDrive(float time) {
        return maxSpeed * time;
    }

    private float howManyFuel(float time) {
        return howLongDrive(time) * fuelPer100;
    }

    public void howLongDrivePrint(float time) {
        System.out.printf("За время %.2f ч., автомобиль %s, двигаясь с максимальной скоростью %d км/ч проедет %.2f км. и израсходует %.2f литров топлива\n", time, type, maxSpeed, howLongDrive(time), howManyFuel(time));
    }

}
