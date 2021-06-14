package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoreBasicThreads {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        DaemonThreadPoolExecutor executor = new DaemonThreadPoolExecutor();
        ExecutorService executorService1 = Executors.newCachedThreadPool(new PriorityFactory(10));


//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new LiftOff());
//        }
        for (int i = 0; i < 5; i++) {
            executorService1.execute(new LiftOff());
        }

//        executorService.execute(new SimplePriority(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
