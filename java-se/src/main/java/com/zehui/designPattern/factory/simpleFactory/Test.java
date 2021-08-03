package com.zehui.designPattern.factory.simpleFactory;

//简单工厂模式
public class Test {

}

class PizzaSimpleFactory{

    public void getPizza(String type){
        if ("1".equals(type)){
            new Pizza();
        }else  if ("2".equals(type)){
            new MilkPizza();
        }else {
            // ("3".equals(type) )
            new PorkPizza();
        }
    }
}

class Pizza {
    public Pizza() {
        System.out.println("我是简单pizza");
    }
}

class MilkPizza {
    public MilkPizza() {
        System.out.println("我是牛奶pizza");
    }
}

class PorkPizza {
    public PorkPizza() {
        System.out.println("我猪肉pizza");
    }
}