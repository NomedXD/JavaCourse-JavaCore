package by.teachmeskills.homeworks.hw_17032023.task3;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Run {
    private static final String ROOT = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\task3\\files\\";
    // Если что, это все Есенин :)
    // В этом задании решил поработать с посимвольным считыванием из файла
    // Хотел как-то "запикать" их, но тогда с разделением на слова через split(regEx) проблемы
    public static void main(String[] args) throws IOException {
        CensorshipChecker.censorCheck();
    }
}
