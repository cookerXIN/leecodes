package com.liao.avarice;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @data 2023/7/9
 */
public class A1 {
    public static void main(String[] args) {
        //输入: g = [1,2,3], s = [1,1]
        //输出: 1
        //解释:
        //你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
        //虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
        //所以你应该输出1。

        int[] g = {1,2,3};
        int[] s = {1,1};

        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int idx = s.length - 1;

        for (int i = g.length - 1; i >= 0; i--) {
            if (idx < 0) {
                break;
            }
            if (s[idx] >= g[i]) {
                count++;
                idx--;
            }
        }

        return count;
    }
}
