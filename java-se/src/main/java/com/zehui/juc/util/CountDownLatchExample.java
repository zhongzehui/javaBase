package com.zehui.juc.util;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CountDownLatchExample {
    // 处理文件的数量
    private static final int threadCount = 6;

    public static void main(String[] args) {
        CountDownLatchExample countDownLatchExample = new CountDownLatchExample();
        countDownLatchExample.demo01();
        countDownLatchExample.demo02();

    }

    /**
     * 使用CompletableFuture来改进
     */
    private void demo02() {

        //文件夹位置
        List<String> filePaths = Arrays.asList(new String[]{"nice", "hello world"});

        // 异步处理所有文件
        List<CompletableFuture<String>> fileFutures = filePaths.stream()
                .map(filePath -> doSomeThing(filePath))
                .collect(Collectors.toList());
        // 将他们合并起来
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                fileFutures.toArray(new CompletableFuture[fileFutures.size()])
        );
    }

    /**
     * 批量处理文件任务
     *
     * @param filePath
     * @return
     */
    private CompletableFuture<String> doSomeThing(String filePath) {
        System.out.println(filePath + "==>下载成功");
        return CompletableFuture.supplyAsync(()->{
            String result = filePath + " --- " +  UUID.randomUUID().toString() ;
            return result;
        });
    }

    private void demo01() {
        // 创建一个具有固定线程数量的线程池对象（推荐使用构造方法创建）
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4,
                100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024),
                new ThreadPoolExecutor.AbortPolicy());
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPoolExecutor.execute(() -> {
                try {
                    //处理文件的业务操作
                    //......
                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                finally {
                    //表示一个文件已经被完成
                    countDownLatch.countDown();
                }

            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
        System.out.println("finish");
    }
}
