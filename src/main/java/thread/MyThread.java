package thread;

import org.apache.log4j.Logger;

public class MyThread extends Thread {
    private static final Logger logger = Logger.getLogger(MyThread.class);
    private IncrementRunner incrementRunner;

    public MyThread(IncrementRunner incrementRunner) {
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
