package by.teachmeskills.homeworks.hw_03032023.task1.Heads;

public class SumsungHeadClass implements IHead {
    private final int price;

    public SumsungHeadClass(int price) {
        this.price = price;
    }

    @Override
    public void speek() {
        System.out.println("Голова Sumsung говорит");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
