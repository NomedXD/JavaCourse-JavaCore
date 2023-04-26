package task_JaxBparser.objectsclasses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Doctor {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "position")
    private String position;
    @XmlElement(name = "department")
    private String department;
    @XmlElement(name = "experience")
    private String experience;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getExperience() {
        return experience;
    }
}
