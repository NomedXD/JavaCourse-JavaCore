package by.teachmeskills.homeworks.hw_28042023.task_DOMparser;

import by.teachmeskills.homeworks.hw_28042023.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

public class DOMHandler {
    public static void findElements(Document document, String tag, List<Employee> employees) {
        NodeList employeesElements = document.getDocumentElement().getElementsByTagName(tag);
        for (int i = 0; i < employeesElements.getLength(); i++) {
            Node employee = employeesElements.item(i);
            Employee temp = new Employee();
            if (employee.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) employee;
                temp.setName(e.getElementsByTagName("name").item(0).getTextContent());
                temp.setPosition(e.getElementsByTagName("position").item(0).getTextContent());
                temp.setDepartment(e.getElementsByTagName("department").item(0).getTextContent());
                temp.setExperience(e.getElementsByTagName("experience").item(0).getTextContent());
                employees.add(temp);
            }
        }
    }
}
