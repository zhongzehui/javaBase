package com.zehui.juc.thread.base.threadlocal;

import java.util.ArrayList;
import java.util.List;

public class ThreadData {
    /*

    ThreadLocal提供了一种访问某个变量的特殊方式：访问到的变量属于当前线程，即保证每个线程的变量不一样，而同一个线程在任何地方拿到的变量都是一致的，这就是所谓的线程隔离。
如果要使用ThreadLocal，通常定义为private static类型，在我看来最好是定义为private static final类型。
     */
    public static final ThreadLocal<List<String>> data = new ThreadLocal<>();

    private static final ThreadLocal<List<String>> data2 = new ThreadLocal<List<String>>(){
        /**
         * 使用的化建议重写initialvalue方法，不然get会空指针；
         * @return
         */
        @Override
        protected List<String> initialValue() {
            return super.initialValue();
        }
    };



    /**
     * ThreadLocal通常用来共享数据，当你想在多个方法中使用某个变量，这个变量是当前线程的状态，其它线程不依赖这个变量，
     * 你第一时间想到的就是把变量定义在方法内部，然后再方法之间传递参数来使用，这个方法能解决问题，但是有个烦人的地方就是，
     * 每个方法都需要声明形参，多处声明，多处调用。影响代码的美观和维护。有没有一种方法能将变量像private static形式来访问呢？
     * 这样在类的任何一处地方就都能使用。这个时候ThreadLocal大显身手了。
     *
     * @return
     */

    public static List<String> get() {

        List<String> stringList = data.get();

        if (stringList == null) {
            List<String> objects = new ArrayList<>();
            objects.add("zhang3");
            objects.add("lisi4");
            objects.add("wangwu5");
            objects.add(Thread.currentThread().getName());
            data.set(objects);
            stringList = data.get();

        }
        return stringList;

    }


}
