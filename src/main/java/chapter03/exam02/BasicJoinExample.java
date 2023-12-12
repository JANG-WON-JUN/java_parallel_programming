package chapter03.exam02;

public class BasicJoinExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("쓰레드가 3초동안 작동합니다.");
                Thread.sleep(3000);
                System.out.println("쓰레드 작동 완료");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("메인 쓰레드가 다음 쓰레드의 완료를 기다립니다.");
        thread.start();
        thread.join();
        System.out.println("메인 쓰레드가 계속 진행합니다.");
    }

}