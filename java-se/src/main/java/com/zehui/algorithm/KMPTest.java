package com.zehui.algorithm;

public class KMPTest {
    public static void main(String[] args) {

        System.out.println(kmpSearch("zehui", "fjnfkjnsadzehuikjgkbzehuisdlhfsdijfzehuisdkjfkze"));
    }

    private static int kmpSearch(String p , String s) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return -1;
        }

        int[] next = getNext2(p);
        // matching: O(n)
        int i = 0, j = 0;
        while (i < sLen && j < pLen) {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * Table building: O(m)
     *
     * @param p 匹配串
     * @return
     */
    private static int[] getNext(String p) {
        int len = p.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = 0, k = -1;
        while (i < len - 1) {
            // p[k]表示前缀，p[i]表示后缀
            if (k == -1 || p.charAt(i) == p.charAt(k)) {
                ++k;
                ++i;
                next[i] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * Table building: O(m)
     * 优化的next数组
     * @param p 匹配串
     * @return
     */
    private static int[] getNext2(String p) {
        int len = p.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = 0, k = -1;
        while (i < len - 1) {
            // p[k]表示前缀，p[i]表示后缀
            if (k == -1 || p.charAt(i) == p.charAt(k)) {
                ++k;
                ++i;
                if (p.charAt(i) != p.charAt(k)) {
                    next[i] = k;
                } else {
                    // 因为不能出现p[i] = p[next[i]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[i] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
