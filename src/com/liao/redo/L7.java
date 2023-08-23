package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class L7 {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    //public static int reverse(int x) {
    //    boolean flag = false;
    //
    //    String s = String.valueOf(x);
    //    StringBuilder sb;
    //    if (s.charAt(0) == '-') {
    //        flag = true;
    //        sb = new StringBuilder(s.substring(1));
    //    } else {
    //        sb = new StringBuilder(s);
    //    }
    //    long l = Long.parseLong(sb.reverse().toString());
    //    if (l > Integer.MAX_VALUE) {
    //        return 0;
    //    }
    //    if (flag && -l < Integer.MIN_VALUE) {
    //        return 0;
    //    }
    //
    //    return (int) l;
    //}


    public static int reverse(int x) {
        int res = 0;
        int tmp = 0;
        while (x != 0) {
            tmp = x % 10;
            if (res > 214748364 ||( res == 214748364 && tmp > 7))
            {
                return 0;
            }
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }

            res = res * 10 + tmp;
            x /= 10;
        }

        return res;
    }
}
