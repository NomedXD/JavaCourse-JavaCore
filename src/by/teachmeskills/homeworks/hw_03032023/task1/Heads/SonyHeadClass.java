package by.teachmeskills.homeworks.hw_03032023.task1.Heads;

import by.teachmeskills.homeworks.hw_03032023.task1.Hands.SonyHandClass;

public class SonyHeadClass implements IHead {
    private final int price;

    public SonyHeadClass(int price) {
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
