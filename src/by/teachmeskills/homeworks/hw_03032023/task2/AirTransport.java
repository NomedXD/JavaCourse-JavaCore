package by.teachmeskills.homeworks.hw_03032023.task2;

public abstract class AirTransport extends Transport {
    protected int wings;
    protected int minLineLength;

    public AirTransport(int power, int maxSpeed, int mass, int wings, int minLineLength, Type type) {
        super(power, maxSpeed, mass, type);
        this.wings = wings;
        this.minLineLength = minLineLength;
    }
}
