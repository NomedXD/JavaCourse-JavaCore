package by.teachmeskills.homeworks.hw_05052023.semaphore;

import java.util.Map;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread{
    private Semaphore sem;
    private String name;

    public Consumer(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            /*
            Это версия с семафорами, попробую допилить чуть позже :))))
             */
            sem.acquire();
            int waitTime = (int)(Math.random()*8+1);
            System.out.printf("Покупатель %s зашел в магазин и будет выбирать товар %d секунд\n", name, waitTime);
            Thread.sleep(waitTime* 1000L);
            System.out.printf("Покупатель %s вышел из магазина\n", name);
            sem.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
