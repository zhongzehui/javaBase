package com.zehui.designPattern.singleton;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Test {

    public static void main(String[] args) {
        //PrintService instance = PrintService.getInstance();

        AtomicStampedReference<String> stringAtomicStampedReference = new AtomicStampedReference<>("zhongzh7",1);
       // stringAtomicStampedReference.compareAndSet("zhong", , , )
        AtomicReference<String> atomicReference = new AtomicReference<>();

        atomicReference.compareAndSet("2", "3");



        //尝试枚举
        SingleEnum singleEnum = SingleEnum.INSTANCE;
        SingleEnum singleEnum2 = SingleEnum.INSTANCE;
        System.out.println(singleEnum.equals(singleEnum2));
        System.out.println(singleEnum == singleEnum2);

        singleEnum.syaOK();
    }
}


class PrintService {
    private static PrintService printService;
    private PrintService() {
    }
    public static PrintService getInstance() {
        if (printService == null) {

            synchronized (PrintService.class) {
                if (printService == null) {
                    printService = new PrintService();
                }
            }
        }
        return printService;
    }
}

//类的静态属性只有第一次加载的时候初始化（类装载机制），jvm帮我们保证了线程安全性；
class SingleTon{
    private static volatile SingleTon singleTon;
    private SingleTon(){}
    private static class SingleTonInstance {
        private static final  SingleTon INSTANCE = new SingleTon();
    }

    public static synchronized SingleTon getInstance(){
        return SingleTonInstance.INSTANCE ;
    }
}


