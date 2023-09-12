package com.liao.paperTest.huawei.h0830;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/9
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] inTimes = input.nextLine().split(" ");
        int m = Integer.parseInt(input.nextLine());
        String[] outTimes = input.nextLine().split(" ");

        int res = 0;
        int idx = 0;

        while (idx < n) {
            String[] curIn = inTimes[idx].split(":");
            String[] curOut = outTimes[idx].split(":");
            int inH = Integer.parseInt(curIn[0]);
            int inM = Integer.parseInt(curIn[1]);

            int outH = Integer.parseInt(curOut[0]);
            int outM = Integer.parseInt(curOut[1]);

            if (idx != n-1) {
                String[] nextIn = inTimes[idx+1].split(":");
                int nextInH = Integer.parseInt(nextIn[0]);
                int nextInM = Integer.parseInt(nextIn[1]);
                if (nextInH == 12 || nextInH == 13 || nextInH == 18 || nextInH == 19) {
                } else {
                    if ((nextInH - outH) * 60 + (nextInM - outM) <= 15) {
                        idx++;
                        String[] nextOut = outTimes[idx].split(":");
                        outH = Integer.parseInt(nextOut[0]);
                        outM = Integer.parseInt(nextOut[1]);
                    }
                }
            }

            if (inH == 12 || inH == 13) {
                if (outH < 14) {
                    idx++;
                    continue;
                } else {
                    inH = 14;
                    inM = 0;
                }
            } else if (inH == 18 || (inH == 19 && inM <= 30)) {
                if (outH == 19 && inM <= 30) {
                    idx++;
                    continue;
                } else if (outH > 19 || (outH == 19 && outM > 30)){
                    inH = 19;
                    inM = 30;
                }
            }

            if (outH == 12) {
                outM = 0;
            } else if (outH == 18) {
                outM = 0;
            }

            res += (outH - inH) * 60 + (outM - inM);
            idx++;
        }

        System.out.println(res);
    }
}
