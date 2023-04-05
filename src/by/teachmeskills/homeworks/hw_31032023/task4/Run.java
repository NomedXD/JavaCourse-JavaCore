package by.teachmeskills.homeworks.hw_31032023.task4;

public class Run {
    public static void main(String[] args) {
        ArrList<Integer> list = new ArrList<>(2);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(3,10);
        list.clear();
        // На самом деле в ArrList реализовано больше методов...рабочих :)
        System.out.println(list);
    }
}
