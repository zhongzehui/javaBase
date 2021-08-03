package com.zehui.j8.lambda;

import java.util.function.BiFunction;

public class LambdaTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        new Thread(()-> apple.adam(),"gi");
        test1();
    }

    private static void test1() {

        //bifunction 测试方法引用
        BiFunction<String,Float,Apple> constructor = Apple::new;
        Apple hahah = constructor.apply("hahah", new Float("1123.22"));
        hahah.adam();


    }
}

class Apple {
    private String type;
    private Float weight;

    public void adam() {
        System.out.println(type + weight);

    }

    public String hawa() {
        return type + weight;
    }

    public Apple() {
    }

    public Apple(String type, Float weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
