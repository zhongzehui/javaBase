package com.zehui;

/**
 * 有的小伙伴发现自己的IDE并没有抛出Error 这是因为没有显示开启,启用断言 开启方法: vm options 加入 -ea
 *
 */
public class AssertTest {
    public static void main(String[] args) {
        test();
    }

    private static void test() {

        String string = "222";
        String string2 = "2221";

        boolean flag =   string.equals(string2);
        System.out.println(flag);
        assert  flag;

    }
}
