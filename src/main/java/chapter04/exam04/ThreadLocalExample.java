package chapter04.exam04;

import static java.lang.Thread.currentThread;

public class ThreadLocalExample {

    // 초기값을 부여하지 않고 쓰레드 로컬 선언하기
    // private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    // 초기값을 부여하면서 쓰레드 로컬 선언하기
    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "Hello world");

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println(parse(currentThread().getName(), threadLocal.get()));
            threadLocal.set("쓰레드 1의 값");
            System.out.println(parse(currentThread().getName(), threadLocal.get()));
            threadLocal.remove();
            // remove를 하고 나면, null이 아닌 쓰레드 로컬의 초기값이 출력된다.
            System.out.println(parse(currentThread().getName(), threadLocal.get()));
        }, "Thread-1").start();

        new Thread(() -> {
            System.out.println(parse(currentThread().getName(), threadLocal.get()));
            threadLocal.set("쓰레드 2의 값");
            System.out.println(parse(currentThread().getName(), threadLocal.get()));
            threadLocal.remove();
        }, "Thread-2").start();
    }

    private static String parse(String threadName, String value) {
        return threadName + "가 가지는 쓰레드 로컬 값 >> " + value;
    }
}
