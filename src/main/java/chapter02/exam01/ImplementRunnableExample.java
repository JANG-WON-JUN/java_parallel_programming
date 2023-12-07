package chapter02.exam01;

public class ImplementRunnableExample {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 스레드 진행 중..");
        }
    }
}
