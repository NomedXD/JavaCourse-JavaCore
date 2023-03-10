package by.teachmeskills.homeworks.hw_17032023.task1;


import java.io.BufferedReader;
import  java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PalindromsFinder {
    public static final String ROOT = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\task1\\files\\";

    public void findPalindroms() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(ROOT + "text.txt")));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(ROOT + "out.txt")))) {
            String str = reader.readLine();
            while (str != null) {
                StringBuilder temp = new StringBuilder(str);
                if (str.equals(temp.reverse().toString())) {
                    writer.append(temp.toString() + '\n');
                }
                str = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
