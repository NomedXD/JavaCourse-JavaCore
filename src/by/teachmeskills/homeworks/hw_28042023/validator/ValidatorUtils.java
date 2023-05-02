package by.teachmeskills.homeworks.hw_28042023.validator;

import by.teachmeskills.homeworks.hw_28042023.validator.exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {
    public static void validateName(String name) throws ValidationException {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+(\\s[A-Z][a-z]+){2}");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new ValidationException("Не пройдена проверка имени");
        }
    }

    public static void validatePosition(String position) throws ValidationException {
        Pattern pattern = Pattern.compile("[A-Z][a-z\\s-]+");
        Matcher matcher = pattern.matcher(position);
        if (!matcher.matches()) {
            throw new ValidationException("Не пройдена проверка должности");
        }
    }

    public static void validateDepartment(String department) throws ValidationException {
        Pattern pattern = Pattern.compile("[\\d\\sA-Za-z-]+");
        Matcher matcher = pattern.matcher(department);
        if (!matcher.matches()) {
            throw new ValidationException("Не пройдена проверка отделения");
        }
    }

    public static void validateExperience(String experience) throws ValidationException {
        Pattern pattern = Pattern.compile("\\d+\\syears");
        Matcher matcher = pattern.matcher(experience);
        if (!matcher.matches()) {
            throw new ValidationException("Не пройдена проверка стажа работы");
        }
    }
}
