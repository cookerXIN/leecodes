package com.liao.paperTest.zijie0820;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/21
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Map<Integer, Integer>> list = new ArrayList<>();
        List<Set<Integer>> haveList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new HashMap<Integer, Integer>());
            haveList.add(new HashSet<Integer>());
        }

        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int v = input.nextInt();
            String c = input.next();

            if (c.equals("S")) {
                list.get(0).put(a,v);
                haveList.get(0).add(a);
            } else if (c.equals("H")) {
                list.get(1).put(a,v);
                haveList.get(1).add(a);
            } else if (c.equals("D")) {
                list.get(2).put(a,v);
                haveList.get(2).add(a);
            } else if (c.equals("C")) {
                list.get(3).put(a,v);
                haveList.get(3).add(a);
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            Set<Integer> set = haveList.get(i);
            Map<Integer, Integer> map = list.get(i);
            if (set.size() < 5) {
                continue;
            }

            for (Integer num : set) {
                int cnt = map.get(num);
                boolean flag = true;
                for (int j = num + 1; j <= 4 + num; j++) {
                    if (!map.containsKey(j)) {
                        flag = false;
                        break;
                    }
                    cnt = Math.min(cnt, map.get(j));
                }
                if (flag) {
                    sum += cnt;
                    for (int j = num + 1; j <= 4 + num; j++) {
                        map.put(j, map.get(j) - cnt);
                    }
                }

            }
        }

        System.out.println(sum);
    }
}
