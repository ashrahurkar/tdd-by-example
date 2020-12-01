package guru.springframework;

import java.util.HashMap;

public class Bank {
    private final HashMap<Pair, Integer> rateMap = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(this,toCurrency);
    }

    public int rate(String from, String to) {
        Integer rate = 1;
        if(!from.equals(to)) {
            rate = rateMap.get(new Pair(from, to));
        }
        return rate;
//        return (from.equals("CHF") && to.equals("USD")) ? 2 : 1;
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }
}
