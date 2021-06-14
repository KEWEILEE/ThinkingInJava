package concurrency;

import java.util.concurrent.Callable;

public class CallableFib implements Callable<Integer> {
    private int number;

    public CallableFib(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < number+1; i++) {
            sum += returnFib(i);
        }
        return sum;
    }

    private int returnFib(int i) {
        if (i == 0) {
            return 0;
        }

        if (i == 1) {
            return 1;
        }

        return returnFib(i - 1) + returnFib(i - 2);
    }
}
