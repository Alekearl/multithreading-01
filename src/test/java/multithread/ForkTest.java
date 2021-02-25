package multithread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ForkTest {
    private static final Integer EXPECTED = 1000000;
    private static ForkImpl fork;
    private static List<Integer> integerList;

    @BeforeAll
    static void beforeAll() {
        integerList = NumbersProducer.generate();
        fork = new ForkImpl(integerList);
    }

    @Test
    void works_Ok() {
        Assertions.assertEquals(EXPECTED, fork.compute());
    }

    @Test
    void works_NotOk() {
        Assertions.assertNotEquals(10000, fork.compute());
    }
}
