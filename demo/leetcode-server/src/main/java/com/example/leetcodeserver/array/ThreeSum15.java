package com.example.leetcodeserver.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = threeSum15.threeSum(nums);
        System.out.println(ans);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k]>0) break;
            if (k>0 && nums[k-1] == nums[k]) continue;
            int i = k+1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    j--;
                    while (nums[j-1] == nums[j]) j--;
                } else if (sum < 0) {
                    i++;
                    while (nums[i - 1] == nums[i]) i++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    i++;
                    j--;
                }
            }
        }
        return ans;

    }
}
