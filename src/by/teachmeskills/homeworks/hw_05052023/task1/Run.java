package by.teachmeskills.homeworks.hw_05052023.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {
    private static boolean areAllResultsReady(List<Future<Integer>> results) {
        for (Future<Integer> element : results) {
            if (!element.isDone()) {
                return false;
            }
        }
        return true;
    }

    private static int calculateTotalGain(List<Future<Integer>> results) {
        int result = 0;
        try {
            for (Future<Integer> element : results) {
                result += element.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(15);
        GameShop shop = new GameShop("GabeStore.ru");
        threadPool.execute(shop);
        List<Future<Integer>> purchasesCosts = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            Future<Integer> purchaseCost = threadPool.submit(new Customer("Покупатель " + i, shop));
            purchasesCosts.add(purchaseCost);
        }
        while (!areAllResultsReady(purchasesCosts)) {
            System.out.println("Ожидание результатов...");
            Thread.sleep(5000);
        }
        System.out.println("В итоге куплено: " + calculateTotalGain(purchasesCosts));
        threadPool.shutdown();
    }
}
