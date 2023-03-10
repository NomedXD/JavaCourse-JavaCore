package by.teachmeskills.homeworks.hw_17032023.task4;

import java.io.*;

public class Run {
    private static final String ROOT = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\task4\\";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Car car1 = new Car("Ferrari",320,100000);
        System.out.println(car1);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ROOT+"save.ser"));
        objectOutputStream.writeObject(car1);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ROOT+"save.ser"));
        Car car2 = (Car) objectInputStream.readObject();
        System.out.println(car2);
    }
}

