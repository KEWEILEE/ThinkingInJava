package concurrency;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("daemon" + i + "started");
        }

        for (int i = 0; i < t.length; i++) {
            System.out.println("i is deamon" + t[i].isDaemon());
        }

        while (true){
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

public class Daemons{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        System.out.println("thread is deamon:" + thread.isDaemon());
        TimeUnit.SECONDS.sleep(10);
    }

}
