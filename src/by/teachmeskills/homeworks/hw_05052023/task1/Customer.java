package by.teachmeskills.homeworks.hw_05052023.task1;

import java.util.concurrent.Callable;

public class Customer implements Callable<Integer> {
    private final String name;
    private final GameShop shop;

    Customer(String name, GameShop shop) {
        this.name = name;
        this.shop = shop;
    }

    public void enterShop() {
        System.out.println("Покупатель " + name + " стоит в очереди на вход");
        try {
            while (!shop.addCustomer(this)) {
                Thread.sleep(2000);
                System.out.println("Покупатель " + name + " ждет загрузку сайта :)");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Покупатель " + name + " зашел на сайт магазина");
    }


    public int buyProduct() {
        try {
            Thread.sleep((int) (Math.random() * 8000) + 1000);
            Product item = shop.removeItem();
            System.out.println("Покупатель " + name + " купил " + item.name() + " за " + item.cost());
            return item.cost();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void leaveShop() {
        shop.removeCustomer(this);
        System.out.println("Покупатель " + name + " вышел с сайта");
    }

    @Override
    public Integer call() {
        enterShop();
        int boughtItemPrice = buyProduct();
        leaveShop();
        return boughtItemPrice;
    }
}
