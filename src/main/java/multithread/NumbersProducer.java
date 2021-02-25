package multithread;

import java.util.ArrayList;
import java.util.List;

public class NumbersProducer {
    private static final int ONE_ADDITION = 1;
    private static final int NUMBERS_TO_PRODUCE = 1_000_000;

    public static List<Integer> generate() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= NUMBERS_TO_PRODUCE; i++) {
            list.add(ONE_ADDITION);
        }
        return list;
    }
}
