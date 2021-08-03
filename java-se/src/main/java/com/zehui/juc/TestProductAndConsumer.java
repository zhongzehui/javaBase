package com.zehui.juc;

public class TestProductAndConsumer {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10 ; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"D").start();
    }
}



//生产者消费者模式只要记住6个字
//等待，业务，通知
class Data{


    private volatile int num = 0;

    public synchronized  void  increment() throws InterruptedException {
        //Thread.sleep(10);
        if( num!=0 ){ //这里用if会死锁，因为waiti notifyall会存在虚假唤醒的问题
            this.wait();
        }
        num++;//执行业务
        System.out.println("线程："+ Thread.currentThread().getName() +"执行了自增 , num ->"+ num );
        this.notifyAll();
    }

    public synchronized  void  decrement() throws InterruptedException {
       // Thread.sleep(10);
        if( num == 0 ){
            this.wait();
        }
        num--;//执行业务
        System.out.println("线程："+ Thread.currentThread().getName() +"执行了自减 , num ->"+ num );
        this.notifyAll();
    }


}