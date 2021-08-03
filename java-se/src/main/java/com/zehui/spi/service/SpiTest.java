package com.zehui.spi.service;

import java.util.Iterator;
import java.util.ServiceLoader;


/**
 * spi使用
 * 定义接口
 * 在META-INF/services/下添加接口全类名文件
 *  例如：com.zehui.spi.service.IPersonService
 * 在文件中添加接口实现类的全类名
 *  例如：
 */
public class SpiTest {

    private static ServiceLoader<IPersonService> personService = ServiceLoader.load(IPersonService.class);

    public static void main(String[] args) {
        Iterator<IPersonService> iterator = personService.iterator();

        while (iterator.hasNext()){
            IPersonService next = iterator.next();
            try {
                next.qryPerson("222");
            } catch (Exception e) {
                e.printStackTrace();e.printStackTrace();
            }
        }
    }


}
