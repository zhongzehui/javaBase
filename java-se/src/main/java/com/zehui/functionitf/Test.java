package com.zehui.functionitf;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {

    public static void main(String[] args) {
        //函数接口主要有四个
        //第一个 ： java.util.function.Function 功能型接口

        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String o) {
                return new Date().toString() + o;
            }
        };
        //function与下面的例子一样的
        Function<String, String>  function2 = (Str)->{
            return new Date().toString() + Str;
        };

        System.out.println( function.apply("sdfd") ) ;


        //第二个java.util.function.Consumer  消费型接口
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(new Date().toString() + s);
            }
        };
        consumer.accept("zhongzh7");

        Consumer<String> consumer2 = (str)->{
            System.out.println(new Date().toString() + str );
        };
        //其中consumer和consumer2一样效果
        consumer2.accept("zhongzh7");

        //java.util.function.Predicate 判断型接口
        Predicate<String> stringPredicate = (str)->{
            return "zhongzh".equals(str);
        };
        System.out.println("判断型接口返回值 : "+ stringPredicate.test("zhongzh"));


        //java.util.function.Supplier
        Supplier<String> testSup = ()->{
            return " nihao helloworld ";
        };
        System.out.println("testSup输出结果"  + testSup.get() );
    }
}
