package by.teachmeskills.homeworks.hw_03032023.task3;

public class Wolf extends Canine {
    public Wolf(String picture, boolean hunger, FoodType foodType) {
        super(picture, hunger, foodType);
    }

    @Override
    protected void printAll() {
        System.out.printf("Все характеристики волка: картинка - %s; голоден - %s; тип пищи - %s; координаты - %s; размеры - %s\n", picture, hunger, foodType, location.toString(), boundaries.toString());
    }

    @Override
    protected void makeNoise() {
        System.out.println("Волг воет");
    }

    @Override
    protected void eat() {
        System.out.println("Волк есть зайца");
    }
}
