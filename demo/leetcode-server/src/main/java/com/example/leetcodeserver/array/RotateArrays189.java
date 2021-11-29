package com.example.leetcodeserver.array;

public class RotateArrays189 {
    public static void main(String[] args) {
        RotateArrays189 rotateArrays189 = new RotateArrays189();
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        rotateArrays189.rotate(nums, 2);
        for (int i : nums) {
            System.out.print(i+" ");
        }
    }
    public void rotate(int[] nums, int k) {
        //这是一个很神奇的故事，往后轮转k次，等于k之前的数组反转，k之后的数组反转，再整个反转
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
