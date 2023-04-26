package by.teachmeskills.homeworks.hw_28042023;

public class Employee {
    private String name;
    private String position;
    private String department;
    private String experience;

    public Employee() {

    }

    public Employee(String name, String position, String department, String experience) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.experience = experience;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
