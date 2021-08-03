package com.zehui.spi.service;

import entity.Person;

public class PersonServiceImpl implements IPersonService {
    @Override
    public Person qryPerson(String id) throws Exception {
        System.out.println("调用成功 ： id==》"+id);
        return null;
    }
}
