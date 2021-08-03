package com.zehui.juc.thread.base.threadlocal;

import java.text.SimpleDateFormat;

/**
 * 重写git的教程
 */
public class ThreadLocalExample2 {

    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
           return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    public static void main(String[] args) {
        System.out.println("21312"+new SimpleDateFormat("yyyyMMdd HHmm").toString());
        System.out.println("21112"+new SimpleDateFormat("yyyyMMdd HHmm").toString());

        
        for (int i = 0; i < 10; i++) {

            new Thread(()->{

                System.out.println( Thread.currentThread().getName() + " ## "+
                        SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().toString()+ " === "
                + SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().toPattern());
                SIMPLE_DATE_FORMAT_THREAD_LOCAL.set(new SimpleDateFormat());
                System.out.println( Thread.currentThread().getName() + " ## "+
                        SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().toString()+ " === "
                        + SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().toPattern());
                //防止内存泄漏，一般最后手工释放内存；
                SIMPLE_DATE_FORMAT_THREAD_LOCAL.remove();
            }," thread ==> "+ i).start();

        }
    }
}
