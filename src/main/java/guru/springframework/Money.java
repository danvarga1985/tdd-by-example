package guru.springframework;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    };

    public static Money dollar (int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc (int amount) {
        return new Money(amount, "CHF");
    }

    //Simple multiplier for the amount
    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;

        return amount == money.amount &&
                this.currency.equals(money.currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    //Returns a new Sum that contains .this + the added money
    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    //Converts current amount to another currency value, and returs it on a new Money object
    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(this.currency, to), to);
    }
}

