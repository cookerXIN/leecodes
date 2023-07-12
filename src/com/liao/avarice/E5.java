package com.liao.avarice;

import com.sun.javafx.geom.transform.CanTransformVec3d;
import jdk.internal.org.objectweb.asm.tree.JumpInsnNode;

/**
 * @author liaoguixin
 * @data 2023/7/10
 */
public class E5 {
    public static void main(String[] args) {
        //输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        //输出: 3
        //解释:
        //从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
        //开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
        //开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
        //开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
        //开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
        //开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
        //因此，3 可为起始索引。
        int[] gas = {
                1,2,3,4,5
        };
        int[] cost = {
                3,4,5,1,2
        };
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {

        if (gas.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasSum = 0;
            start = i;
            gasSum += gas[start];
            gasSum -= cost[start];
            if (gasSum <= 0) {
                continue;
            }
            start = start >= gas.length - 1 ? start - gas.length + 1 : start+1;
            end = i > 0 ? i - 1 : gas.length - 1;
            while (start != i) {
                gasSum += gas[start];
                gasSum -= cost[start];
                if (start == end && gasSum >= 0) {
                    return i;
                }
                if (gasSum <= 0) {
                    break;
                }
                start = start >= gas.length - 1 ? start - gas.length + 1 : start+1;
            }
        }
        return -1;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            curSum += (gas[i] - cost[i]);
            totalSum += (gas[i] - cost[i]);

            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }

        if (totalSum < 0) {
            return - 1;
        }

        return index;
    }
}
