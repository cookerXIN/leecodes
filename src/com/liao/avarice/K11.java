package com.liao.avarice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/11
 */
public class K11 {
    public static void main(String[] args) {

        //输入：s = "ababcbacadefegdehijhklij"
        //输出：[9,7,8]
        //解释：
        //划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
        //每个字母最多出现在一个片段中。
        //像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。

        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] edges = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edges[chars[i] - 'a'] = i;
        }

        List<Integer> list = new ArrayList<Integer>();
        int start = -1;
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            last = Math.max(edges[chars[i] - 'a'], last);
            if (last == i) {
                list.add(last - start);
                start = last;
            }
        }

        return list;
    }
}
