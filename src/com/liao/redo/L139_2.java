package com.liao.redo;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/5
 */
public class L139_2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "leet","code");

        System.out.println(wordBreak("leetcode", list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < len; i++) {
                String sub = s.substring(i, len);
                System.out.println(sub);
                if (set.contains(sub) && dp[i]) {
                    dp[len] = true;
                }
            }
        }

        return dp[n];
    }
}
