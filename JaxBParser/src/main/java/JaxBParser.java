import by.teachmeskills.homeworks.hw_28042023.validator.InfoGetter;
import by.teachmeskills.homeworks.hw_28042023.validator.exceptions.NoSuchEmployeeException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import by.teachmeskills.homeworks.hw_28042023.Employee;
import task_JaxBparser.objectsclasses.Hospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static filespaths.IPaths.ROOT;

public class JaxBParser {
    private static final List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Parsing
            BufferedReader br = new BufferedReader(new FileReader(ROOT));
            String body = br.lines().collect(Collectors.joining());
            StringReader reader = new StringReader(body);
            JAXBContext context = JAXBContext.newInstance(Hospital.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Hospital hospital = (Hospital) unmarshaller.unmarshal(reader);

            hospital.getDoctorList().forEach(s -> {
                employees.add(new Employee(s.getName(), s.getPosition(), s.getDepartment(), s.getExperience()));
            });
            hospital.getNurseList().forEach(s -> {
                employees.add(new Employee(s.getName(), s.getPosition(), s.getDepartment(), s.getExperience()));
            });
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
        } catch (FileNotFoundException | JAXBException e) {
            System.out.println(e.getMessage());
        }
    }
}
