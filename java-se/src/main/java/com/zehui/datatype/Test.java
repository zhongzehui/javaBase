package com.zehui.datatype;

public class Test {
    public static void main(String[] args) {

        byte b1 = -128;//一个字节 -128~127
        System.out.println(b1);
        char ch1 = 66;  //使用int会发生强转，对应为ascc码表中的字符,如66对应字符a
        char ch2 = '钟';  //使用int会发生强转，对应为ascc码表中的字符 钟-->38047
        System.out.println(ch2);
        //结果是true
        System.out.println(new Integer(1000).equals(new Integer(1000)));
        //结果是false ，因为地址不一样
        System.out.println(new Integer(1000) == new Integer(1000));


        Integer integer1 = 127;
        Integer integer2 = 127;
        System.out.println(integer1 == integer2);//true， 127在常量池里面
        Integer integer3 = 1270;
        Integer integer4 = 1270;
        System.out.println(integer3 == integer4);//false 因为1270不在常量池里面
        //类似的还有其他数据类型，例如char boolean byte short long duble
        /**
         * Java 基本类型的包装类的大部分都实现了常量池技术。
         * Byte,Short,Integer,Long 这 4 种包装类默认创建了数值 [-128，127] 的相应类型的缓存数据，
         * Character 创建了数值在[0,127]范围的缓存数据，Boolean 直接返回 True Or False
         */




    }
}
