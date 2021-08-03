package com.zehui.juc;

public class Test2 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            synchronized (Test.class){
                System.out.println(111);
            }
            //synchronized锁升级

        }
    }

}
