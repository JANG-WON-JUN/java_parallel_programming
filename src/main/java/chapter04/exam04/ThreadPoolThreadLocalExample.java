package chapter04.exam04;

import static java.lang.Thread.currentThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolThreadLocalExample {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        // 2개의 쓰레드를 가진 쓰레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            threadLocal.set("작업 1의 값");
            System.out.println(currentThread().getName() + " : " + threadLocal.get());
        });

        // 잠시 대기
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 5; i++) {
            // 여기에서 새롭게 쓰레드를 활용하려 하는데, 기존 쓰레드 로컬의 값을 참조하고 있다.
            executor.submit(() -> {
                System.out.println(
                        currentThread().getName() + " : " + threadLocal.get() + "(for 문 안)");
            });
        }

        executor.shutdown();

    }
}
