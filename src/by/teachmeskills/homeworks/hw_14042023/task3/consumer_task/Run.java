package by.teachmeskills.homeworks.hw_14042023.task3.consumer_task;

import java.util.function.Consumer;

public class Run {
    private static class HeavyBox {
        private final int weight;

        private HeavyBox(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        HeavyBox box = new HeavyBox(12);
        Consumer<HeavyBox> lambdaShip = s -> System.out.printf("Отгрузили ящик с весом %d ", s.weight);
        Consumer<HeavyBox> lambdaSend = s -> System.out.printf("Отправляем ящик с весом %d", s.weight);
        lambdaShip.andThen(lambdaSend).accept(box);
    }
}
