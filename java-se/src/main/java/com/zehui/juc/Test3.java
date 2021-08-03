package com.zehui.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {
    public static void main(String[] args) {
        Data4Lock data4Lock = new Data4Lock();
        new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                data4Lock.produce();
            }
        },"生产者").start();
        new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                data4Lock.consume();
            }
        },"消费者").start();
    }
}
class Data4Lock{


    private int number;


    private Lock lock = new ReentrantLock();

    private Condition condition  = lock.newCondition();

    public void produce(){
        lock.lock();
        try {
            while (number!=0){
                condition.await();
            }
            number++;
            System.out.println("线程："+ Thread.currentThread().getName() + "执行了produce; number= "
                    + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try {
            while (number==0){
                condition.await();
            }
            number--;
            System.out.println("线程："+ Thread.currentThread().getName() + "执行了consume; number= "
            + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}