package com.liao.paperTest.huawei.h0913;
import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/18
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] positions = new int[n][2];
        for (int i = 0; i < n; i++) {
            positions[i][0] = input.nextInt();
            positions[i][1] = input.nextInt();
        }

        int count = n;
        int area = 0;

        int[][] visited = new int[1000][1000];
        int[][] directs = {
                {-1,-1}, {0,-1}, {1,-1},
                {-1,0},  {0,0},  {1,0},
                {-1,1},  {0,1},  {1,1}
        };

        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            for (int[] direct : directs) {
                int newX = x + direct[0];
                int newY = y + direct[1];

                if (newX < 0 || newY < 0 || newX >= 1000 || newY >= 1000) {
                    continue;
                }
                if (visited[newX][newY] == 0) {
                    area++;
                }
                visited[newX][newY] += 1;
            }
        }

        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            int tmp = 0;
            for (int[] direct : directs) {
                int newX = x + direct[0];
                int newY = y + direct[1];

                if (newX < 0 || newY < 0 || newX >= 1000 || newY >= 1000 || visited[newX][newY] == 1) {
                    break;
                }
                if (visited[newX][newY] > 1) {
                    tmp++;
                }
            }

            if (tmp == 9) {
                count--;
                for (int[] direct : directs) {
                    int newX = x + direct[0];
                    int newY = y + direct[1];

                    visited[newX][newY]--;
                }
            }
        }

        System.out.println(count + " " + area);
    }
}
