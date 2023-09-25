package com.liao.paperTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/19
 */
import java.util.*;

class SignalTower implements Comparable<SignalTower> {
    int x, y, q;
    public SignalTower(int x, int y, int q) {
        this.x = x;
        this.y = y;
        this.q = q;
    }
    public double distanceTo(int cx, int cy) {
        return Math.sqrt(Math.pow(cx - x, 2) + Math.pow(cy - y, 2));
    }
    public int signalStrength(int cx, int cy) {
        double d = distanceTo(cx, cy);
        return (int) (q / (1 + d));
    }
    @Override
    public int compareTo(SignalTower other) {
        return Integer.compare(q, other.q);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] split = input.nextLine().split(",");
        int n = Integer.parseInt(split[0]);
        int radius = Integer.parseInt(split[1]);
        List<SignalTower> towers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] strs = input.nextLine().split(",");
            towers.add(new SignalTower(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), Integer.parseInt(strs[2])));
        }
        int best = Integer.MIN_VALUE;
        int bestX = Integer.MAX_VALUE;
        int bestY = Integer.MAX_VALUE;
        for (int cx = 0; cx <= 100; cx++) {
            for (int cy = 0; cy <= 100; cy++) {
                int len = 0;
                for (SignalTower tower : towers) {
                    double distance = tower.distanceTo(cx, cy);
                    if (distance <= radius) {
                        len += tower.signalStrength(cx, cy);
                    }
                }
                if (len > best ||
                        (len == best && (cx < bestX || (cx == bestX && cy < bestY)))) {
                    best = len;
                    bestX = cx;
                    bestY = cy;
                }
            }
        }
        System.out.println(bestX + "," + bestY);
    }
}

