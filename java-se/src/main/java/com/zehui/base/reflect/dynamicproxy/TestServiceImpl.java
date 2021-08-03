package com.zehui.base.reflect.dynamicproxy;

import java.util.Date;

public class TestServiceImpl implements ITestService {
    @Override
    public String tellTime(String world) {

        System.out.println(world+new Date().toString());
        return "hahah: "+ new Date().toString() ;
    }
}
