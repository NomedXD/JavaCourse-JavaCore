package by.teachmeskills.homeworks.hw_03032023.task3;

public abstract class Canine extends Animal {
    public Canine(String picture, boolean hunger, FoodType foodType) {
        super(picture, hunger, foodType);
    }

    @Override
    protected void roam() {
        System.out.println("Волчьи живут в стае");
    }
}
