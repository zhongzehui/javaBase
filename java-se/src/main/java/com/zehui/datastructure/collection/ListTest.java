package com.zehui.datastructure.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
        //jdk8推荐使用数组转集合的方式
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(myList.getClass().getName());




    }
}
