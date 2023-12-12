package chapter04.exam01;

public class ThreadExceptionExample {

    public static void main(String[] args) {

        try {
            // Thread에서 발생하는 예외는 외부에서 캐치할 수 없다.
            new Thread(() -> {
                throw new RuntimeException("쓰레드 예외 발생!");
            }).start();
        } catch (Exception e) {
            System.out.println("쓰레드에서 발생한 예외를 처리한다.");
        }

    }

}
