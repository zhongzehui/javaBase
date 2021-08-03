package com.zehui.j8.stream;

import entity.Person;
import sun.dc.path.PathError;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.stream().collect(Collectors.toMap(Person::new, Function.identity()));

        arrayList.forEach((p)->{
            System.out.println(p);
        });
    }
}
