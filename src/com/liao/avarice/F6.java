package com.liao.avarice;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @data 2023/7/10
 */
public class F6 {
    public static void main(String[] args) {
        //输入：ratings = [1,0,2]
        //输出：5
        //解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
        int[] ratings = {
                1,3,2,2,1
        };
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int[] candyNums = new int[ratings.length];
        candyNums[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candyNums[i] = candyNums[i-1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candyNums[i] = Math.max(candyNums[i+1] + 1, candyNums[i]);
            }
        }

        return Arrays.stream(candyNums).sum();
    }
}
