package com.zehui.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestProductAndConsumerByJUC {

    public static void main(String[] args) {
        Data4Juc data4Juc = new Data4Juc();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data4Juc.printA();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data4Juc.printB();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data4Juc.printC();
            }
        }, "CC").start();

    }
}

//这里写一个按顺序执行的多线程
class Data4Juc {

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    private Condition condition3 = lock.newCondition();

    private int number = 1;

    public void printA() {

        lock.lock();//加锁

        try {
            //判断是否要执行
            while (number != 1) {
                condition1.await();
            }
            number = 2;
            System.out.println("线程" + Thread.currentThread().getName() + "这里要打印的是： AAAAAAAA");
            condition2.signal();//决定下个要执行的线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }
    }

    public void printB() {

        lock.lock();//加锁

        try {
            //判断是否要执行
            while (number != 2) {
                condition2.await();
            }
            number = 3;
            System.out.println("线程" + Thread.currentThread().getName() + "这里要打印的是： BBBBBBBB");

            condition3.signal();//决定下个要执行的线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }
    }

    public void printC() {
        lock.lock();//加锁
        try {
            //判断是否要执行
            while (number != 3) {
                condition3.await();
            }
            number = 1;
            System.out.println("线程" + Thread.currentThread().getName() + "这里要打印的是： CCCCCCCC");
            condition1.signal();//决定下个要执行的线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }
    }


}