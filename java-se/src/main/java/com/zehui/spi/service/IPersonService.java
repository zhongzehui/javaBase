package com.zehui.spi.service;

import entity.Person;

public interface IPersonService {

    public Person qryPerson(String id) throws Exception;

}
