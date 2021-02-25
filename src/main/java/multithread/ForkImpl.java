package multithread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkImpl extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100000;
    private List<Integer> list;

    public ForkImpl(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer compute() {
        if (list.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtask())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        }
        return processing(list);
    }

    private Collection<ForkImpl> createSubtask() {
        List<ForkImpl> tasks = new ArrayList<>();
        tasks.add(new ForkImpl(list.subList(0, list.size() / 2)));
        tasks.add(new ForkImpl(list.subList(list.size() / 2, list.size())));
        return tasks;
    }

    private Integer processing(List<Integer> list) {
        return list.stream()
                .reduce(Integer::sum)
                .get();
    }
}
