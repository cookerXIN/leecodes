package com.liao.test;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/7/24
 */
public class G7 {
    public static void main(String[] args) {
        problem2();
    }

    public static void problem1() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);

        BigInteger subtract = b1.subtract(b2);
        System.out.println(subtract);
    }

    public static void problem2() {
        //8 3
        //1 3 -1 -3 5 3 6 7
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 单调队列应用
        // 保存最大值的队列 将滑动窗口的值索引按照值从大到小的顺序，添加在队列中（单调递增队列）
        int[] res1 = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 控制当前最大值索引是否在窗口内 如果在窗口外 则将其剔除
            // 因为窗口是每次只滑动一步，所以只用将最边缘的淘汰掉
            if (!q.isEmpty() && i - q.getFirst() > k-1) {
                q.pollFirst();
            }
            // 将小于当前值的索引都移除队列
            while (!q.isEmpty() && arr[q.getLast()] < arr[i]) {
                q.pollLast();
            }
            // 由于上面已经将小于当前值并且在队列前面的索引索引移除 因此只用将其添加到队列最后 当成替补最大值
            q.addLast(i);
            // 如果满足一个窗口大小 则将当前窗口最大值添加 为了排除前几个数添加还不满足一个窗口大小的情况
            if (i >= k-1) {
                res1[i-k+1] = arr[q.getFirst()];
            }
        }

        // 单调递减队列 同上 用于保存最小值索引
        int[] res2 = new int[n-k+1];
        q.clear();
        for (int i = 0; i < n; i++) {
            if(!q.isEmpty() && i - q.getFirst() > k-1) {
                q.pollFirst();
            }
            while (!q.isEmpty() && arr[q.getLast()] > arr[i]) {
                q.pollLast();
            }
            q.addLast(i);
            if (i >= k-1) {
                res2[i-k+1] = arr[q.getFirst()];
            }
        }

        // 获取最大和最小值差的最大值
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < res1.length; i++) {
            res = Math.max(res, res1[i]-res2[i]);
        }

        System.out.println(res);
    }
}
