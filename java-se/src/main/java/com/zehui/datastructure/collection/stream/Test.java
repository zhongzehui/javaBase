package com.zehui.datastructure.collection.stream;

import entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "张三", "zs", "gz"));
        personList.add(new Person(2, "张三1", "zs", "gz1"));
        personList.add(new Person(3, "张三2", "zs", "gz2"));
        personList.add(new Person(4, "张三3", "zs", "gz"));
        personList.add(new Person(5, "张三4", "zs", "gz3"));
        personList.add(new Person(6, "张三5", "zs", "gz"));
        personList.add(new Person(7, "张三6", "zs", "gz"));
        personList.add(new Person(8, "张三7", "lisi", "gz2"));
        personList.add(new Person(9, "张1三", "wangwu", "111gz"));
        personList.add(new Person(10, "张2三", "zhaoliu", "g2z"));
        personList.add(new Person(11, "张3三", "zhong", "1gz"));


        List result = personList.parallelStream().filter(person -> "zs".equals(person.getCode()))
                .map(person -> person.getName())
                .collect(Collectors.toList());

        String endpoints = "";
        result.stream().forEach(name-> System.out.println(name));
        System.out.println("##############");
        result.stream().forEach(System.out::println);



    }
}
