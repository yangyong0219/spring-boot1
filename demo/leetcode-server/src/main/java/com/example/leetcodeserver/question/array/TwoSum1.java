package com.example.leetcodeserver.question.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        TwoSum1 twoSum1 = new TwoSum1();
        int[] n = new int[]{2,2,4};
        int target = 4;
        int[] twoSum = twoSum1.twoSum(n, target);
        for (int i : twoSum) {
            System.out.print(i + " ");
        }

    }

    public int[] twoSum(int[] nums, int target) {

        //暴力解法，双循环，时间复杂度 n平方
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[0];

        //hash解法
        Map<Integer, Integer> numsMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target-nums[i]), i};
            }
            //下面这句代码一定要写在判断之后，如果target是4 元素是2 和 2 如果先put那么target-当前值就一定会存在map中
            //实际上这不是一个正确的解，但是先判断再push的话，只有第二次遇到2才会判断到存在，所以就是正确的解
            numsMap.put(nums[i], i);
        }
        return new int[0];
    }
}
