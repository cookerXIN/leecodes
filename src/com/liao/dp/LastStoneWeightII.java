package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/13
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        //输入：stones = [2,7,4,1,8,1]
        //输出：1
        //解释：
        //组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
        //组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
        //组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
        //组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值

        int[] stones = {
                31,26,33,21,40
        };
        System.out.println(lastStoneWeightII(stones));
    }

    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }
}
