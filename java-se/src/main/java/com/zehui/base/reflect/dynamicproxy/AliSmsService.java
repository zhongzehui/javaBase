package com.zehui.base.reflect.dynamicproxy;

/**
 * 使用cglib来实现动态代理
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}