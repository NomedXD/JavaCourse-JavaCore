package by.teachmeskills.homeworks.codewarstasks.FromRGBToHEX;

import java.util.Scanner;

public class FromRGBToHEX {
    public static void main(String[] args) {
        System.out.print("Введите число R\n");
        Scanner in = new Scanner(System.in);
        int inNum1 = in.nextInt();
        System.out.print("Введите число G\n");
        int inNum2 = in.nextInt();
        System.out.print("Введите число B\n");
        int inNum3 = in.nextInt();
        System.out.println(rgb(inNum1, inNum2, inNum3));
    }

    private static String rgb(int r, int g, int b) {
        int[] arr = new int[]{r, g, b};
        String strRes = "";
        for (int i : arr) {
            if (i < 0)
                i = 0;
            if (i > 255)
                i = 255;
            StringBuffer res = new StringBuffer();
            if (i < 16) {
                switch (i) {
                    case 0:
                        strRes += "00";
                        break;
                    case 1, 2, 3, 4, 5, 6, 7, 8, 9:
                        strRes += "0" + Integer.toString(i);
                        break;
                    case 10:
                        strRes += "0A";
                        break;
                    case 11:
                        strRes += "0B";
                        break;
                    case 12:
                        strRes += "0C";
                        break;
                    case 13:
                        strRes += "0D";
                        break;
                    case 14:
                        strRes += "0E";
                        break;
                    case 15:
                        strRes += "0F";
                        break;
                }

            } else
                while (i > 0) {
                    int ost = i % 16;
                    i /= 16;
                    switch (ost) {
                        case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9:
                            res.insert(0, ost);
                            break;
                        case 10:
                            res.insert(0, 'A');
                            break;
                        case 11:
                            res.insert(0, 'B');
                            break;
                        case 12:
                            res.insert(0, 'C');
                            break;
                        case 13:
                            res.insert(0, 'D');
                            break;
                        case 14:
                            res.insert(0, 'E');
                            break;
                        case 15:
                            res.insert(0, 'F');
                            break;
                    }


                }
            strRes += res.toString();
        }
        return strRes;
    }
}
