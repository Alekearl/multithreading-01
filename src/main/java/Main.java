public class Main {
    public static void main(String[] args) {
        IncrementRunner runner = new IncrementRunner();
        Thread threadOne = new MyThread(runner);
        Thread threadTwo = new Thread(new MyRunnable(runner));
        threadOne.start();
        threadTwo.start();
    }
}
