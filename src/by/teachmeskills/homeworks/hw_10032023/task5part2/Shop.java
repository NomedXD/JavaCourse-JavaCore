package by.teachmeskills.homeworks.hw_10032023.task5part2;

import by.teachmeskills.homeworks.hw_10032023.task5part2.exceptions.EmptyProductListException;
import by.teachmeskills.homeworks.hw_10032023.task5part2.exceptions.EntityAlreadyExistsException;
import by.teachmeskills.homeworks.hw_10032023.task5part2.exceptions.EntityNotFoundException;

import java.util.Arrays;
import java.util.Scanner;

public class Shop {
    private Product[] products;
    private int currentIndex;

    {
        currentIndex = 0;
        products = new Product[100];
    }

    public Shop(){

    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void addProduct(Product product) throws EntityAlreadyExistsException {
        for (int i = 0; i < getCurrentIndex(); i++) {
            if (products[i].getId() == product.getId()) {
                throw new EntityAlreadyExistsException("The product exists");
            }
        }
        products[getCurrentIndex()] = product;
        setCurrentIndex(getCurrentIndex() + 1);
        System.out.println("The product was added successfully");
    }

    public void getAllProducts() throws EmptyProductListException {
        if (getCurrentIndex() == 0)
            throw new EmptyProductListException("No products found");
        Product[] temp = new Product[getCurrentIndex()];
        System.arraycopy(products, 0, temp, 0, getCurrentIndex()); // Чтобы не сортировать основной массив
        // Переопределил compareTo
        System.out.println("Input sorting direction\n1 - direct order by price(by default)\n2 - reverse order by price");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        ProductPriceComparator priceComparator = new ProductPriceComparator();
        if ((option == 2)) {
            Arrays.sort(temp, priceComparator.reversed());
        } else {
            Arrays.sort(temp, priceComparator);
        }
        System.out.println("Sorted shop:");
        for (Product product : temp) {
            System.out.printf("Id = %d; name = %s; price = %d\n", product.getId(), product.getName(), product.getPrice());
        }
    }

    public void removeProduct(int itemId) throws EmptyProductListException, EntityNotFoundException {
        if (getCurrentIndex() == 0)
            throw new EmptyProductListException("No products found");
        int key = searchById(itemId);
        if (key == -1)
            throw new EntityNotFoundException("Product with id = " + itemId + " not found");
        for (int i = key; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        setCurrentIndex(getCurrentIndex() - 1);
    }

    public void changeProduct(int itemId) throws EmptyProductListException, EntityNotFoundException {
        if (getCurrentIndex() == 0)
            throw new EmptyProductListException("No products found");
        int key = searchById(itemId);
        if (key == -1)
            throw new EntityNotFoundException("Product with id = " + itemId + " not found");
        Scanner in = new Scanner(System.in);
        System.out.println("Input new id");
        products[key].setId(in.nextInt());
        in.nextLine();
        System.out.println("Input new name");
        products[key].setName(in.nextLine());
        System.out.println("Input new price");
        products[key].setPrice(in.nextInt());
    }

    private int searchById(int itemId) {
        for (int i = 0; i < getCurrentIndex(); i++) {
            if (products[i].getId() == itemId)
                return i;
        }
        return -1;
    }
}
