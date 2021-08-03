package com.zehui.alibab;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionTest {

    public static void main(String[] args) {

        System.out.println(Objects.equals(null, null));

        testList();
        //testSubList();
        //testfanxing();
        //testIterator();

        //
        //testComparator();



    }

    private static void testComparator() {
       /* 在 JDK7 版本及以上，Comparator 要满足如下三个条件，不然 Arrays.sort，
        Collections.sort 会报 IllegalArgumentException 异常。
        说明：三个条件如下 1） x，y 的比较结果和 y，x 的比较结果相反。
 ——禁止用于商业用途，违者必究—— 10 /35
        阿里巴巴 Java 开发手册
 ——禁止用于商业用途，违者必究—— 11 /35
        2） x>y，y>z，则 x>z。 3） x=y，则 x，z 比较结果和 y，z 比较结果相同。
        反例：下例中没有处理相等的情况，实际使用中可能会出现异常：
        new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() > o2.getId() ? 1 : -1;
            }
        };*/

       //需要处理相同以及不等的情况，大于返回1，小于返回-1，相同则返回0；

    }

    private static void testIterator() {
        //不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
        //方式，如果并发操作，需要对 Iterator 对象加锁。
        //正确使用方式
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(stringList.toString());//[2, 3, 4]

        //反例
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                //  1".equals(item))       没有报错
                // "2".equals(item) java.util.ConcurrentModificationException  //这个不是并发异常，迭代器的报错？
                list.remove(item);
            }
        }
    }

    private static void testfanxing() {
        //        泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用 add 方 法，
//        而<? super T>不能使用 get 方法，做为接口调用赋值时易出错
        MyData<? extends Object> myData = new MyData<>(10);
        // myData.add("String");  //为什么不能用add呢？ 直接编译报错了


    }

    private static void testSubList() {
        //】在 subList 场景中，高度注意对原集合元素个数的修改，会导致子列表的遍历、增加、
        //删除均会产生 ConcurrentModificationException 异常
        //意思是，如果已经执行国subList，不能再对原来的ArrayList进行新增，修改
        List<String> stringList = new ArrayList<>();
        stringList.add("zhong1");
        stringList.add("zhong2");
        stringList.add("zhong3");
        stringList.add("zhong4");
        stringList.add("zhong5");
        stringList.add("zhong6");
        stringList.add("zhong7");
        stringList.add("zhong8");
        //list
        System.out.println(stringList.get(0) + " --" + stringList.get(7));
        String string = stringList.subList(2, 7).toString();//元素从0开始，意思是从第二个开始，到第不包含下标为7的元素，就是不包含第八个元素；
        //[zhong1, zhong2, zhong3, zhong4, zhong5, zhong6, zhong7, haha, zhong8]
        stringList.subList(2, 7).add("haha");//这个不报错
        List<String> sublist = stringList.subList(2, 7);
        //stringList.add(3,"tets1");//ConcurrentModificationException
        stringList.add("tets1");////在list尾部新增也不行 ConcurrentModificationException
        sublist.add("zehui");// 在sublist加反而没问题哦
        System.out.println(string);
        System.out.println(stringList.toString());

    }

    private static void testList() {
        String[] strings = new String[]{"zhong", "ze", "hui"};
        //asList 测试
   /*
   List<String> stringList = Arrays.asList(strings);
        List<String> stringList = Arrays.asList(strings);
//        使用asList转化的list不能进行新增，修改，删除，更新
        stringList.add("haha");
//        还真的会报错呢java.lang.UnsupportedOperationException
        System.out.println(stringList.get(stringList.size()));*/

        //使用jdk8的方式
        List<String> stringList = Arrays.stream(strings)
                .collect(Collectors.toList());


    }
}


class MyData<T> {

    Object[] datas = null;
    int len = 0;

    public MyData(int size) {
        this.len = size;
        this.datas = new Object[size];
    }

    public void add(T data) {

        for (int i = 0; i < len; i++) {
            if (this.datas[i] == null) {
                this.datas[i] = data;
            }
        }
    }

    public T get(int index) {
        return (T) this.datas[index];
    }
}