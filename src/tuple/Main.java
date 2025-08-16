package tuple;

import tuple.tuple.Tuple;
import tuple.tuple.impl.TupleImpl;

public class Main {
    public static void main(String[] args) {
        Tuple<Integer> numbers = new TupleImpl<>(10,20,30);
        System.out.println(numbers.get(0));
    }
}
