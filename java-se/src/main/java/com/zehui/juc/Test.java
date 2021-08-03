package com.zehui.juc;

import java.util.concurrent.atomic.AtomicReference;


/*
什么是可重入锁
 */
public class Test {

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        SpinLockDemo.Widget widget = spinLockDemo.new LoggingWidget();
        widget.doSomething();
    }
}


class SpinLock {

    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        System.out.println(current.getName());
        while (!sign.compareAndSet(null, current)) {
        }
    }

    public void unlock() {
        Thread cur = Thread.currentThread();
        System.out.println(cur.getName());
        sign.compareAndSet(cur, null);
    }
}

class SpinLockDemo {
    private SpinLock lock = new SpinLock();

    class Widget {
        public void doSomething() {
            lock.lock();
            System.out.println("Widget calling doSomething");
            lock.unlock();
        }
    }

    class LoggingWidget extends Widget {
        @Override
        public void doSomething() {
            lock.lock();
            System.out.println("LoggingWidget calling doSomething");
            super.doSomething();
            lock.unlock();
        }
    }

}