package by.teachmeskills.homeworks.hw_10032023.Task2;

public class University {
    private int studentsCount;
    private Season season;

    enum Season {
        WINTER("зима"),
        SPRING("весна"),
        SUMMER("лето"),
        AUTUMN("осень");
        final String name;

        Season(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void printAll() {
        switch (season.toString()) {
            case "зима", "весна", "осень":
                System.out.printf("Университет БГУиР, учащихся %d, сейчас мы учимся, потому что %s", studentsCount, season);
                break;
            case "лето":
                System.out.printf("Университет БГУиР, учащихся %d, сейчас мы отдыхаем(тоже учимся), потому что %s", studentsCount, season);
                break;
        }
    }
}
