package com.liao.dp;

import java.util.*;

/**
 * @author liaoguixin
 * @data 2023/7/14
 */
public class WordBreak {

    public static void main(String[] args) {
        //输入: s = "leetcode", wordDict = ["leet", "code"]
        //输出: true
        //解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成

        String s = "leetcode";
        List<String> words = new ArrayList<>();
        Collections.addAll(words, "leet", "code");
        System.out.println(wordBreak(s,words));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (set.contains(s.substring(j,i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[length];
    }
}
