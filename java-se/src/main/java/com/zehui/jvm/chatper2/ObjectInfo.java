package com.zehui.jvm.chatper2;

import entity.Person;
import org.openjdk.jol.info.ClassLayout;

import java.math.BigDecimal;

public class ObjectInfo {
    public static void main(String[] args) {
        ObjectTest objectTest = new ObjectTest();
        ObjectTest objectTest2 = new ObjectTest(new String("nama"), 10);

        ClassLayout classLayout = ClassLayout.parseInstance(objectTest);
        
        System.out.println(classLayout.toPrintable());
        //jdk8默认开启指针压缩
//        -XX:-UseCompressedOops 关闭  72byte 字节
/*
        ClassLayout classLayout2 = ClassLayout.parseInstance(objectTest2);
        System.out.println(classLayout2.toPrintable());
        我发现一样的，因为chars是一个引用对象，占用的是4个字节，value可以是其他的；
        */

        ObjectTest2 objectTest21 = new ObjectTest2();
        System.out.println(ClassLayout.parseInstance(objectTest21).toPrintable());
    }
}

class ObjectTest2 {
    private String name;
    private Integer age;
}


class ObjectTest {
    private String name;
    private Integer age;
    private String address;
    private BigDecimal price;
    private double price2;
    private Double price23;
    private boolean flag;
    private Boolean flag2;
    private char[] chars;

    public ObjectTest() {
    }

    public ObjectTest(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.price = price;
        this.flag = flag;
        this.flag2 = flag2;
        this.chars = new char[age];
    }
}
