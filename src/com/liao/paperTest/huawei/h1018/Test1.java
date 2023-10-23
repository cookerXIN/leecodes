package com.liao.paperTest.huawei.h1018;

/**
 * @author liaoguixin
 * @date 2023/10/18
 */
import java.util.*;

public class Test1 {
    static class Indicator {
        List<int[]> steps = new ArrayList<>();
        Long value = null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numIndicators = Integer.parseInt(scanner.nextLine().trim());
        Indicator[] indicators = new Indicator[numIndicators];
        for (int i = 0; i < numIndicators; i++) {
            indicators[i] = new Indicator();
            int numSteps = Integer.parseInt(scanner.nextLine().trim());
            for (int j = 0; j < numSteps; j++) {
                String[] parts = scanner.nextLine().trim().split(" ");
                int[] step = new int[parts.length];
                for (int k = 0; k < parts.length; k++) {
                    step[k] = Integer.parseInt(parts[k]);
                }
                indicators[i].steps.add(step);
            }
        }
        long result = calculateIndicator(0, indicators);
        System.out.println(result);
    }
    private static long calculateIndicator(int index, Indicator[] indicators) {
        Indicator indicator = indicators[index];
        if (indicator.value != null) {
            return indicator.value;
        }
        List<Long> stepResults = new ArrayList<>();
        for (int[] step : indicator.steps) {
            switch (step[0]) {
                case 0:
                    if (step[1] < indicators.length) {
                        long value = calculateIndicator(step[1], indicators);
                        if (value == -1) {
                            return -1;  // 依赖的指标无法计算
                        }
                        stepResults.add(value);
                    } else {
                        return -1;  // 无效的指标引用
                    }
                    break;
                case 1:
                    // 直接的值
                    stepResults.add((long) step[1]);
                    break;
                case 2:
                    // 减法
                    if (step[1] < stepResults.size() && step[2] < stepResults.size()) {
                        stepResults.add(stepResults.get(step[1]) - stepResults.get(step[2]));
                    } else {
                        return -1;  // 无效的步骤引用
                    }
                    break;
                case 3:
                    // 加法
                    if (step[1] < stepResults.size() && step[2] < stepResults.size()) {
                        stepResults.add(stepResults.get(step[1]) + stepResults.get(step[2]));
                    } else {
                        return -1;  // 无效的步骤引用
                    }
                    break;
                default:
                    return -1;  // 无效的操作
            }
        }
        if (!stepResults.isEmpty()) {
            indicator.value = stepResults.get(stepResults.size() - 1);
            return indicator.value;
        }
        return -1;  // 无法计算值
    }
}

