package by.teachmeskills.homeworks.hw_03032023.task1.Robots;

import by.teachmeskills.homeworks.hw_03032023.task1.Hands.IHand;
import by.teachmeskills.homeworks.hw_03032023.task1.Heads.IHead;
import by.teachmeskills.homeworks.hw_03032023.task1.Legs.ILeg;

public class RobotImpl implements IRobot {
    private IHead head;
    private IHand hand;
    private ILeg leg;

    public RobotImpl(IHead head, ILeg leg, IHand hand) {
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    public IHead getHead() {
        return head;
    }

    public void setHead(IHead head) {
        this.head = head;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }

    public void setLeg(ILeg leg) {
        this.leg = leg;
    }

    public IHand getHand() {
        return hand;
    }

    public ILeg getLeg() {
        return leg;
    }

    @Override
    public void action() {
        head.speek();
        hand.upHand();
        leg.step();
    }

    @Override
    public int getPrice() {
        return head.getPrice() + hand.getPrice() + leg.getPrice();
    }

}
