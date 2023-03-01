package by.teachmeskills.homeworks.hw_03032023.task3;

public class Lion extends Feline {

    public Lion(String picture, boolean hunger, FoodType foodType) {
        super(picture, hunger, foodType);
    }

    @Override
    protected void printall() {
        System.out.printf("Все характеристики льва: картинка - %s; голоден - %s; тип пищи - %s; координаты - %s; размеры - %s\n", picture, hunger, foodType, location.toString(), boundaries.toString());
    }

    @Override
    protected void makeNoise() {
        System.out.println("Лев рычит");
    }

    @Override
    protected void eat() {
        System.out.println("Лев ест мясо");
    }
}
