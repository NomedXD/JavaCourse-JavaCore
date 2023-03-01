package by.teachmeskills.homeworks.hw_03032023.task1.Hands;

public class SumsungHandClass implements IHand {
    private final int price;

    public SumsungHandClass(int price) {
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
