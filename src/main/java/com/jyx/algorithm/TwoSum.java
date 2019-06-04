package com.jyx.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整数数组nums和一个目标值target，请找出两个数组中和为target的数组下标。
 * 示例： nums =[2,7,11,15] target = 9
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        towSum(nums, target);
    }

    public static int[] towSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
