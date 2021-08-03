package com.zehui;

public class XilongDemo {
    public static void main(String[] args) {

        boolean isLeapYear = isLeapYear(1900);
        System.out.println(isLeapYear);
        //计算有多少个1
        int bit1Count = bit1Count(1023);
        System.out.println("bit1Count==>" + bit1Count);
        int i = 1 & 3;
        Integer integer = 10;
        int num = (10 >> 2) & 1;

        System.out.println(num);
        //测试异或

        Integer num1 = 10;
        Integer num2 = 20;

        swapByYH(num1, num2);

    }

    private static int bit1Count(int i) {
        int count = 0;
        int index = 0;
        while (index < 32) {
//            int num = ;//(i>>index) & 1) ==1
            if (((i >> index) & 1) == 1) {
                count++;
            }
            index++;
        }

        return count;

    }

    private static boolean isLeapYear(int i) {
        return i > 0 & (i % 400 == 0 || (i % 100 != 0 & i % 4 == 0));
    }


    /**
     * 通过异或来进行交换两个数字
     *      异或：二进制数下，不同为1，相同为0；
     *      ==> 两个相同的数异或是0
     *      ==>任何数与0异或都是这个数
     *                  === > 异或 ：满足交换律和结合律
     * @param num1
     * @param num2
     */
    private static void swapByYH(Integer num1,Integer num2) {
        System.out.println("before: \n num1==>"+num1 + "  \n num2==>"+ num2);

        num2 = num1 ^ num2;

        num1 = num1 ^ num2;

        num2 = num1 ^ num2;

        System.out.println("after: \n num1==>"+num1 + "  \n num2==>"+ num2);

    }

}
