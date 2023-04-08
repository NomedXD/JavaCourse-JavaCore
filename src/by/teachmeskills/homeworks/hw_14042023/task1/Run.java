package by.teachmeskills.homeworks.hw_14042023.task1;

public class Run {
    public static void main(String[] args) {
        RegistrationUtils.createUserFile();
        NotificationUtils.sendNotification(RegistrationUtils.ROOT + "users.txt");
    }
}
