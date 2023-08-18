package com.liao.redo;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/17
 */
public class L139 {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict,"leet","code");
        System.out.println(wordBreak("leetcode", wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j,i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
