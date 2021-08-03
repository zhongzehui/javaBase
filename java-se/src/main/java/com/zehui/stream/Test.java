package com.zehui.stream;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Person person01 = new Person("1", "zhongzh", 19);
        Person person02 = new Person("2", "zhangsan", 22);
        Person person03 = new Person("3", "lisi", 33);
        Person person04 = new Person("4", "wangwu", 129);
        Person person05 = new Person("6", "tom", 190);
        Person person06 = new Person("5", "jack", 26);

        List<Person> people = Arrays.asList(person01,person02,person03,person04,person05,person06);
        people.stream().filter((p) -> p.getAge()>20).forEach(System.out::println);
    }
}
class Person implements Serializable {

    private static final long serialVersionUID = -1695200338289163173L;

    private String id;
    private String name;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
