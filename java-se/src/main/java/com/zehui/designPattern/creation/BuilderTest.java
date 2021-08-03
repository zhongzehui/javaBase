package com.zehui.designPattern.creation;


/**
 * 建造者模式:
 *  使用多个简单的对象一步一步构建成一个复杂的对象。
 * 一个Builder类会一步一步构造最终的对象。该Builder类是独立于其他对象的。
 *  将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
 */
public class BuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1").append(1).append(true).append(22d);
        System.out.println(stringBuilder);
    }
}
