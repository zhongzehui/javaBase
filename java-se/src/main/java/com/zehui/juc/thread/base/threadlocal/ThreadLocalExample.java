package com.zehui.juc.thread.base.threadlocal;

import com.zehui.juc.thread.base.threadlocal.ConnectionUtil;
import com.zehui.juc.thread.base.threadlocal.ThreadData;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用threadData封装threadlocal
 */
public class ThreadLocalExample {

//    ThreadLocal<Integer> pa
    public static void main(String[] args) {

        Thread thread01 = new Thread(()->{
            List<String> stringList = ThreadData.get();
            System.out.println("stringList tostr ==> " + stringList.toString());
            for (String s : stringList) {
                System.out.println(Thread.currentThread().getName() + " ==>" + s);
            }

        },"001");

        Thread thread02 = new Thread(()->{
            List<String> stringList = ThreadData.get();
            ArrayList<String>  list  = (ArrayList<String>) stringList;

            System.out.println("stringList tostr ==> " +stringList.toString());
            for (String s : stringList) {
                System.out.println(Thread.currentThread().getName() + " ==>" + s);
            }

        },"002");

        thread01.start();

        thread02.start();

    }

}


