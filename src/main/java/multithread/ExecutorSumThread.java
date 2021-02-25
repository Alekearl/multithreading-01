package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSumThread {
    private static final int THREADS = 4;

    private List<Callable<Integer>> getCallables(List<Integer> list) {
        List<Callable<Integer>> callableList = new ArrayList<>();
        for (int i = 0; i < list.size(); i = i + THREADS) {
            callableList.add(new SumExecutorImpl(list.subList(i,
                    Math.min(list.size(), i + THREADS))));
        }
        return callableList;
    }

    public int getSum(List<Integer> list) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        List<Callable<Integer>> callables = getCallables(list);
        int sum = 0;
        try {
            List<Future<Integer>> futures = executor.invokeAll(callables);
            for (Future<Integer> future : futures) {
                sum += future.get();
            }
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Something went wrong. Result is incorrect", e);
        } finally {
            executor.shutdown();
        }
    }
}
