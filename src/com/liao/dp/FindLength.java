package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/16
 */
public class FindLength {
    public static void main(String[] args) {
        //输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
        //输出：3
        //解释：长度最长的公共子数组是 [3,2,1] 。

        int[] nums1 = {
                1,2,3,2,1
        };

        int[] nums2 = {
                3,2,1,4,7
        };

        System.out.println(findLength(nums1, nums2));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[m+1][n+1];
        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
