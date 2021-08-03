package com.zehui.juc.base;


/**
 * 测试多线程时 synchonized的优化
 */
public class SyncLock {


    public static void main(String[] args) {
        SyncLock syncLock = new SyncLock();
        new Thread(()-> {
            syncLock.method03();
        },"t1").start();
        new Thread(()-> {
            syncLock.method03();
        },"t2").start();



    }

    public void method03() {
        for (int i = 0; i < 10000; i++) {
            synchronized (SyncLock.class) {
                System.out.println("hello world");

            }
        }
    }
    // 锁粗化，与上面一样
    public void method04() {
        synchronized (SyncLock.class) {
            for (int i = 0; i < 10000; i++) {

                System.out.println("hello world");

            }
        }
    }
}
