package com.zehui.jvm.chatper12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Test test = new Test();
//        test.testWaitBlock();
        test.testLockObj();
        //线程阻塞的方法
        //thread sleep方法
        // 上面的Object的wait方法
        //
/*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }


    /*
    证明了，同步方法的所对象是：运行方法的对象本身，也就是this
     */
    public synchronized void testLockObj() {
        try {
            this.wait(1000);//上锁了
            //Test.class.wait(1000);java.lang.IllegalMonitorStateException
           // Thread.sleep(1000);
            System.out.println("上锁了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void testWaitBlock() {
        lock.lock();
        Test test = new Test();
        try {
            //java.lang.IllegalMonitorStateException是在调用object的wait和notify，notifyAll方法的时候可能会出现的异常
            //需要先获取锁对象
            //要用锁对象执行wait只能这么用！！
            //这个是我之前不知道的；
            //但是同步方法的锁是什么呢？
            synchronized (this) {
                this.wait(5000);
            }
           /* synchronized (lock){
                lock.wait(5000);
            }
            synchronized (Test.class){
                Test.class.wait(5000);
            }*/

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
