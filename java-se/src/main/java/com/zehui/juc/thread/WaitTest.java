package com.zehui.juc.thread;

public class WaitTest {

    public static void main(String[] args) {

        try {
            WaitTest test = new WaitTest();
//            WaitTest.class.wait(5000);
            test.wait(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
