package by.teachmeskills.homeworks.hw_31032023.task2;

import java.io.*;
import java.util.*;

public class DocValidatorUtils {
    private static ArrayList<String> docPaths = new ArrayList<>();
    private static HashSet<String> docNumber = new HashSet<>();
    private static HashMap<String, String> docValidation = new HashMap<>();

    private static final String REPORT_PATH = "D:" + File.separator + "JavaStudy" + File.separator;

    private DocValidatorUtils() {

    }

    private static void enterDocPaths() {
        String option = "1";
        Scanner in = new Scanner(System.in);
        while (!Objects.equals(option, "0")) {
            System.out.println("Enter document path line (0 to stop)");
            option = in.nextLine();
            if (!Objects.equals(option, "0"))
                docPaths.add(option);
        }
    }

    private static void getDocNumbersFormFiles() {
        for (String s : docPaths) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(s))) {
                String str = bufferedReader.readLine();
                while (str != null) {
                    docNumber.add(str);
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                System.out.printf("There is some error = " + e.getMessage());
            }
        }
    }

    private static void validateDocNumbers() {
        for (String s : docNumber) {
            if ((s.startsWith("contract") || s.startsWith("docnum")) && s.length() == 15 && s.chars().allMatch(Character::isLetterOrDigit)) {
                docValidation.put(s, "- valid");
            } else {
                if (!(s.startsWith("contract") || s.startsWith("docnum"))) {
                    docValidation.put(s, " - invalid - incorrect name of the document, " +
                            "doesn't starts with: contract or docnum");
                } else {
                    if (s.length() != 15) {
                        docValidation.put(s, " - invalid - incorrect name of the document, length doesn't match 15");
                    } else {
                        HashSet<Character> chars = new HashSet<>();
                        for (Character ch : s.toCharArray()) {
                            if (ch < 48 || (ch > 57 && ch < 65) || (ch > 90 && ch < 97) || ch > 122)
                                chars.add(ch);
                        }
                        docValidation.put(s, " - invalid - incorrect name of the document, illegal symbol(s)" + chars);
                    }
                }
            }
        }
    }

    public static void createReport() {
        enterDocPaths();
        getDocNumbersFormFiles();
        validateDocNumbers();
        System.out.println("Enter file name to save report");
        Scanner in = new Scanner(System.in);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(REPORT_PATH + in.nextLine()))) {
            for (Map.Entry<String, String> record : docValidation.entrySet()) {
                bf.write(record.getKey() + record.getValue() + '\n');
            }
        } catch (IOException e) {
            System.out.printf("There is some error = " + e.getMessage());
        }
    }
}
