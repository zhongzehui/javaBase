package com.zehui.forkjoin;


import java.util.OptionalLong;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

//使用代码求和，求1+++10_0000_0000L
public class Test {


    public static void main(String[] args) {
      //  test01();
      //  test02();
        test03();
    }

    private static void test01() {
        //49 9999 7625 8127 7952
        //计算结果是：50 0000 0005 0000 0000  耗时： 392 ms
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 1; i <= 10_0000_0000L ; i++) {
            sum = i+sum;
        }
        long end = System.currentTimeMillis();
        System.out.println("计算结果是："+ sum + "  耗时： " +(  end-start ) +" ms");
    }

    //forkjoin 执行成功；结果为500000000500000000 耗时为： 2931 ms
    private static void test02() {
//        long n1 = 100;
//        long n2 = 1;
//        System.out.println( (n1+n2)/2 );
        long start_time = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        try {
            long result = submit.get();
            long end_time = System.currentTimeMillis();
            System.out.println("forkjoin 执行成功；结果为"+ result +" 耗时为： " + (end_time-start_time) + " ms") ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    //使用stream处理
    // stream 执行成功；结果为500000000500000000 耗时为： 576 ms
    private static void test03() {
        long start_time = System.currentTimeMillis();
        OptionalLong reduce = LongStream.rangeClosed(1L, 10_0000_0000L).parallel().reduce((l1, l2) -> {
            return l1 + l2;
        });
        long result = reduce.getAsLong();
        long end_time = System.currentTimeMillis();
        System.out.println("stream 执行成功；结果为"+ result +" 耗时为： " + (end_time-start_time) + " ms") ;
    }
}

class ForkJoinDemo  extends RecursiveTask<Long> {

    private long start;

    private long end;

    private long temp = 500l;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum = 0L;
        boolean canCompute = (end - start)<temp;
        if(canCompute){

            for (long i = start; i <=  end; i++) {
//                sum = i +sum;
                sum +=i;
            }
        }else{
            long midVal = (end + start)/2;
            ForkJoinDemo forkJoinDemo01 = new ForkJoinDemo(start,midVal);
            forkJoinDemo01.fork();
            ForkJoinDemo forkJoinDemo02 = new ForkJoinDemo(midVal+1,end);
            forkJoinDemo02.fork();
            sum =  forkJoinDemo01.join() + forkJoinDemo02.join();
        }
        return sum;
    }
}

