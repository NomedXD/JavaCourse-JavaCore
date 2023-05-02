package by.teachmeskills.homeworks.hw_28042023.validator;

import by.teachmeskills.homeworks.hw_28042023.Employee;
import by.teachmeskills.homeworks.hw_28042023.validator.exceptions.NoSuchEmployeeException;
import by.teachmeskills.homeworks.hw_28042023.validator.exceptions.ValidationException;

import java.util.List;

public class InfoGetter {
    public static String getInfo(String name, List<Employee> employees) throws NoSuchEmployeeException {
        Employee temp = employees.stream().filter(s -> s.getName().equals(name)).findFirst().orElseThrow(() ->
                new NoSuchEmployeeException("Такого работника не найдено"));
        try {
            ValidatorUtils.validateName(temp.getName());
            ValidatorUtils.validatePosition(temp.getPosition());
            ValidatorUtils.validateDepartment(temp.getDepartment());
            ValidatorUtils.validateExperience(temp.getExperience());
            String[] nameInfo = temp.getName().split(" ");
            return "Имя: " + nameInfo[0] + "\nФамилия: " + nameInfo[1] + "\nДолжность: " + temp.getPosition() +
                    "\nОтделение: " + temp.getDepartment() + "\nСтаж работы: " + temp.getExperience();
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
