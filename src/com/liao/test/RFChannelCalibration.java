package com.liao.test;

import java.util.Scanner;

public class RFChannelCalibration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取第一组数据中的频道号(freq)
        int freg = scanner.nextInt();
        // 读取第二组数据，使用冒号和逗号分隔的格式
        String data = scanner.next();
        // 将第二组数据按逗号分割成频道号(freq)和损失值(loss)的数组
        String[] parts = data.split(",");
        // 初始化变量，用于存储最近的频道号(freq)和对应的损失值(loss)
        double min_loss = Double.MAX_VALUE;
        double min_diff = Double.MAX_VALUE;
        for (String part : parts) {
            // 按冒号分隔频道号(freq)和损失值(loss)
            String[] values = part.split(":");
            // 解析频道号(freq)和损失值(loss)
            int freq = Integer.parseInt(values[0]);
            double loss = Double.parseDouble(values[1]);
            // 计算当前频道号(freq)与目标频道号(freg)的差值的绝对值
            int diff = Math.abs(freq - freg);
            if (diff < min_diff) {
                min_diff = diff;
                min_loss = loss;
            } else if (diff == min_diff) {
                // 如果差值相等，取两边损失值(loss)的平均
                min_loss = (min_loss + loss) / 2.0;
            }
        }
        // 输出最近的频道号(freq)对应的损失值(loss)，保留1位小数
        System.out.printf("%.1f%n", min_loss);

        scanner.close();
    }
}
