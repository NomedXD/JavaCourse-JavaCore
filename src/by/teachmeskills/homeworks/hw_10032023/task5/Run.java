package by.teachmeskills.homeworks.hw_10032023.task5;

import by.teachmeskills.homeworks.hw_10032023.task5.exceptions.EmptyProductListException;
import by.teachmeskills.homeworks.hw_10032023.task5.exceptions.EntityAlreadyExistsException;
import by.teachmeskills.homeworks.hw_10032023.task5.exceptions.EntityNotFoundException;

public class Run {
    public static void main(String[] args) {
        Shop shop = new Shop();
        try {
            shop.addProduct(new Product(56, "Beer", 3));
            shop.addProduct(new Product(12, "Milk", 2));
            shop.addProduct(new Product(99, "popcorn", 4));
            shop.getAllProducts();
            shop.removeProduct(99);
            System.out.print("\n");
            shop.getAllProducts();
            shop.changeProduct(56);
            shop.getAllProducts();
        } catch (EntityAlreadyExistsException | EmptyProductListException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
