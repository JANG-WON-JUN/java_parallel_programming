package chapter02.exam02;

public class NewStateThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("쓰레드 실행중"));

        System.out.println(thread.getState());
    }
}
