package by.teachmeskills.homeworks.hw_28042023.task_DOMparser;

import by.teachmeskills.homeworks.hw_28042023.Employee;
import by.teachmeskills.homeworks.hw_28042023.validator.InfoGetter;
import by.teachmeskills.homeworks.hw_28042023.validator.exceptions.NoSuchEmployeeException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.teachmeskills.homeworks.hw_28042023.filespaths.IPaths.ROOT;

public class DOMParser {
    private static final List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(ROOT);
            DOMHandler.findElements(document, "doctor", employees);
            DOMHandler.findElements(document, "nurse", employees);

            employees.forEach(s -> {
                System.out.printf("Имя сотрудника: %s, его должность: %s, отделение: %s, стаж работы: %s\n",
                        s.getName(), s.getPosition(), s.getDepartment(), s.getExperience());
            });
            Scanner in = new Scanner(System.in);
            System.out.println("Введите ФИО сотрудника для поиска информации");
            System.out.println(InfoGetter.getInfo(in.nextLine(), employees));

        } catch (ParserConfigurationException | IOException | SAXException | NoSuchEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
