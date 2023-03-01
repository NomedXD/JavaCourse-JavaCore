package by.teachmeskills.homeworks.hw_03032023.task1.Legs;

public class SumsungLegClass implements ILeg{
    private final int price;
    public SumsungLegClass(int price){
        this.price=price;
    }
    @Override
    public void step() {
        System.out.println("Идет нога Sumsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
