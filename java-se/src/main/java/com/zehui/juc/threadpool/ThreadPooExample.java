package com.zehui.juc.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 *
 */
public class ThreadPooExample {

    private static ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();

    public static void main(String[] args) {
        /**
         * 线程池工厂
         */
        ThreadFactory my_thread_pool = threadFactoryBuilder.setNameFormat("my thread pool").build();

        /**
         * 初始化线程池
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,/*核心线程数线程数定义了最小可以同时运行的线程数量*/
                4, /*当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数*/
                10L/*当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，
                核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁
                */,
                TimeUnit.MILLISECONDS  /*参数的时间单位*/
                ,
                new LinkedBlockingQueue<Runnable>(1024)
                /*当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中*/
               // ,
                //my_thread_pool /*executor 创建新线程的时候会用到*/
                ,
                new ThreadPoolExecutor.AbortPolicy()/*饱和策略*/
        );

        CountDownLatch countDownLatch = new CountDownLatch(1);


        threadPoolExecutor.submit(() -> {
            try {
                countDownLatch.await();
                for (int i = 0; i < 3; i++) {
                    System.out.println("sh" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        threadPoolExecutor.submit(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("3h" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();

        });

        threadPoolExecutor.shutdown();


    }
}
