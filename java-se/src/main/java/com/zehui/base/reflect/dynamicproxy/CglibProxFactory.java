package com.zehui.base.reflect.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * 生成代理对象的工厂
 *
 */
public class CglibProxFactory {

    public static Object getProxy4DebugMethod(Class<?> clz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }


}
