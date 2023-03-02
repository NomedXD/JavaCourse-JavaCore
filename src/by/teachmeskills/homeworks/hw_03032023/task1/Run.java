package by.teachmeskills.homeworks.hw_03032023.task1;

import by.teachmeskills.homeworks.hw_03032023.task1.Hands.SonyHandImpl;
import by.teachmeskills.homeworks.hw_03032023.task1.Hands.SamsungHandImpl;
import by.teachmeskills.homeworks.hw_03032023.task1.Heads.SonyHeadImpl;
import by.teachmeskills.homeworks.hw_03032023.task1.Heads.SamsungHeadImpl;
import by.teachmeskills.homeworks.hw_03032023.task1.Heads.ToshibaHeadImpl;
import by.teachmeskills.homeworks.hw_03032023.task1.Legs.SonyLegImpl;
import by.teachmeskills.homeworks.hw_03032023.task1.Legs.SamsungLegImpl;
import by.teachmeskills.homeworks.hw_03032023.task1.Legs.ToshibaLegImpl;
import by.teachmeskills.homeworks.hw_03032023.task1.Robots.Robot;

public class Run {
    public static void main(String[] args) {
        Robot robot1 = new Robot(new ToshibaHeadImpl(15), new SamsungLegImpl(12), new SonyHandImpl(67));
        Robot robot2 = new Robot(new SamsungHeadImpl(19), new ToshibaLegImpl(22), new SonyHandImpl(11));
        Robot robot3 = new Robot(new SonyHeadImpl(22), new SonyLegImpl(19), new SamsungHandImpl(22));
        Robot[] robotsArray = {robot1, robot2, robot3};
        int max = 0;
        robot1.action();
        for (int i = 1; i < robotsArray.length; ++i) {
            if (robotsArray[i].getPrice() > robotsArray[max].getPrice())
                max = i;
            robotsArray[i].action();
        }
        System.out.printf("Самый дорогой робот номер %d с ценой запчастей %d", max + 1, robotsArray[max].getPrice());
    }
}
