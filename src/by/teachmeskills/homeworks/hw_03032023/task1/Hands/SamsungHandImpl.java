package by.teachmeskills.homeworks.hw_03032023.task1.Hands;

public class SamsungHandImpl implements IHand {
    private final int price;

    public SamsungHandImpl(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Рука Sumsung поднялась");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
