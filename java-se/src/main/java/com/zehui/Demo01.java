package com.zehui;

public class Demo01 {
    public static void main(String[] args) {


       /* String  test = "test";
        System.out.println(test.hashCode());

        char a ;
        int num = 106;
        a = (char) num;

        System.out.println(a);


        //测试下中文
        char cn = '钟';//        //测试下中文

        System.out.println((int)cn);



        int num = 2;
        int num1 = num * 31;
        int num2 = ( num << 5 ) - num ;

        System.out.println("num1 = "+ num1
                + " \n" + "num2 = "+ num2);
        Demo01 d = new Demo01();
        MyObject myObject = d.new MyObject();
        System.out.println(myObject.hashCode());
        myObject.setAge(2);
        System.out.println(myObject.hashCode());
        ///
        System.out.println(hash(myObject) );
        System.out.println( 5 & 4);

        int cNum = Integer.MAX_VALUE;

        System.out.println("计算"+cNum + "的位运算" + (cNum >>>16 ) );
        */


        //System.out.println(Float.MAX_VALUE < Integer.MAX_VALUE); //占用空间一样，都是4个字节，32位，但是float 最大值比int大

        //System.out.println(Integer.MAX_VALUE << 2 );


    }

    /*
            >>> 是无符号位运算符
            ^异或运算符顾名思义，异就是不同，其运算规则为1^0 = 1 , 1^1 = 0 , 0^1 = 1 , 0^0 = 0
     */
    static final int hash(Object key) {
        int h;
        System.out.println("hashcode是 " + key.hashCode());

        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public class MyObject {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "MyObject{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
