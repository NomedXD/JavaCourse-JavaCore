package by.teachmeskills.homeworks.hw_17032023.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CensorshipChecker {
    private static String ROOT = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\task3\\files\\";

    public static String getROOT() {
        return ROOT;
    }

    public static void setROOT(String ROOT) {
        CensorshipChecker.ROOT = ROOT;
    }

    public static void censorCheck() throws IOException {
        try(BufferedReader sourceReader = new BufferedReader(new FileReader(new File(ROOT + "sourcetext.txt")));
            BufferedReader blacklistReader = new BufferedReader(new FileReader(new File(ROOT + "blacklist.txt")))) {
            List<String> resultList = new ArrayList<>();
            List<String> blackList = new ArrayList<>();
            boolean check = false;
            int sentencesCount = 0;
            // Считывание blackList слов
            String str = blacklistReader.readLine();
            while (str != null) {
                blackList.add(str);
                str = blacklistReader.readLine();
            }
            // Посимвольное чтение предложение до символов конца строки и поиск их в предложении
            int c = sourceReader.read();
            StringBuilder temp = new StringBuilder();
            while (c != -1){
                if((char)c != '.' && (char)c!= '?' && (char)c!= '!'){
                    temp.append((char)c);
                } else{
                    String[] listWords = temp.toString().split("\\P{L}+");
                    for(String string : listWords){
                        if(blackList.contains(string)){
                            sentencesCount++;
                            resultList.add(temp.toString()+(char)c);
                            temp.delete(0,temp.length());
                            check = true;
                            break;
                        }
                    }
                }
                c = sourceReader.read();
            }
            System.out.println((!check)? "Текст прошёл проверку":"Текст не прошел проверку. Количество предложений = "+sentencesCount);
            for(String s : resultList)
                System.out.println(s);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
