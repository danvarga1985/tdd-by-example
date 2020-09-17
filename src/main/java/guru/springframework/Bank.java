package guru.springframework;

public class Bank {

    Money reduceToSingleMoneyObject(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
    }
}
