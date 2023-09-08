package com.liao.test.ke0729;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liaoguixin
 * @date 2023/9/5
 */
public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> str = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String line = sc.nextLine();
            str.add(line);
        }
        // 使用正则表达式提取时间戳
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}");
        Map<String, String> map = new HashMap<>();
        for (String inputString : str) {
            Matcher matcher = pattern.matcher(inputString);
            if (matcher.find()) {
                String timestamp = matcher.group();
                map.put(inputString, timestamp);
            }
        }
        // 按照时间戳相同、长度从小到大、ASCII码值从小到大的顺序进行排序
        List<Map.Entry<String, String>> sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, (e1, e2) -> {
            int t = e1.getValue().compareTo(e2.getValue());
            if (t != 0) {
                return t;
            } else {
                int length = Integer.compare(e1.getKey().length(), e2.getKey().length());
                if (length != 0) {
                    return length;
                } else {
                    return e1.getKey().compareTo(e2.getKey());
                }
            }
        });
        // 输出排序后的字符串
        System.out.println("排序后的字符串：");
        String pre = "";
        for (Map.Entry<String, String> entry : sortedList) {
            String cur = entry.getKey();
            if (!cur.equals(pre)) {
                System.out.println(cur);
            }
            pre = cur;
        }
        sc.close();
    }
}
