package concurrency;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        interruptRunningThread();
    }
    private static void interruptRunningThread() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getState());
                boolean interrupted = Thread.currentThread().isInterrupted();
                System.out.println("first" + interrupted);
//                log.info("        ==> 打断状态: {}", interrupted);
                if (interrupted) {
//                    log.info("线程被打断");
                    System.out.println("线程被打断");
                    System.out.println("状态" + Thread.currentThread().isInterrupted());
//                    log.info("打断状态 ==> : {}", Thread.currentThread().isInterrupted());//true
                    break;
                }
            }
        }, "t2");
        t2.start();
        System.out.println("interupt");
//        log.debug("interrupt...");
        t2.interrupt();
        Thread.sleep(100);
        System.out.println(t2.getState());
        System.out.println("sleep");
//        log.info("t2的打断状态: {},{}",t2.getState(), t2.isInterrupted()); //false
        System.out.println("t2," + t2.getState() + t2.isInterrupted());
    }}
