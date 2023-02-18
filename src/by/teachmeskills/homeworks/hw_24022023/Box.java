package by.teachmeskills.homeworks.hw_24022023;

public class Box {
    private final boolean containsKey;
    private static boolean alreadyKeyed = false;
    private Box[] boxes;

    public Box() {
        long rand = (int) (Math.random() * 2);
        if (rand == 1 && !alreadyKeyed) {
            containsKey = true;
            alreadyKeyed = true;
        } else
            containsKey = false;
    }

    public static void main(String[] args) {
        Box largeBox = new Box();
        int num = (int) (Math.random() * 5 + 1);
        cteateBox(largeBox, num);
        if (largeBox.containsKey)
            System.out.println("Ключ содержался сразу в большой коробке");
        else {
            for (int i = 0; i < num; i++) {
                if (largeBox.boxes[i].containsKey)
                    System.out.println("Ключ лежал в средней коробке с номером " + i);
                for (int j = 0; j < num; j++) {
                    if (largeBox.boxes[i].boxes[j].containsKey)
                        System.out.println("Ключ лежал в малой коробке с номером " + j + "(средняя коробка с номером " + i + ")");
                }
            }
        }
    }

    private static void cteateBox(Box largeBox, int num) {
        largeBox.boxes = new Box[num];
        for (int i = 0; i < num; i++) {
            largeBox.boxes[i] = new Box();
            largeBox.boxes[i].boxes = new Box[num];
            for (int j = 0; j < num; j++) {
                largeBox.boxes[i].boxes[j] = new Box();
            }
        }
    }
}
