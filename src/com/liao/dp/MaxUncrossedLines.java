package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/16
 */
public class MaxUncrossedLines {
    public static void main(String[] args) {

        //输入：nums1 = [1,4,2], nums2 = [1,2,4]
        //输出：2
        //解释：可以画出两条不交叉的线，如上图所示。
        //但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。

        int[] nums1 = {
            1,4,2
        };

        int[] nums2 = {
            1,2,4
        };

        System.out.println(maxUncrossedLines(nums1, nums2));

    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n1][n2];
    }
}
