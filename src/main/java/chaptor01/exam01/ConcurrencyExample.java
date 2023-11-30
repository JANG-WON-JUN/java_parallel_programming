package chaptor01.exam01;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {

    public static void main(String[] args) {
        // cpu 갯수보다 작업의 갯수를 더 크게 하기 위해 2를 곱해준다.
        int cpuCores = Runtime.getRuntime().availableProcessors() * 2;

        // cpu 코어만큼 데이터를 생성
        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < cpuCores; i++) {
            data.add(i);
        }

        long startTime1 = System.currentTimeMillis();

        long sum1 = data.parallelStream()
                .mapToLong(i -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i * i;
                })
                .sum();

        long endTime1 = System.currentTimeMillis();

        // cpu 코어 갯수를 초과하는 작업을 처리하면 병렬성 + 동시성을 활용하여 처리한다.
        System.out.println("cpu 코어를 초과한 작업을 연산한 시간 >> " + (endTime1 - startTime1) + "ms");
        System.out.println("합계 >> " + sum1);
    }
}
