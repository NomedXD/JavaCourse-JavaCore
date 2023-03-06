package by.teachmeskills.homeworks.hw_10032023.task5part2;

import by.teachmeskills.homeworks.hw_10032023.task5part2.exceptions.EmptyProductListException;
import by.teachmeskills.homeworks.hw_10032023.task5part2.exceptions.EntityAlreadyExistsException;
import by.teachmeskills.homeworks.hw_10032023.task5part2.exceptions.EntityNotFoundException;

import java.util.Scanner;

public class ApplicationMenu {
    public ApplicationMenu(){

    }
    public void start(){
        Shop shop = new Shop();
        int option;
        boolean exitFlag=true;
        Scanner in = new Scanner(System.in);
        while(exitFlag){
            System.out.println("Input shop option\n1 - Display all products\n2 - Add one product\n3 - Remove one product\n4 - Change one product\n5 - Exit");
            switch (in.nextInt()){
                case 1:{
                    try {
                        shop.getAllProducts();
                    } catch (EmptyProductListException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2:{
                    System.out.println("Input product id");
                    int idTemp =  in.nextInt();
                    in.nextLine();
                    System.out.println("Input product name");
                    String nameTemp = in.nextLine();
                    System.out.println("Input product price");
                    int priceTemp = in.nextInt();
                    try {
                        shop.addProduct(new Product(idTemp,nameTemp,priceTemp));
                    } catch (EntityAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3:{
                    System.out.println("Input product id to remove");
                    try {
                        shop.removeProduct(in.nextInt());
                    } catch (EmptyProductListException | EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4:{
                    System.out.println("Input product id to change");
                    try {
                        shop.changeProduct(in.nextInt());
                    } catch (EmptyProductListException | EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: exitFlag = false; break;
            }
        }
    }
}
