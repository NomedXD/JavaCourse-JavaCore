package by.teachmeskills.homeworks.hw_28042023.task_SAXparser;

import by.teachmeskills.homeworks.hw_28042023.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    private String name;
    private String position;
    private String department;
    private String experience;
    private String lastElement;

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (name != null && !name.isEmpty() && (position != null && !position.isEmpty()) &&
                (department != null && !department.isEmpty()) && (experience != null && !experience.isEmpty())) {
            SAXParser.employees.add(new Employee(name, position, department, experience));
            name = null;
            position = null;
            department = null;
            experience = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        // Следующая строка нужна потому, что в документе у тегов есть отступы и парсер на первом шаге считывает
        // весь текст разом вместе с пробелыми и другими служебными символами
        data = data.replace("\n", "").trim();
        if (!data.isEmpty()) {
            if (lastElement.equals("name")) {
                name = data;
            }
            if (lastElement.equals("position")) {
                position = data;
            }
            if (lastElement.equals("department")) {
                department = data;
            }
            if (lastElement.equals("experience")) {
                experience = data;
            }
        }
    }
}
