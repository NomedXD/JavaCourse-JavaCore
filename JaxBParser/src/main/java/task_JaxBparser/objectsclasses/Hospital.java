package task_JaxBparser.objectsclasses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "hospital")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hospital {
    @XmlElement(name = "doctor")
    private List<Doctor> doctorList = new ArrayList<>();
    @XmlElement(name = "nurse")
    private List<Nurse> nurseList = new ArrayList<>();

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public List<Nurse> getNurseList() {
        return nurseList;
    }
}
