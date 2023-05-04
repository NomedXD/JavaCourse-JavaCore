package by.teachmeskills.homeworks.hw_05052023.semaphore;

import by.teachmeskills.homeworks.hw_05052023.semaphore.Consumer;

import java.util.concurrent.Semaphore;

public class Run {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, true);
        new Thread(new Consumer(semaphore, String.valueOf(1))).start();
        new Thread(new Consumer(semaphore, String.valueOf(2))).start();
        new Thread(new Consumer(semaphore, String.valueOf(3))).start();
        try {
            Thread.sleep(2000);
            for (int i = 4; i <= 15; i++) {
                if (semaphore.availablePermits() > 1) {
                    System.out.printf("Магазин закрывается на 10 секунд, " +
                            "так как в нем %d покупателей\n", 5 - semaphore.availablePermits());
                    Thread.sleep(10000);
                    System.out.println("Магазин снова открылся");
                    new Thread(new Consumer(semaphore, String.valueOf(i))).start();
                    Thread.sleep(2000);
                } else {
                    new Thread(new Consumer(semaphore, String.valueOf(i))).start();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
