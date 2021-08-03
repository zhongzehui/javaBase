package com.zehui.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

    public static void main(String[] args) {
        long currentMills = System.currentTimeMillis();
        //需要钟FutureTask来适配
        FutureTask<Object> futureTask01 = new FutureTask<>(new MyCallable());
        FutureTask<Object> futureTask02 = new FutureTask<>(new MyCallable());
        FutureTask<Object> futureTask03 = new FutureTask<>(new MyCallable());

        new Thread(futureTask01, "线程A").start();
        new Thread(futureTask02, "线程B").start();
        new Thread(futureTask03, "线程C").start();

        try {
            System.out.println();
            Object result1 = futureTask02.get();
            System.out.println(result1);

            Object result2 = futureTask03.get();
            System.out.println(result2);
            System.out.println( "运行时间"+  (System.currentTimeMillis() - currentMills )  + "ms ");

            Object result = futureTask01.get(); //  get方法会阻塞，建议使用异步通信来处理
            System.out.println(result);
            System.out.println( "运行时间"+  (System.currentTimeMillis() - currentMills )  + "ms ");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        String threadname = Thread.currentThread().getName();
        if("线程A".equals(threadname)){
            Thread.sleep(3000);
        }
        System.out.println(threadname + "线程执行了！ ");

        return threadname + " 执行成功";
    }
}
