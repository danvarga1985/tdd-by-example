package guru.springframework;

import java.util.HashMap;

public class Bank {

    private HashMap<Pair, Integer> rateMap = new HashMap<>();

    //
    Money reduceToSingleMoneyObject(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    //Returns the conversion rate between two currencies
    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }

        return rateMap.get(new Pair(from, to));
    }

    //Updates the conversion rate between two currencies
    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }
}
