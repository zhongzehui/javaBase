package com.zehui.base.enums;

import java.math.BigDecimal;
import java.util.EnumSet;

public class Test4Enum {

    //测试枚举集合EnumSet
    private EnumSet<PizzaSize> discountPizzaSize = EnumSet.of(PizzaSize.EXTRA_LARGE, PizzaSize.LARGE);

    public static void main(String[] args) {

        PizzaSize pizzaSize = Enum.valueOf(PizzaSize.class, "SMALL");//如果传's'，会报错：IllegalArgumentException
        System.out.println(pizzaSize);

        System.out.println(PizzaSize.EXTRA_LARGE.toString());
//        System.out.println(PizzaSize.valueOf("s")); 一样报错: IllegalArgumentException
        System.out.println(PizzaSize.valueOf("EXTRA_LARGE"));

        System.out.println(PizzaSize.EXTRA_LARGE == PizzaSize.valueOf("EXTRA_LARGE"));//ture

        System.out.println(PizzaSize.EXTRA_LARGE.equals(PizzaSize.valueOf("EXTRA_LARGE")));//ture


        //
        Pizza pizza = new Pizza(1, new BigDecimal("102.11"), null, null, "123");
        System.out.println(pizza.getSize());
    }
}
