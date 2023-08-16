package com.liao.paperTest.dajiang0813;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/15
 */
public class Test2 {

    // 周末放假了，小疆计划骑着自己的电动车去航拍。小疆打开DjiFly上的去哪拍，找到了多个航拍点。
    // 为了规划路线，小疆提前了解了不同的航拍点之间的连通性和距离，同时还确认了每个航拍点充电桩的充电速率。
    // 小疆的电动车满电电量可行驶的距离为dis，单位km，该电动车每行驶1km消耗1单位电量且耗费1min，
    // 一共N个航拍点，每个航拍点都有充电桩，使用二维数组paths标识两个航拍点的双向连通性和距离:
    // [(航拍点编号，相邻航拍点编号，两个航拍点的距离]1，示例:[[0,1,3],[0,2,2]...]，
    // 其中(0,1,3]就表示编号为0的航拍点和编号为1的航拍点相距3km，所有航拍点间的距离都小于dis，
    // 数组charge表示在每个航拍点充1单位电的花费的分钟数，示例:[2,10]，2表示编号为0的航拍点充电1单位耗时2分钟，
    // 10表示编号为1的航拍点充电1单位耗时10分钟。小疆当前在航拍点a，且电动车无电，
    // 请问小疆最少花费多少分钟数从所在的航拍点a抵达航拍点b。
    // 输入描述:
    //  1、paths: 标识两个航拍点的双向连通性和距离
    //  (先输入航拍点距离的二维数组长度，比如6 3，表示6组数据，每组3个数值。再跟具体的数组内容)
    //  2、dis:电动车满电行驶里程
    //  3、a:航拍点a的编号
    //  4、b: 航拍点b的编号
    //  5、charge;标识每个航拍点充1单位电的花费的分钟数 (先输入充电的数组长度，比如5。再跟数组内容，比如4 1 1 3 2)
    // 输出描述:
    //  最少花费的分钟数

    public static void main(String[] args) {
        int[][] paths = {
                {1,3,3},
                {3,2,1},
                {2,1,3},
                {0,1,4},
                {3,0,5},
        };
        int dis = 6;
        int a = 1;
        int b = 0;
        int[] charge = {2,10,4,1};

        int n = charge.length;

        // 构建路程图 各点位的距离关系 map[i]表示当前城市i,其到可以到的临近城市为各个列表集合,而每个列表第一位表示到另一个城市j,第二位表示到j的距离
        List<int[]>[] map = new List[n];
        for(int i = 0; i < n; i++) {
            map[i] = new ArrayList();
        }

        for(int[] path : paths){
            map[path[0]].add(new int[]{path[1], path[2]});
            map[path[1]].add(new int[]{path[0], path[2]});
        }

        // res保存结果 res[i][j]=k 表示在i城市其属于j电量的最短时间
        int[][] res = new int[n][dis+1];
        // 初始化
        for(int[] i : res) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        // 开始点的0电量为0 一切的出发点
        res[a][0] = 0;

        // 采用优先队列 保证每次优先走已用时间最短的路径
        Queue<int[]> queue = new PriorityQueue<int[]>((x, y) -> (x[0] - y[0]));
        // 队列添加的内容: 已用时间 当前所在城市 剩余电量
        // 则一开始出发点为:0,a,0
        queue.offer(new int[]{0, a, 0});

        while(!queue.isEmpty()) {
            // 获取当前已走时间最短的路径
            int[] arr = queue.poll();
            int time = arr[0];
            int cur = arr[1];
            int power = arr[2];

            // 如果时间比之前的时间还长,肯定不是最短路径 因此直接排除
            if(time > res[cur][power]) {
                continue;
            }

            // 走到终点 直接返回结果
            if(cur == b) {
                System.out.println(time);
                return;
            }

            // 如果电量没满 则考虑进行充电 每次只充一个进行遍历
            if(power < dis){
                // 充电完的耗时间
                int t = time + charge[cur];
                // 如果结果比保存到的时间短,则进行更新
                if(t < res[cur][power+1]){
                    res[cur][power+1] = t;
                    // 将此时的最短路径加入队列去遍历
                    queue.offer(new int[]{t, cur, power+1});
                }
            }

            // 遍历当前点位可以到达的所有临近点位的情况
            for(int[] path : map[cur]){
                // 邻近点位置 及其距离
                int next = path[0];
                int cost = path[1];
                // 计算耗时 走到临近点的时间
                int t = time + cost;

                // 判断当前电量是否足够走到临近点
                int p = power - cost;
                if(p >= 0 && t < res[next][p]){
                    // 如果可以走到 并且其是最短路径 则更新结果 添加到队列进行遍历
                    res[next][p] = t;
                    queue.offer(new int[]{t, next, p});
                }
            }
        }

        System.out.println(-1);
    }
}
