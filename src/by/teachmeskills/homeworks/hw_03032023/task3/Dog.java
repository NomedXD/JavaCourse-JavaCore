package by.teachmeskills.homeworks.hw_03032023.task3;

public class Dog extends Canine {
    public Dog(String picture, boolean hunger, FoodType foodType) {
        super(picture, hunger, foodType);
    }

    @Override
    protected void printall() {
        System.out.printf("Все характеристики собаки: картинка - %s; голоден - %s; тип пищи - %s; координаты - %s; размеры - %s\n", picture, hunger, foodType, location.toString(), boundaries.toString());
    }

    @Override
    protected void makeNoise() {
        System.out.println("Собака лает");
    }

    @Override
    protected void eat() {
        System.out.println("Собака грызет кость");
    }
}

