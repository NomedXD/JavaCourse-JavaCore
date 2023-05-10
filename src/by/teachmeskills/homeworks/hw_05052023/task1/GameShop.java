package by.teachmeskills.homeworks.hw_05052023.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameShop implements Runnable {
    private final String name;
    private boolean isOpenedShop = false;
    private final List<Product> products;
    private final List<Customer> customers = new ArrayList<>();

    public GameShop(String name) {
        this.name = name;
        this.products =  new ArrayList<>(Arrays.asList(new Product("The Witcher 3 : Wild Hunt", 100),
                new Product("CS:GO", 140), new Product("Mortal combat 11", 200),
                new Product("The dark Pictures anthology : The devil in me", 500),
                new Product("Diablo 3", 100),
                new Product("Pure", 135), new Product("DeadIsland 2", 300),
                new Product("Stray Blade", 450), new Product("Evil dead : the game", 300),
                new Product("Heroes of might and magic 3", 1000)));;
    }

    public String getName() {
        return name;
    }

    public synchronized boolean addCustomer(Customer customer) {
        if (customers.size() < 5 && isOpenedShop) {
            customers.add(customer);
            return true;
        }
        return false;
    }

    public synchronized Product removeItem() {
        return products.remove((int) (Math.random() * products.size()));
    }

    public synchronized void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void run() {
        while (products.size() > 0) {
            try {
                Thread.sleep(3400);
                if (customers.size() < 4) {
                    isOpenedShop = false;
                    System.out.println("В магазине технический перерыв 10 секунд :)");
                    Thread.sleep(10000);
                }
                isOpenedShop = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

