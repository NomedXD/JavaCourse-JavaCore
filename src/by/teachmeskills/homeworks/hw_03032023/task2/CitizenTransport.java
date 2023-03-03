package by.teachmeskills.homeworks.hw_03032023.task2;

public class CitizenTransport extends AirTransport {
    private int passangerCount;
    private boolean business;

    public CitizenTransport(int power, int maxSpeed, int mass, int wings, int minLineLength, int passangerCount, boolean business, Type type) {
        super(power, maxSpeed, mass, wings, minLineLength, type);
        this.passangerCount = passangerCount;
        this.business = business;
    }

    public int getPassangerCount() {
        return passangerCount;
    }

    public void setPassangerCount(int passangerCount) {
        this.passangerCount = passangerCount;
    }

    public boolean isBusiness() {
        return business;
    }

    public void setBusiness(boolean business) {
        this.business = business;
    }

    @Override
    protected void printAll() {
        System.out.printf("Все характеристики гражданского транспорта: мощность = %d; макс.скорость = %d; масса = %d\n", power, maxSpeed, mass);
        System.out.printf("Размах крыльев = %d; минимальная длина взлетно-посадочной полосы = %d; количество пассажиров = %d\n", wings, minLineLength, passangerCount);
        System.out.printf("Является ли бизнесс классом = %s; марка транспорта = %s; мощность в кВт = %f\n\n", business, type, countPower());
    }

    public void checkForCapacity(int passangerCountProc) {
        System.out.println((passangerCountProc > passangerCount) ? "Вам нужен самолет побольше\n\n" : "Самолет загружен\n\n");
    }
}
