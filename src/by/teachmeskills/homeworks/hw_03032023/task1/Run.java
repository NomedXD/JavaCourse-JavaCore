package by.teachmeskills.homeworks.hw_03032023.task1;

import by.teachmeskills.homeworks.hw_03032023.task1.Hands.SonyHandClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Hands.SumsungHandClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Hands.ToshibaHandClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Heads.SonyHeadClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Heads.SumsungHeadClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Heads.ToshibeHeadClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Legs.SonyLegClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Legs.SumsungLegClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Legs.ToshibaLegClass;
import by.teachmeskills.homeworks.hw_03032023.task1.Robots.Robot;

public class Run {
    public static void main(String[] args) {
        Robot robot1 = new Robot(new ToshibeHeadClass(15), new SumsungLegClass(12), new SonyHandClass(67));
        Robot robot2 = new Robot(new SumsungHeadClass(19), new ToshibaLegClass(22), new SonyHandClass(11));
        Robot robot3 = new Robot(new SonyHeadClass(22), new SonyLegClass(19), new SumsungHandClass(22));
        Robot[] robotsArray = {robot1, robot2, robot3};
        int max = 0;
        robot1.action();
        for(int i=1;i< robotsArray.length;++i){
            if(robotsArray[i].getPrice()>robotsArray[max].getPrice())
                max=i;
            robotsArray[i].action();
        }
        System.out.printf("Самый дорогой робот номер %d с ценой запчастей %d",max+1,robotsArray[max].getPrice());
    }
}
