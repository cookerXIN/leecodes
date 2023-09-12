package com.liao.paperTest.huawei.huawei0524;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/28
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        Map<String, LinkedList<Integer>> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        while (n-- > 0) {
            String str = input.nextLine();
            String[] split = str.split(":");
            if (!map.containsKey(split[1])) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(Integer.parseInt(split[0]));
                map.put(split[1], list);
                continue;
            }

            LinkedList<Integer> linkedList = map.get(split[1]);
            if (Integer.parseInt(split[0]) - linkedList.get(linkedList.size() - 1) < 10) {
                res.add(str);
                continue;
            }
            if (linkedList.size() == 9) {
                if (Integer.parseInt(split[0]) - linkedList.get(0) < 100) {
                    res.add(str);
                    continue;
                } else {
                    linkedList.remove(0);
                    linkedList.add(Integer.parseInt(split[0]));
                    continue;
                }
            }

            linkedList.add(Integer.parseInt(split[0]));
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
