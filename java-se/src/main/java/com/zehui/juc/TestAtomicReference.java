package com.zehui.juc;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {
    //定义AtomicReference类型BigDecimal变量
    static AtomicReference<BigDecimal> number = new AtomicReference<BigDecimal>(BigDecimal.ZERO);

    public static void main(String[] args) throws Exception {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    //手动写循环+CAS判断
                    while (true) {
                        BigDecimal pre = number.get();
//                        BigDecimal next = number.get().add(BigDecimal.ONE);
                        BigDecimal next = pre.add(BigDecimal.ONE);
                        if (number.compareAndSet(pre, next)) {
                            break;
                        }
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();

        Thread t2 = new Thread(runnable);
        t2.start();
        //Waits for this thread to die.
        //An invocation of this method behaves in exactly the same way as the invocation
        t1.join();
        t2.join();

        System.out.println(number.get());

    }
}
