package com.zehui;

public class Demo1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 3,4,4,44};
        int num = unique(array);
        System.out.println(num);
    }


    /**
     * 因为已经排好序，所以定义Integer.MAX_VALUE为空
     * @param array
     * @return
     */
    private static int unique(int[] array) {

        int count = 0;

        if (array == null || array.length < 2) {
            return count;
        }
        //去重
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == Integer.MAX_VALUE) {
                continue;
            }
            // 第二个循环，拿后面的数进行对比
            for (int j = i + 1; j < array.length; j++) {
                //判断是否重复数据
                if (array[j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (array[i] == array[j]) {
                    //赋值
                    array[j] = Integer.MAX_VALUE;
                }
            }
        }
        //移位，数组中间的Integer.MAX_VALUE
        int end = array.length - 1;//数组最后的数字的下标
        for (int i = 0; i < array.length; i++) {
            if (array[i] == Integer.MAX_VALUE) {
                end = i;
                //遍历数组后面的数据，然后放到当前位置
                for (int j = i + 1; j < array.length; j++) {
                    //找到后面第一个去重后的数字，往前移动
                    // 判断是否为Integer.MAX_VALUE,不是则移到前面队尾end
                    if (array[j] != Integer.MAX_VALUE) {
                        array[i] = array[j];
                        //设置移动后的数字为Integer.MAX_VALUE
                        array[j] = Integer.MAX_VALUE;
                        //终止这次遍历
                        break;
                    }
                }
            }
        }

        for (int i = 1; i < array.length; i++) {

            if(array[i]==Integer.MAX_VALUE){
                count++;
            }

        }

        return array.length-count;

    }
}
