package com.zehui.alibab;

import java.util.Objects;

public class Test {

    public static void main(String[] args) {

        int num1 = 21;
        int num2 = 14 ;
        testSwap(num1,num2);
/*
        Animal animal = new Animal();
        Animal animal2 = new Animal();
        System.out.println(animal.hashCode());
        animal.setId("22");
        animal2.setId("22");
        System.out.println(Objects.equals(animal, animal2));
        //所有相同类型的包装类对象之间值的比较，全部都是用equals方法比较

        Integer integer = new Integer(10);


        String  a = "a,b,c,d,,";
        String[]  strings =a.split(",");
        System.out.println(strings.length);


        String string = "start ";
        for (int i = 0; i < 10 ; i++) {
//            string +=" hello ";
            string  = string + " hello ";
        }
        System.out.println(string);*/
    }

    private static void testSwap(int num1, int num2) {
        num2 = num2 - num1;
        num1 = num1 + num2;
        num2 = num1 - num2;
        System.out.println( "after swap : num1 == " + num1 );
        System.out.println( "after swap : num2 == " + num2 );
    }

}


class  Animal{

    private String id;
    private String name;
    private  Integer age;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        System.out.println("id：：："+this.id);
        return Objects.hash(id);
    }
}