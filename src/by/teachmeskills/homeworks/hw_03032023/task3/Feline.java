package by.teachmeskills.homeworks.hw_03032023.task3;

public abstract class Feline extends Animal {
    public Feline(String picture, boolean hunger, FoodType foodType) {
        super(picture, hunger, foodType);
    }

    @Override
    protected void roam() {
        System.out.println("Кошаки живут по-одиночке");
    }
}
