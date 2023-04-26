package by.teachmeskills.homeworks.hw_28042023.task_StAXparser;

import by.teachmeskills.homeworks.hw_28042023.Employee;
import by.teachmeskills.homeworks.hw_28042023.validator.InfoGetter;
import by.teachmeskills.homeworks.hw_28042023.validator.exceptions.NoSuchEmployeeException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static by.teachmeskills.homeworks.hw_28042023.filespaths.IPaths.ROOT;

public class STaXParser {
    public static void main(String[] args) throws IOException {
        List<Employee> employees = StaxHandler.parseXML(ROOT);
        employees.forEach(s -> {
            System.out.printf("Имя сотрудника: %s, его должность: %s, отделение: %s, стаж работы: %s\n",
                    s.getName(), s.getPosition(), s.getDepartment(), s.getExperience());
        });
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ФИО сотрудника для поиска информации");
        try {
            System.out.println(InfoGetter.getInfo(in.nextLine(), employees));
        } catch (NoSuchEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
