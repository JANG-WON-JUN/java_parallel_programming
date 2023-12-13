package chapter04.exam03;

public class ThreadGroupExample {

    public static void main(String[] args) {
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup customThreadGroup = new ThreadGroup("Custom Thread Group");

        // 별도의 생성자 파라미터 없이 쓰레드 그룹을 생성하면 쓰레드 그룹을 생성하는 쓰레드가 속한 쓰레드 그룹에 속하게 된다.
        Thread defaultGroupThread = new Thread(new GroupRunnable(), "DefaultGroupThread");
        Thread mainGroupThread = new Thread(mainThreadGroup, new GroupRunnable(),
                "MainGroupThread");
        Thread customGroupThread = new Thread(customThreadGroup, new GroupRunnable(),
                "CustomGroupThread");

        defaultGroupThread.start();
        mainGroupThread.start();
        customGroupThread.start();
    }

    static class GroupRunnable implements Runnable {

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            System.out.println(
                    currentThread.getName() + " 는 " + currentThread.getThreadGroup() + "에 속한다.");
        }
    }
}
