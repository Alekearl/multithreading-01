import thread.IncrementRunner;
import thread.MyRunnable;
import thread.MyThread;

public class Main {
    public static void main(String[] args) {
        //IncrementRunner runner = new IncrementRunner();
        //Thread threadOne = new MyThread(runner);
        //Thread threadTwo = new Thread(new MyRunnable(runner));
        //threadOne.start();
        //threadTwo.start();

        String[] words = new String[]{"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(Solution.countConsistentStrings("ab", words));

    }

    static class Solution {
        public static int countConsistentStrings(String allowed, String[] words) {
            int counter = 0;
            String[] array = allowed.split("");
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < allowed.length(); j++) {
                    words[i] = words[i].replace(array[j], "");
                }
                if (words[i].length() == 0) {
                    counter++;
                }
            }
            return counter;
        }
    }
}
