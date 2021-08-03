package com.zehui.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {


    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(10);
    public static void main(String[] args) {
        System.out.println(ATOMIC_INTEGER.getAndIncrement());
        System.out.println(ATOMIC_INTEGER.get());
    }


}
