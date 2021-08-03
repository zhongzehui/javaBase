package com.zehui;


/**
 * concurrency :586499ns,b=-10000
 * serial:241101ns,b=-10000,a=50000
 * 串行比并行还快？？
 * 到底是什么原因呢？
 *  上下文切换啊！！
 *  我的电脑
 */
public class ConcurrencyTest {
    private static final long count = 10_0000_000l;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.nanoTime();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.nanoTime() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ns,b=" + b);
    }

    private static void serial() {
        long start = System.nanoTime();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.nanoTime() - start;
        System.out.println("serial:" + time + "ns,b=" + b + ",a=" + a);
    }
}