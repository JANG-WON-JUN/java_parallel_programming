package chapter01.exam01;

import java.util.ArrayList;
import java.util.List;

public class ParallelismExample {

    public static void main(String[] args) {
        int cpuCores = Runtime.getRuntime().availableProcessors();

        // cpu 코어만큼 데이터를 생성
        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < cpuCores; i++) {
            data.add(i);
        }

        // cpu 갯수만큼 데이터를 병렬로 처리
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

        // 만약 1개의 코어로 계산한다면, 코어 갯수 * 500ms 시간 이상이 소요되어야 한다.
        // 그러나 병렬로 처리하면 보다 빠르게 실행할 수 있다.
        System.out.println("cpu 코어 " + cpuCores + "개로 연산한 시간 >> " + (endTime1 - startTime1) + "ms");
        System.out.println("합계 >> " + sum1);
    }
}
