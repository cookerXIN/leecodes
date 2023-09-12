package com.liao.paperTest.zijie;
import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/9/10
 */
public class Test4 {
    private static final int MOD = 1000000007;

    public static int countDiffStrings(int n, int k) {
        if (k == 1 || n == k) {
            return 0;
        }

        long result = 1;
        for (int i = 0; i < 2 * k - 2; i++) {
            result = (result * 2) % MOD;
        }

        result = (result - 1 + n - 2 * k + 2 + MOD) % MOD;
        return (int) result;
    }

    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(countDiffStrings(n, k));
        }
    }
}
