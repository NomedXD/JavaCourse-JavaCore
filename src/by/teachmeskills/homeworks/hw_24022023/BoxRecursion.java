package by.teachmeskills.homeworks.hw_24022023;

public class BoxRecursion {
    private final boolean containsKey;
    private static boolean alreadyKeyed = false;
    private BoxRecursion[] boxes;

    public BoxRecursion() {
        long rand = (int) (Math.random() * 2);
        if (rand == 1 && !alreadyKeyed) {
            containsKey = true;
            alreadyKeyed = true;
        } else
            containsKey = false;
    }

    public static void main(String[] args) {
        BoxRecursion largeBox = new BoxRecursion();
        int num = (int) (Math.random() * 5 + 1);
        cteateBox(largeBox, num);
        if (largeBox.containsKey)
            System.out.println("Ключ содержался сразу в большой коробке");
        else {
            BoxRecursion box = null;
            for (int i = 0; i < num; i++)
                box = findKey(largeBox.boxes[i], box, 1, num);
            for (int i = 0; i < num; i++) {
                if (largeBox.boxes[i] == box)
                    System.out.println("Ключ лежал в средней коробке с номером " + i);
                else {
                    for (int j = 0; j < num; j++) {
                        if (largeBox.boxes[i].boxes[j] == box)
                            System.out.println("Ключ лежал в малой коробке с номером " + j + "(средняя коробка с номером " + i + ")");
                    }
                }
            }
        }
    }

    private static void cteateBox(BoxRecursion largeBox, int num) {

        largeBox.boxes = new BoxRecursion[num];
        for (int i = 0; i < num; i++) {
            largeBox.boxes[i] = new BoxRecursion();
            largeBox.boxes[i].boxes = new BoxRecursion[num];

            for (int j = 0; j < num; j++) {
                largeBox.boxes[i].boxes[j] = new BoxRecursion();
            }
        }
    }

    private static BoxRecursion findKey(BoxRecursion box, BoxRecursion boxRes, int deep, int num) {
        for (int ind = 0; ind < num; ind++) {
            if (box.containsKey)
                boxRes = box;
            else if (deep < 3)
                findKey(box.boxes[ind], boxRes, deep + 1, num);
        }
        return boxRes;
    }

}