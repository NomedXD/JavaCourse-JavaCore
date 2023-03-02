package by.teachmeskills.homeworks.hw_03032023.task1.Hands;

public class SonyHandImpl implements IHand {
    private final int price;

    public SonyHandImpl(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Рука Sony поднялась");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
