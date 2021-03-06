package concurrency;

public class SimplePriority implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
//                    Thread.yield();
                }
            }
            System.out.println(this);
            Thread.yield();
            if (--countDown == 0) {
                return;
            }
        }
    }
}
