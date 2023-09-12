package com.liao.paperTest.zijie.z0910;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/9/10
 */
public class Test1 {

    static class Shard  {
        int weight;
        int featureValue;

        public Shard(int weight, int featureValue) {
            this.weight = weight;
            this.featureValue = featureValue;
        }

        public List<Shard> split() {
            if (weight < featureValue) {
                List<Shard> results = new ArrayList<>();
                for (int i = 0; i < weight; i++) {
                    results.add(new Shard(1, featureValue));
                }
                return results;
            } else {
                int part = weight / featureValue;
                int remainder = weight % featureValue;

                List<Shard> results = new ArrayList<>();
                for (int i = 0; i < featureValue; i++) {
                    if (i < remainder) {
                        results.add(new Shard(part + 1, featureValue));
                    } else {
                        results.add(new Shard(part, featureValue));
                    }
                }
                return results;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Shard> shards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            shards.add(new Shard(weight, 0)); // 先添加重量，稍后添加特征值
        }
        for (int i = 0; i < n; i++) {
            shards.get(i).featureValue = sc.nextInt();
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int index = -1;
            for (int j = 0; j < shards.size(); j++) {
                Shard shard = shards.get(j);
                if (shard.weight == x) {
                    if (index == -1 || shards.get(index).featureValue > shard.featureValue) {
                        index = j;
                    }
                }
            }
            if (index >= 0) {
                Shard shardToSplit = shards.get(index);
                shards.remove(index);
                shards.addAll(shardToSplit.split());
            }
        }

        System.out.println(shards.size());
    }


}
