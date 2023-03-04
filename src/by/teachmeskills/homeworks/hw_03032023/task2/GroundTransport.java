package by.teachmeskills.homeworks.hw_03032023.task2;

public abstract class GroundTransport extends Transport {
    protected int weelNums;
    protected int fuelPer100;

    public GroundTransport(int power, int maxSpeed, int mass, int wheelNums, int fuelPer100, Type type) {
        super(power, maxSpeed, mass, type);
        this.weelNums = wheelNums;
        this.fuelPer100 = fuelPer100;
    }
}
