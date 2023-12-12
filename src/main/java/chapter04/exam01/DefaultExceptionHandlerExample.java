package chapter04.exam01;

public class DefaultExceptionHandlerExample {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {

            // 전역적인 예외 처리 핸들러 작성
            // 이 메서드를 선언한 쓰레드에서 호출한 쓰레드에 대해서만 유효하다.
            // 즉 전역적이라고 해서 main 쓰레드부터 모든 쓰레드에 대해 적용되는 것은 아니다.
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
                System.out.println(t.getName() + "에서 예외 발생함 " + e);
            });

            Thread thread3 = new Thread(() -> {
                throw new RuntimeException("쓰레드 3 예외 발생!");
            });

            thread3.start();
        });

        // thread2에서 예외 발생 시 예외처리 불가능
        Thread thread2 = new Thread(() -> {
            throw new RuntimeException("쓰레드 2 예외 발생!");
        });

        thread1.start();
        thread2.start();
    }

}
