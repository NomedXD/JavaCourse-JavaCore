package by.teachmeskills.homeworks.hw_03032023.task4.bank_task;

public class Card {
    private String number;
    private CardType type;
    private String owner;
    private Date date;
    private String cvv;

    public Card(String number, CardType type, String owner, Date expirationDate, String cvv) {
        this.number = number;
        this.type = type;
        this.owner = owner;
        this.date = expirationDate;
        this.cvv = cvv;
    }

    protected static class Date {
        private int year;
        private int month;

        Date(int month, int year) {
            this.month = month;
            this.year = year;
        }

    }

    protected enum CardType {
        DEBIT, CREDIT
    }

    public boolean isValid(String number, CardType cardType, String owner, Date expirationDate, String cvv) {
        class CardValidator {
            private final Card card;

            public CardValidator(Card card) {
                this.card = card;
            }

            public boolean checkNumber() {
                return card.number.equals(number) && number.length() == 16;
            }

            public boolean checkType() {
                return cardType == card.type;
            }

            public boolean checkOwner() {
                return owner.equals(card.owner) && !owner.isBlank();
            }

            public boolean checkDate() {
                return expirationDate.month == card.date.month && expirationDate.year == card.date.year
                        && expirationDate.month > 0 && expirationDate.month < 13 && expirationDate.year > 0;
            }

            public boolean checkCvv() {
                return cvv.length() == 3 && cvv.equals(card.cvv);
            }

        }

        CardValidator validator = new CardValidator(this);
        return validator.checkNumber() && validator.checkType() && validator.checkOwner() && validator.checkDate() && validator.checkCvv();
    }

}
