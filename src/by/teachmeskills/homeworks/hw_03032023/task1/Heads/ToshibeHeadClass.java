package by.teachmeskills.homeworks.hw_03032023.task1.Heads;

public class ToshibeHeadClass implements IHead{
    private final int price;
    public ToshibeHeadClass(int price){
        this.price=price;
    }
    @Override
    public void speek() {
        System.out.println("Голова Toshiba говорит");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
