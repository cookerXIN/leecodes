package a;

import java.util.Arrays;

class LinearProbingHashing {
    public static void main(String[] args) {
        int[] keys = {10, 24, 32, 17, 31, 30, 46, 47, 40, 63, 49};
        int tableSize = 18; // 哈希表大小
        int[] hashTable = new int[tableSize]; // 哈希表
        Arrays.fill(hashTable, -1); // 初始化哈希表，-1表示空位

        // 构造哈希表
        for (int key : keys) {
            int hash = key % tableSize; // 计算哈希值
            int index = hash; // 初始索引位置
            int count = 0; // 查找次数计数器

            // 线性探测
            while (hashTable[index] != -1) {
                count++;
                index = (index + 1) % tableSize; // 下一个位置
            }

            hashTable[index] = key; // 存储关键字
            System.out.println("关键字 " + key + " 存储在位置 " + index + "，查找次数为 " + count);
        }

        // 统计各个查找长度的个数
        int totalLength = 0;
        int totalCount = 0;
        int[] lengthCounts = new int[tableSize];
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i] != -1) {
                int length = 0;
                int index = i;
                while (hashTable[index] != -1) {
                    length++;
                    index = (index + 1) % tableSize;
                }
                lengthCounts[length]++;
                totalLength += length;
                totalCount++;
            }
        }

        // 计算平均查找长度
        double averageLength = (double) totalLength / totalCount;

        System.out.println("平均查找长度: " + averageLength);

        // 打印各个查找长度的个数
        for (int i = 1; i < tableSize; i++) {
            System.out.println("查找长度为 " + i + " 的个数: " + lengthCounts[i]);
        }
    }
}
