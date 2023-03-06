package by.teachmeskills.homeworks.hw_10032023.Task1;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private enum Letters {
        A, B, C, D, E, F, G,
        H, I, J, K, L, M, N,
        O, P, Q, R, S, T, U,
        V, W, X, Y, Z;
    }

    public static void main(String[] args) {
        System.out.println("Введите букву");
        Scanner in = new Scanner(System.in);
        String let = in.nextLine();
        for (Letters obj : Letters.values()) {
            if (Objects.equals(obj.toString(), let) || Objects.equals(obj.toString(), let.toUpperCase())) {
                System.out.println(obj.ordinal() + 1);
                break;
            }
        }
    }
}
