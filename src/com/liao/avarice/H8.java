package com.liao.avarice;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author liaoguixin
 * @data 2023/7/10
 */
public class H8 {
    public static void main(String[] args) {
        //输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        //输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        //解释：
        //编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
        //编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
        //编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
        //编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
        //编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
        //编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
        //因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。

        int[][] people = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2},
        };

        Arrays.stream(reconstructQueue(people)).forEach(a -> System.out.println(a));
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,
                (a,b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return b[0] - a[0];
                }
        );

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1], p);
        }


        return que.toArray(new int[people.length][]);
    }
}
