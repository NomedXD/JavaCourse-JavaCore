package by.teachmeskills.homeworks.hw_03032023.task1.Legs;

public class SonyLegImpl implements ILeg {
    private final int price;

    public SonyLegImpl(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Идет нога Sony");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
