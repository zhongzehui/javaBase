package com.zehui.juc.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    public static void main(String[] args) {
        Thread thread01 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+ " 睡眠结束了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "join 线程");
        thread01.start();
        thread01.interrupt();
        try {
            thread01.join();
//            加了join之后，主线程阻塞，等待threa01执行结束再执行
            //运行结果：
            // join 线程 睡眠结束了
            //主线程执行结束了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束了");

    }
}
