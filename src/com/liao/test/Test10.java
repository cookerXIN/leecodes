package com.liao.test;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


/**
 * @author liaoguixin
 * @date 2023/9/4
 */
public class Test10 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean closed;
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                int x = scanner.nextInt(); // 行数
                int y = scanner.nextInt(); // 列数

                int[][] office = new int[x][y];

                // 读取办公区的俯视图
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        String input = scanner.next();
                        if (input.equals("*")) {
                            office[i][j] = 1;
                        } else {
                            office[i][j] = Integer.parseInt(input);
                        }
                    }
                }
                long dryAreas = closedIsland(office);
                System.out.println(dryAreas);
            }
            // 计算没有被水淹没的区域数
    public static long closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Queue<int[]> qu = new ArrayDeque<int[]>();
                    grid[i][j] = 1;
                    boolean closed = true;
                    qu.offer(new int[]{i, j});
                    while (!qu.isEmpty()) {
                        int[] arr = qu.poll();
                        int cx = arr[0], cy = arr[1];
                        if (cx == 0 || cy == 0 || cx == m - 1 || cy == n - 1) {
                            closed = false;
                        }
                        for (int d = 0; d < 4; d++) {
                            int nx = cx + dir[d][0];
                            int ny = cy + dir[d][1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                                grid[nx][ny] = 1;
                                qu.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    if (closed) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public static int closedIsland1(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        if (m < 3 || n < 3) return 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) { // 从没有访问过的 0 出发
                    closed = true;
                    dfs(grid, i, j);
                    if (closed) ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(int[][] grid, int x, int y) {
        if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[x].length - 1) {
            if (grid[x][y] == 0) closed = false; // 到达边界
            return;
        }
        if (grid[x][y] != 0) return;
        grid[x][y] = 1; // 标记 (x,y) 被访问，避免重复访问
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}
