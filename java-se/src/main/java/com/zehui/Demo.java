package com.zehui;

public class Demo {

    public void show() {
        System.out.println("6666");
    }

    public static void run(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {
        Demo d = new Demo();

        Demo finalD1 = d;
        run(new Runnable() {
            @Override
            public void run() {
                finalD1.show();//1、报错，d需要是final或事实上的final
            }
        });

        Demo finalD = d;
        run(() -> finalD.show());//2、报错，d需要是final或事实上的final



        run(d::show);//3、不报错，可执行

        d = null;


    }
    public void testFeild(){
        //因为成员变量是跟随
        run(() -> innerClass.show());
        Demo d = new Demo();
        run(() -> d .show());

    }


    private InnerClass innerClass = new InnerClass();
}

class InnerClass{

    public void show(){
        System.out.println(Thread.currentThread().getName()+ "==> show");
    }
}