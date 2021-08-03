package com.zehui.base.aaa;

public class Test {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);//数组的默认值是0;
        }
    }
}
