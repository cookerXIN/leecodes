package com.liao.huisu;

import com.sun.org.apache.xml.internal.utils.NSInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/8
 */
public class J9 {
    public static void main(String[] args) {
        //输入：nums = [4,6,7,7]
        //输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

        int[] nums = {4,6,7,7};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        method(nums, 0);
        return resList;
    }

    static List<List<Integer>> resList = new ArrayList<>();
    static LinkedList<Integer> items = new LinkedList<>();

    public static void method(int[] nums, int start) {
        if (items.size() > 1) {
            resList.add(new ArrayList<>(items));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (items.size() >= 1 && items.peekLast() <= nums[i]) {
                items.add(nums[i]);
                method(nums, i + 1);
                items.removeLast();
            } else if (items.size() == 0){
                items.add(nums[i]);
                method(nums, i + 1);
                items.removeLast();
            }
        }
    }
}
