package com.zehui.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCow {
    public static void main(String[] args) {
      //  testExecption();
        AtomicInteger atomicInteger = new AtomicInteger();
        new Thread(()->{
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName() +" -- " + atomicInteger.incrementAndGet());
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                    e.printStackTrace();
                }

        },"线程A").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() +" -- " + atomicInteger.incrementAndGet());
                }
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }

        },"线程B").start();

        System.out.println(atomicInteger);
    }


    public static void  testExecption(){

        //使用非并发安全的集合类，进行并发操作，会出现并发异常！
//        List<String> testList = new ArrayList<>();//抛了这个错出来了，java.util.ConcurrentModificationException
//        List<String> testList = new Vector<>();//这个数据量上来之后会很慢
       // List<String> testList2 = Collections.synchronizedList( new ArrayList<>());
        List<String> testList = new CopyOnWriteArrayList<>();

        Set<String> stringSet = new CopyOnWriteArraySet<>();
       // Set<String> stringSet = new CopyOnWriteArraySet<>();
        //但是我们之前学习过verctor，可以用vector
//        Vector是比较古老的线程安全的，但性能不行；
//        CopyOnWriteArrayList在兼顾了线程安全的同时，又提高了并发性，性能比Vector有不少提高
        for (int i = 0; i < 10 ; i++) {
            new Thread(()->{
                testList.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(testList);
            }).start();;
        }
    }
}