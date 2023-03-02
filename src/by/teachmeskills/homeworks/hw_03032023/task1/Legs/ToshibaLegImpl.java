package by.teachmeskills.homeworks.hw_03032023.task1.Legs;

public class ToshibaLegImpl implements ILeg {
    private final int price;

    public ToshibaLegImpl(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Идет нога Toshiba");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
