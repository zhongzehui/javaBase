package com.zehui.designPattern.singleton;


public enum SingleEnum {

    INSTANCE;

    public void syaOK() {
        //执行单例对象的功能
        System.out.println("OKOK!");
    }

    SingleEnum() {
        System.out.println("执行了构造参数！");
    }
}