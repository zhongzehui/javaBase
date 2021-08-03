package com.zehui.datastructure.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map4hash = new HashMap<>();
        Map<String,Object> map4id = new IdentityHashMap<>();


        Parent parent = new Parent();
        parent.setpName("baba");
        Son son = new Son();
        son.setsName("son");
        //ture isAssignableFrom方法判断入参是否为该类对象的子类，子接口；
        System.out.println(Parent.class.isAssignableFrom(Son.class));
       // map4hash.getClass().isAssignableFrom();


    }
}

class Parent {
    private String pName;

    public Parent() {
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public  void tellName(){
        System.out.println(this.pName);
    }

}
class Son extends Parent{
    private String sName;

    public Son() {
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public void tellName() {
        System.out.println(this.sName);
    }
}