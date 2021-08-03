package com.zehui.base.reflect.dynamicproxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        dynamic4Jdk();
        dynamic4Cglib();
    }

    private static void dynamic4Cglib() {
        AliSmsService aliSmsService = (AliSmsService) CglibProxFactory.getProxy4DebugMethod(AliSmsService.class);
        System.out.println(aliSmsService.send(" i` ve been proxyed!!"));

    }

    private static void dynamic4Jdk() {
        ITestService service = new TestServiceImpl();
        LogInvocationHandler logInvocationHandler = new LogInvocationHandler(service);
     /*   ITestService service2 = (ITestService) Proxy.newProxyInstance(ITestService.class.getClassLoader(), ITestService.class.getInterfaces(),
                logInvocationHandler);
ClassCastException 报错
                 */
        ITestService service2 = (ITestService) Proxy.newProxyInstance(TestServiceImpl.class.getClassLoader(), TestServiceImpl.class.getInterfaces(),
                logInvocationHandler);
        System.out.println(service2.tellTime(" zhongzh7"));
    }
}
