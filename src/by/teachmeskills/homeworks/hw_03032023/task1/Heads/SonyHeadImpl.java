package by.teachmeskills.homeworks.hw_03032023.task1.Heads;

public class SonyHeadImpl implements IHead {
    private final int price;

    public SonyHeadImpl(int price) {
        this.price = price;
    }

    @Override
    public void speek() {
        System.out.println("Голова Sony говорит");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
