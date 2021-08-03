package com.zehui.juc;

import java.util.concurrent.*;

public class TestJucSupport {

    public static void main(String[] args) {
        // test1();
        //  test2();
        test3();
    }

    //程序减法计数器CountDownLatch
    private static void test1() {
        //
        CountDownLatch countDownLatch = new CountDownLatch(4);
        new Thread(() -> {
            try {
                countDownLatch.await();
                countDownLatch.await(10000, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + "执行了输出");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "countDownLatch线程").start();
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "执行了输出");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

    }

    //程序加法计数器cyclicBarrier
    private static void test2() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            //完成了4次
            System.out.println("cyclicBarrier的action执行成功了");
        });

        for (int i = 0; i < 3; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println("线程" + temp + "执行成功");
                try {
                    //需要把await放在后面，，不然会把执行结果先输出出来
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }, String.valueOf(i)).start();
        }

    }

    //信号量测试
    private static void test3() {
        //这个参数设定了每次执行线程的数量，通过acquire来触发
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始了");
                    semaphore.acquire();
                    //执行了抢车位
                    System.out.println(Thread.currentThread().getName() + "抢车位成功");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "推出了车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }


            }, String.valueOf(i) + "A").start();

        }

    }
}
