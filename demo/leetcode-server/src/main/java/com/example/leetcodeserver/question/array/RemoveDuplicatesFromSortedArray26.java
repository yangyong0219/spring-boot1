package com.example.leetcodeserver.question.array;

public class RemoveDuplicatesFromSortedArray26 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray26 remove = new RemoveDuplicatesFromSortedArray26();
        int[] ints = new int[]{1, 1, 3, 4, 4, 5, 6, 6};
        int i = remove.removeDuplicates(ints);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        //采用快慢指针的方法
        //快指针如果遇到不一样的值就把慢指针+1 并放到慢指针的位置
        if (nums.length < 2) return nums.length;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        //因为i是元素的下标，所以这里返回的是i+1
        return i + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

}
