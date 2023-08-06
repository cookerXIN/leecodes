package com.liao.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/7/31
 */
public class H22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static List<String> generateParenthesis(int n) {
        backtrack(n,0,0);
        return list;
    }
    public static void backtrack(int n, int open, int close) {
        // 当字符串的长度为n的2倍 则可以返回添加
        if (sb.length() == n*2) {
            list.add(sb.toString());
            return;
        }
        // 添加小于n的左括号
        if (open < n) {
            sb.append("(");
            backtrack(n, open+1, close);
            // 每次回溯将左括号删除 由于open+1是在方法执行 是行参 则open不用回溯
            sb.deleteCharAt(sb.length() - 1);
        }
        // 添加与左括号一致的右括号 右括号永远不会前缀数量大于左括号
        if (close < open) {
            sb.append(")");
            backtrack(n, open, close+1);
            // 回溯删除右括号
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//思路 就按我的写
//只在序列仍然保持有效时才添加括号,
//通过跟踪到目前为止放置的左括号和右括号的数目，
//如果左括号数量不大于 n，则可以放一个左括号。
// 如果右括号数量小于左括号的数量，我们可以放一个右括号。














