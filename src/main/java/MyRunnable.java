import org.apache.log4j.Logger;

public class MyRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(MyRunnable.class);
    private IncrementRunner incrementRunner;

    public MyRunnable(IncrementRunner incrementRunner) {
        this.incrementRunner = incrementRunner;
    }

    @Override
    public void run() {
        while (incrementRunner.getIncrement() <= 50) {
            incrementRunner.incrementToOne();
            logger.info(incrementRunner.getIncrement());
        }
    }
}
