package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/8
 */
public class L215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
    static int M = 10010, N = 2 * M;
    static int[] tr = new int[N];
    static int lowbit(int x) {
        return x & -x;
    }
    static int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tr[i];
        return ans;
    }
    static void add(int x) {
        for (int i = x; i < N; i += lowbit(i)) tr[i]++;
    }
    public static int findKthLargest(int[] nums, int k) {
        for (int x : nums) add(x + M);
        int l = 0, r = N - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (query(N - 1) - query(mid - 1) >= k) l = mid;
            else r = mid - 1;
        }
        return r - M;
    }
}
