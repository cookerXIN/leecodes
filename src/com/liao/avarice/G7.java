package com.liao.avarice;

/**
 * @author liaoguixin
 * @data 2023/7/10
 */
public class G7 {
    public static void main(String[] args) {
        //输入：bills = [5,5,5,10,20]
        //输出：true
        //解释：
        //前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
        //第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
        //第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
        //由于所有客户都得到了正确的找零，所以我们输出 true。

        int[] bills = {
                5,5,10,10,20
        };
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        //0:5, 1:10, 2:20
        int[] nums = new int[3];

        for (int bill : bills) {
            if (bill == 5) {
                nums[0] += 1;
            } else if (bill == 10) {
                nums[1] += 1;
                if (nums[0] < 1) {
                    return false;
                }
                nums[0] -= 1;
            } else {
                nums[2] += 1;
                if (nums[1] < 1 && nums[0] < 3) {
                    return false;
                }
                if (nums[1] >= 1) {
                    if (nums[0] < 1) {
                        return false;
                    } else {
                        nums[1] -= 1;
                        nums[0] -= 1;
                    }
                } else {
                    nums[0] -= 3;
                }

            }
        }

        return true;
    }
}
