package chapter04.exam01;

public class UncaughtExceptionHandlerExample {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            throw new RuntimeException("쓰레드 예외 발생!");
        });

        Thread thread2 = new Thread(() -> {
            throw new RuntimeException("쓰레드 예외 발생!");
        });

        // 특정 쓰레드에 대해서만 예외 처리 핸들러 등록
        thread1.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + "에서 예외 발생함 " + e);
        });

        // 특정 쓰레드에 대해서만 예외 처리 핸들러 등록
        thread2.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + "에서 예외 발생함 " + e);
        });

        thread1.start();
        thread2.start();
    }

}
