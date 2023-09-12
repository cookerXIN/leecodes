package com.liao.paperTest.huawei.h0906;
import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/8
 */
public class Test1 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //int n = input.nextInt();
        //int[] stocks = new int[n];
        //for (int i = 0; i < n; i++) {
        //    stocks[i] = input.nextInt();
        //}

        int n = 5;
        int[] stocks = {33,34,14,12,16};
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (stocks[i] < stocks[j]) {
                    res[i] = j-i;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
