/**
 * @author liaoguixin
 * @date 2023/9/6
 */
import java.util.*;
public class M2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //int n = input.nextInt();
        //int[] nums = new int[n];
        //for (int i = 0; i < n; i++) {
        //    nums[i] = input.nextInt();
        //}
        int n = 7;
        int[] nums = {1,2,2,3,3,4,5};
        int left = 0;
        int right = 0;
        int max = 1;
        int cur = 1;
        int idx = 0;
        List<int[]> list = new ArrayList<>();
        while (idx < n) {
            int tmp = idx;
            while (idx != n - 1 && idx < n && nums[idx] == nums[idx+1]) {
                idx++;
                cur++;
            }
            if (cur > max) {
                left = tmp;
                right = idx;
                max = cur;
                list.clear();
                list.add(new int[]{left, right});
            } else if (cur == max) {
                left = tmp;
                right = idx;
                list.add(new int[]{left, right});
            }
            cur = 1;
            idx++;
        }

        int res = Integer.MAX_VALUE;
        for (int[] arr : list) {
            int l = arr[0];
            int r = arr[1];
            res = Math.min(res, cal(l,r,n,max));
        }
        System.out.println(res);

    }

    static int cal(int left,  int right, int n, int max) {
        int res = 0;
        int leftLen = left;
        int rightLen = n - right - 1;
        if (rightLen < leftLen) {
            int tmp = leftLen;
            leftLen = rightLen;
            rightLen = tmp;
        }
        while (leftLen != 0) {
            if (leftLen < max) {
                res++;
                max += leftLen;
                break;
            } else {
                res++;
                leftLen -= max;
                max = max * 2;
            }
        }
        while (rightLen != 0) {
            if (rightLen < max) {
                res++;
                break;
            } else {
                res++;
                rightLen -= max;
                max = max * 2;
            }
        }
        return res;
    }

    //int left = 0;
    //int right = 0;
    //int max = 1;
    //int cur = 1;
    //int idx = 0;
    //
    //while (idx < n) {
    //    int tmp = idx;
    //    while (idx != n - 1 && idx < n && nums[idx] == nums[idx+1]) {
    //        idx++;
    //        cur++;
    //    }
    //    if (cur > max) {
    //        left = tmp;
    //        right = idx;
    //        max = cur;
    //    }
    //    cur = 1;
    //    idx++;
    //}
    //int res = 0;
    //int leftLen = left;
    //int rightLen = n - right - 1;
    //if (rightLen < leftLen) {
    //    int tmp = leftLen;
    //    leftLen = rightLen;
    //    rightLen = tmp;
    //}
    //while (leftLen != 0) {
    //    if (leftLen < max) {
    //        res++;
    //        max += leftLen;
    //        break;
    //    } else {
    //        res++;
    //        leftLen -= max;
    //        max = max * 2;
    //    }
    //}
    //while (rightLen != 0) {
    //    if (rightLen < max) {
    //        res++;
    //        break;
    //    } else {
    //        res++;
    //        rightLen -= max;
    //        max = max * 2;
    //    }
    //}
    //System.out.println(res);
}
