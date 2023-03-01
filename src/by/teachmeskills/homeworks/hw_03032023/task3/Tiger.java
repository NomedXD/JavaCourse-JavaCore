package by.teachmeskills.homeworks.hw_03032023.task3;

public class Tiger extends Feline {
    @Override
    protected void printall() {
        System.out.printf("Все характеристики тигра: картинка - %s; голоден - %s; тип пищи - %s; координаты - %s; размеры - %s\n", picture, hunger, foodType, location.toString(), boundaries.toString());
    }

    public Tiger(String picture, boolean hunger, FoodType foodType) {
        super(picture, hunger, foodType);
    }

    @Override
    protected void makeNoise() {
        System.out.println("Тигр рычит");
    }

    @Override
    protected void eat() {
        System.out.println("Тигр есть мясо");
    }
}
