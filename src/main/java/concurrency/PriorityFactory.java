package concurrency;

import java.util.concurrent.ThreadFactory;

public class PriorityFactory implements ThreadFactory {
    public int priorioty;

    public PriorityFactory(int priorioty) {
        this.priorioty = priorioty;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(priorioty);
        return thread;
    }
}
