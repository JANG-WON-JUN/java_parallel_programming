package chapter03.exam01;

public class InterruptSleepExample {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(() -> {

            try {
                System.out.println("20초 동안 잠드는 쓰레드입니다.");
                Thread.sleep(20000);
                System.out.println("인터럽트 없이 잠에서 깨어났습니다.");
            } catch (InterruptedException e) {
                System.out.println("잠드는 동안 인터럽트가 발생하여 깨어났습니다.");
            }
        });

        sleepThread.start();

        // 메인 쓰레드에서 sleepThread로 인터럽트 발생시킴
        Thread.sleep(1000);
        sleepThread.interrupt();
    }

}
