package chapter04.exam02;

public class FlagThreadStopExample {

    // volatile 키워드를 사용하여 공유 변수 사용
    private volatile static boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();

        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();

        Thread.sleep(500);

        running = false;
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            while (running) {
                System.out.println(Thread.currentThread() + " is Running");
            }
        }
    }
}
