package by.teachmeskills.homeworks.hw_17032023.task1;

import java.io.*;

public class PalindromsFinder {
    private String defaultPath;

    public PalindromsFinder(String defaultPath) {
        this.defaultPath = defaultPath;
    }

    public String getDefaultPath() {
        return defaultPath;
    }

    public void setDefaultPath(String defaultPath) {
        this.defaultPath = defaultPath;
    }

    public void findPalindroms() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(getDefaultPath() + "text.txt")));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(getDefaultPath() + "out.txt")))) {
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
