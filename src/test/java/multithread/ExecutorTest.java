package multithread;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ExecutorTest {
    private static final Integer EXPECTED = 1000000;
    private static ExecutorSumThread executorSumThread;
    private static List<Integer> integerList;

    @BeforeAll
    static void beforeAll() {
        integerList = NumbersProducer.generate();
        executorSumThread = new ExecutorSumThread();
    }

    @Test
    void works_Ok() {
        Assertions.assertEquals(EXPECTED, executorSumThread.getSum(integerList));
    }

    @Test
    void works_NotOk() {
        Assertions.assertNotEquals(10000, executorSumThread.getSum(integerList));
    }
}
