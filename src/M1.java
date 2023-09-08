import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/6
 */
public class M1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] s = new long[n];
        long[] t = new long[n];
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            s[i] = input.nextLong();
        }
        for (int i = 0; i < n; i++) {
            t[i] = input.nextLong();
        }
        for (int i = 0; i < n; i++) {
            a[i] = input.nextLong();
        }

        System.out.println(cal(n,s,t,a));
    }

    static long cal(int n, long[] s, long[] t, long[] a) {
        long[] dp = new long[n];
        dp[0] = a[0];
        long tmp;
        for (int i = 1; i < n; i++) {
            tmp = 0;
            for (int j = i-1; j >= 0; j--) {
                if (s[j] + t[j] <= s[i]) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp + a[i];
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
