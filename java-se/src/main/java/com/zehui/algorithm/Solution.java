package com.zehui.algorithm;

import java.util.ArrayList;
import java.util.List;


//这个算法，不会实现主要对位运算不熟悉
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //List<String> result = solution.readBinaryWatch(1);
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.readBinaryWatch(2));;
     //   System.out.println(result.toString());
        System.out.println( Integer.toBinaryString(63));
        //表示不同进制的数字
        showNum();

        int i = 1000;
        int h = i >> 6, m = i & 63;
        // i >> 6,移6位，只剩下高位6位；
        //  i & 63;  & 00_0011_11110x
        System.out.println("i=" + i + "\nｈ＝" + h + "\nm=" + m );
    }

    private static void showNum() {
        int numB = 0b00_0011_1111;
        System.out.println("二进制数字0b00_0011_1111的值为"+numB);
        //二进制数字0x00_0011_1111的值为63
        //同理十六进制数字是0x开头，0b是八进制，默认是十进制
    }

    private List<String> readBinaryWatch(int turnedOn) {
        if(turnedOn>10){
            throw new RuntimeException("不能超过10颗灯");
        }
        int[] hours = new int[4];
        int[] minutes = new int[6];
        for (int i = 0; i < turnedOn; i++) {
            int turnedOn4hour = i;
            //获取所有的可能

//            for (int j = 0; j < turnedOn4hour; j++) {
//                //获取小时的结果
//
//            }
            int turnedOn4min = turnedOn-i;
            //获取分钟
        }
        System.out.println(hours[0]);
        return null;
    }


}

//使用枚举办法处理
class Solution2 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}
//使用二进制枚举
class Solution3 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }
}

