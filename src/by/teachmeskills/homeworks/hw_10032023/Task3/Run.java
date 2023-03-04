package by.teachmeskills.homeworks.hw_10032023.Task3;

import java.io.FilterOutputStream;
import java.sql.SQLOutput;

public class Run {
    public static void main(String[] args) {
        System.out.println(StringUtils.lastChar("hello"));
        System.out.println(StringUtils.endsWithExclamationMark("hello"));
        System.out.println(StringUtils.endsWithExclamationMark("hello!!!"));
        System.out.println(StringUtils.startWithFazatron("Сиреневенький синх"));
        System.out.println(StringUtils.startWithFazatron("Сиреневенький синхрофазатрон"));
        System.out.println(StringUtils.containsSubString("hello", "ppp"));
        System.out.println(StringUtils.containsSubString("hello", "ello"));
        System.out.println(StringUtils.toUpperCase("hello"));
        System.out.println(StringUtils.toLowerCase("HELLO"));
        System.out.println(StringUtils.mathExpression(5, "/", 2));
        System.out.println(StringUtils.replaceEquals("5 + 19 = 55"));
        System.out.println(StringUtils.retTwoChars("helo", "privet"));
        StringUtils.findPolindroms("Око за око, зуб за зуб");
        System.out.println(StringUtils.splitString("Привет я из Америки"));
    }
}
