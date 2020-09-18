package guru.springframework;

public interface Expression {

    //Simple multiplier for the amount
    Expression times(int multiplier);

    //Returns a new Sum that contains .this + the added money
    Expression plus(Expression addend);

    Money reduce(Bank bank, String to);
}
