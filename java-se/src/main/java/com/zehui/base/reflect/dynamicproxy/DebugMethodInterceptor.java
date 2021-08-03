package com.zehui.base.reflect.dynamicproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理拦截器：
 *      执行代理逻辑
 *          代理方法执行前执行代码
 *          代理方法执行后执行代码
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param o 被代理的对象
     * @param method  被拦截的方法
     * @param objects  方法入参
     * @param methodProxy   用于调用原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before oprate ...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("before oprate ...");
        return result;
    }
}
