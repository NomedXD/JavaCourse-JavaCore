package by.teachmeskills.homeworks.hw_17032023.task1;

import java.io.*;

public class Run {
    public static void main(String[] args) throws IOException {
        PalindromsFinder palindromsFinder = new PalindromsFinder("src\\by\\teachmeskills\\homeworks\\hw_17032023\\task1\\files\\");
        palindromsFinder.findPalindroms();
    }
}
