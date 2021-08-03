package com.zehui.juc;

import java.util.concurrent.*;

public class TestThreadPool {

    public static void main(String[] args) {
      //  testExecutor();
        testThreadPoolExecutor();
    }

    private static void testExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 20; i++) {
                final int temp = i;
                executorService.execute(() -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                        System.out.println("线程" + temp + "执行成功");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }

    private static void testThreadPoolExecutor() {
        //BlockingQueue<Runnable>
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(128);
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardPolicy();
        int cpuProcessorNum = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(8, cpuProcessorNum, 10, TimeUnit.SECONDS,
                blockingQueue, new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 64; i++) {
            final int temp = i;
            Thread thread = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("哈哈哈，我是" + Thread.currentThread().getName() + ",我执行了");
                    System.out.println("哈哈哈，我是线程" + temp + ",我执行了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "线程" + i);
            // blockingQueue.add(thread);
            poolExecutor.submit(thread);
        }
        poolExecutor.shutdown();
    }

}
