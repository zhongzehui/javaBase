package com.zehui.juc.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1_0000_0000
 * 并行耗费时间：740863600
 * 串行耗费时间：3482300 这个是使用AtomicInteger执行结果
 * 3175699
 * 100_0000
 * 并行耗费时间：49102000
 * 串行耗费时间：3108700
 * <p>
 * 10_0000_0000
 * 进行int运算的时间
 * 并行耗费时间：43471800
 * 串行耗费时间：3634301
 *
 * 10_0000_0000
 * 这个是把int改成long之后的结果
 * 并行耗费时间：458852800
 * 串行耗费时间：860495300
 *
 * 为什么int会比long快这么多呢？
 * 难道是因为long是8个字节，int是4个字节
 *
 */
public class ConcurencyTest {
    public static final int COUNT = 10_0000_0000;//  1_0000_0000; 100_0000

    public static void main(String[] args) {
        //最大值是2的31次方减1 大约是21.5个亿
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        concurrency();
        serial();
    }

    private static void serial() {
        long startTime = System.nanoTime();
        int b = 0;
        for (int i = 0; i < COUNT; i++) {
            b++;
        }
        long numb = 0;
        for (int i = 0; i < COUNT; i++) {
            numb = +1;
        }

        System.out.println("串行耗费时间：" + Long.toString(System.nanoTime() - startTime));
    }

    /**
     * 测试并发效率
     */
    private static void concurrency() {
        long startTime = System.nanoTime();
//        AtomicInteger b = new AtomicInteger();
        Thread thread = new Thread(() -> {
            int numa = 0;
            for (int i = 0; i < COUNT; i++) {
//                int temp= b.incrementAndGet();
                numa++;
            }
        }, "thread");

        thread.start();

        int numb = 0;
        for (int i = 0; i < COUNT; i++) {
            numb = +1;
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("并行耗费时间：" + Long.toString(System.nanoTime() - startTime));

    }
}
