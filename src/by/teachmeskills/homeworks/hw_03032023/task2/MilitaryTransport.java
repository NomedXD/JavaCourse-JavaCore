package by.teachmeskills.homeworks.hw_03032023.task2;

public class MilitaryTransport extends AirTransport {
    private boolean catapultSystem;
    private int rocketNum;

    public MilitaryTransport(int power, int maxSpeed, int mass, int wings, int minLineLength, boolean catapultSystem, int rocketNum, Type type) {
        super(power, maxSpeed, mass, wings, minLineLength, type);
        this.catapultSystem = catapultSystem;
        this.rocketNum = rocketNum;
    }

    @Override
    protected void printAll() {
        System.out.printf("Все характеристики военного транспорта: мощность = %d; макс.скорость = %d; масса = %d\n", power, maxSpeed, mass);
        System.out.printf("Размах крыльев = %d; минимальная длина взлетно-посадочной полосы = %d; наличие системы катапультирования = %s\n", wings, minLineLength, catapultSystem);
        System.out.printf("Количество ракет на борту = %d; марка транспорта = %s; мощность в кВт = %f\n\n", rocketNum, type, countPower());
    }

    void checkForShoot() {
        System.out.println((rocketNum != 0) ? "Ракета пошла\n" : "Боеприпасы отсутствуют\n");
    }

    void checkForCatapultSystem() {
        System.out.println((catapultSystem) ? "Катапультирование прошло успешно\n" : "У вас нет такой системы, вам крышка\n");
    }
}
