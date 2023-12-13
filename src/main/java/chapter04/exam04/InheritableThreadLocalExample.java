package chapter04.exam04;

public class InheritableThreadLocalExample {

    public static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        inheritableThreadLocal.set("부모 쓰레드의 값");

        new Thread(() -> {
            while (true) {
                // InheritableThreadLocal가 시작되고 나면 자식이나 부모에서 값을 바꿔도 서로 동기화 되진 않는다.
                System.out.println("자식 쓰레드에서 부모로부터 상속받은 값 : " + inheritableThreadLocal.get());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        inheritableThreadLocal.set("부모 쓰레드에서 변경한 값");
        System.out.println("부모 쓰레드에서 설정한 값 : " + inheritableThreadLocal.get());
    }
}
