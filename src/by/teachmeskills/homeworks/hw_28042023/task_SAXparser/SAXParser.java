package by.teachmeskills.homeworks.hw_28042023.task_SAXparser;

import by.teachmeskills.homeworks.hw_28042023.Employee;
import by.teachmeskills.homeworks.hw_28042023.validator.InfoGetter;
import by.teachmeskills.homeworks.hw_28042023.validator.exceptions.NoSuchEmployeeException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.teachmeskills.homeworks.hw_28042023.filespaths.IPaths.ROOT;

public class SAXParser {
    public static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            SaxHandler xmlHandler = new SaxHandler();
            parser.parse(new File(ROOT), xmlHandler);
            employees.forEach(s -> {
                System.out.printf("Имя сотрудника: %s, его должность: %s, отделение: %s, стаж работы: %s\n",
                        s.getName(), s.getPosition(), s.getDepartment(), s.getExperience());
            });

            Scanner in = new Scanner(System.in);
            System.out.println("Введите ФИО сотрудника для поиска информации");
            System.out.println(InfoGetter.getInfo(in.nextLine(), employees));

        } catch (ParserConfigurationException | SAXException | IOException | NoSuchEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
