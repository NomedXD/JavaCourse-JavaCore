package by.teachmeskills.homeworks.hw_28042023.task_StAXparser;

import by.teachmeskills.homeworks.hw_28042023.Employee;

import javax.xml.stream.XMLEventReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaxHandler {
    public static List<Employee> parseXML(String filePath) {
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filePath));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "doctor", "nurse" -> {
                            employee = new Employee();
                        }
                        case "name" -> {
                            xmlEvent = reader.nextEvent();
                            employee.setName(xmlEvent.asCharacters().getData());
                        }
                        case "position" -> {
                            xmlEvent = reader.nextEvent();
                            employee.setPosition(xmlEvent.asCharacters().getData());
                        }
                        case "department" -> {
                            xmlEvent = reader.nextEvent();
                            employee.setDepartment(xmlEvent.asCharacters().getData());
                        }
                        case "experience" -> {
                            xmlEvent = reader.nextEvent();
                            employee.setExperience(xmlEvent.asCharacters().getData());
                        }
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("doctor") ||
                            endElement.getName().getLocalPart().equals("nurse")) {
                        employees.add(employee);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
