package chapter02.exam01;

public class ExtendThreadExample {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 스레드 진행 중..");
        }
    }
}
