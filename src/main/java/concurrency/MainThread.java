package concurrency;

public class MainThread {
    public static void main(String[] args) {

        Thread t = new Thread(new SleepingTask());
        t.start();
        System.out.println("waiting for lift off");
    }
}

