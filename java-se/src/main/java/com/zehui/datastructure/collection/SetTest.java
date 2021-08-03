package com.zehui.datastructure.collection;

        import java.util.HashSet;
        import java.util.Set;

public class SetTest {
    public static void main(String[] args) {

        Set<Integer> integerSet = new HashSet<>(4);
        integerSet.add(7);
        integerSet.add(6);
        integerSet.add(4);
        integerSet.add(5);
        integerSet.add(10);
        integerSet.add(9);
        integerSet.add(8);

        for (Integer integer : integerSet) {
            System.out.println(integer);
        }

        Set<String> stringSet = new HashSet<>(4);
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");
        stringSet.add("d");
        stringSet.add("q");
        stringSet.add("w");
        stringSet.add("e");
        stringSet.add("r");
        stringSet.add("t");
        stringSet.add("y");
        stringSet.add("i");
        for (String s : stringSet) {
            System.out.println(s);
        }


    }
}
