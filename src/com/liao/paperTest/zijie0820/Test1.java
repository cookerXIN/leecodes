package com.liao.paperTest.zijie0820;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/21
 */
public class Test1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t > 0) {
            int n = input.nextInt();
            int k = input.nextInt();

            int[] p = new int[3];
            int[] q = new int[3];

            for (int i = 0; i < 3; i++) {
                p[i] = input.nextInt();
            }

            Arrays.sort(p);
            if (3 * k > n) {
                System.out.println("-1");
                t--;
                continue;
            }

            q[0] = p[1] - p[0];
            q[1] = p[2] - p[1];
            q[2] = p[0] + n - p[1];

            int res = 0;

            while (q[0] < k) {
                int min = Math.min(k - q[0], q[2] - k);
                res += min;
                q[2] -= min;
                q[0] += min;
                Arrays.sort(q);
            }

            System.out.println(res);
            t--;
        }


    }

}
