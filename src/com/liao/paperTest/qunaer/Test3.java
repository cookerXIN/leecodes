package com.liao.paperTest.qunaer;

/**
 * @author liaoguixin
 * @date 2023/9/15
 */
public class Test3 {
    public static double winningProbability(int N, int a, int b) {
        double[] memo = new double[101];
        for (int i = 0; i <= 100; i++) {
            memo[i] = -1.0; // 初始化为-1表示该状态还未被计算
        }
        return helper(N, a, b, 0, memo);
    }

    private static double helper(int N, int a, int b, int sum, double[] memo) {
        if (sum >= b) {
            return 0;
        } else if (sum >= a) {
            return 1;
        }
        if (memo[sum] != -1.0) {
            return memo[sum];
        }
        double prob = 0;
        for (int i = 1; i <= N; i++) {
            prob += helper(N, a, b, sum + i, memo);
        }
        memo[sum] = prob / N;
        return memo[sum];
    }

    public static void main(String[] args) {
        int N = 10, a = 17, b = 21;
        System.out.printf("%.5f",winningProbability(N, a, b)); // 输出获胜的概率
    }
}
