package by.teachmeskills.homeworks.hw_03032023.task2;

public abstract class Transport {

    protected int power;
    protected int maxSpeed;
    protected int mass;
    protected Type type;

    public Transport(int power, int maxSpeed, int mass, Type type) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.mass = mass;
        this.type = type;
    }

    protected enum Type {
        AUDI("Audi"),
        BMW("BMW"),
        BOING("Boing"),
        AIRBUS("Airbus"),
        SCANIA("Scania"),
        MAZ("MAZ");

        Type(String brand) {
            this.brand = brand;
        }

        private final String brand;

        public String toString() {
            return brand;
        }

    }

    protected abstract void printAll();

    protected float countPower() {
        return this.power * 0.74f;
    }

}
