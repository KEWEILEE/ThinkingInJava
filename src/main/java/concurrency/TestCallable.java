package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //Executors.callable() 可以使用 runnable 对象

        ArrayList<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new CallableFib(i)));
        }

        for (Future<Integer> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
