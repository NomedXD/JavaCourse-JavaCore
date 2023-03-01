package by.teachmeskills.homeworks.hw_03032023.task1.Hands;

import by.teachmeskills.homeworks.hw_03032023.task1.Heads.IHead;

public class SonyHandClass implements IHand {
    private final int price;

    public SonyHandClass(int price) {
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
