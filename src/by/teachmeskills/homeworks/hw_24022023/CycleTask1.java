package by.teachmeskills.homeworks.hw_24022023;

public class CycleTask1 {
    /*
    Начав тренировки, спортсмен в первый день пробежал 10 км. Каждый день он увеличивал дневную норму
    на 10% нормы предыдущего дня.
    Напишите программу, определяющую какой
    суммарный путь пробежит спортсмен за 7 дней?
     */
    private static float runDefault;

    static {
        runDefault = 10.0f;
    }

    public static void main(String[] args) {
        float norma = runDefault;
        for (int i = 2; i <= 7; i++) {
            norma *= 1.1f;
            runDefault = runDefault + norma;
        }
        System.out.printf("Спортсмен пробежал %4.2f, а последняя норма составила %4.2f", runDefault, norma);
    }
}
