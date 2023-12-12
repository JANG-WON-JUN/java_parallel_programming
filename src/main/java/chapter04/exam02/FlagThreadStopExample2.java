package chapter04.exam02;

import java.util.concurrent.atomic.AtomicBoolean;

public class FlagThreadStopExample2 {

    private static AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();

        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();

        Thread.sleep(100);

        running.set(false);
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            while (running.get()) {
                System.out.println(Thread.currentThread() + " is Running");
            }
        }
    }
}
