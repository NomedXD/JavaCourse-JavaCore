package by.teachmeskills.homeworks.hw_03032023.task2;

public class TruckTransport extends GroundTransport {
    int carringWeight;

    public TruckTransport(int power, int maxSpeed, int mass, int wheelNums, int fuelPer100, int carringWeight, Type type) {
        super(power, maxSpeed, mass, wheelNums, fuelPer100, type);
        this.carringWeight = carringWeight;
    }

    @Override
    protected void printAll() {
        System.out.printf("Все характеристики легкового транспорта: мощность = %d; макс.скорость = %d; масса = %d\n", power, maxSpeed, mass);
        System.out.printf("Количество колес = %d; расход топлива на 100 км = %d; грузоподъемность = %d\n", weelNums, fuelPer100, carringWeight);
        System.out.printf("Марка транспорта = %s; мощность в кВт = %f\n\n", type, countPower());
    }

    void checkForCapacity(int weight) {
        System.out.println((weight > carringWeight) ? "Вам нужен грузовик побольше\n" : "Грузовик загружен\n");
    }
}
