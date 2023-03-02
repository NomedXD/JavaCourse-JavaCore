package by.teachmeskills.homeworks.hw_03032023.task4.bank_task;

public class Run {
    public static void main(String[] args) {
        Card card = new Card("9999000088887777", Card.CardType.CREDIT, "IVAN", new Card.Date(03, 23), "787");
        if (card.isValid("1234567887654321", Card.CardType.DEBIT, "VICTOR", new Card.Date(06, 25), "823"))
            System.out.println("Карта верная");
        else
            System.out.println("Карта не валидная");
        if (card.isValid("9999000088887777", Card.CardType.CREDIT, "IVAN", new Card.Date(03, 23), "787"))
            System.out.println("Карта верная");
        else
            System.out.println("Карта не валидная");
    }
}
