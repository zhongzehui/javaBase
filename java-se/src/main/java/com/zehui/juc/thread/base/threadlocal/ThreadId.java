package com.zehui.juc.thread.base.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 从ThreadLocal中拷贝的源码
 * ThreadLocal 官方解析为 线程局部变量

 *  1,ThreadLocal提供了一种访问某个变量的特殊方式：访问到的变量属于当前线程，即保证每个线程的变量不一样，而同一个线程在任何地方拿到的变量都是一致的，这就是所谓的线程隔离。
 *  2,如果要使用ThreadLocal，通常定义为private static类型，在我看来最好是定义为private static final类型。
 */
public class ThreadId {


    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    //线程本地变量包含线程id
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary

    /**
     * @return 返回当前线程的唯一id
     */
    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {


        Thread thread01 = new Thread(() -> {

            String toString = threadId.toString();
            System.out.println("tostr"+toString + "==="+  threadId.get());
        }, "线程01");
        Thread thread02 = new Thread(() -> {
            String toString = threadId.toString();
            System.out.println("tostr"+toString + "==="+  threadId.get());
        }, "线程02");
        thread01.start();
        thread02.start();
    }
}