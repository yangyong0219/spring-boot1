package com.example.leetcodeserver.question.array;

public class MoveZeroes283 {
    public static void main(String[] args) {
        MoveZeroes283 moveZeroes283 = new MoveZeroes283();
        int[] int1 = new int[]{0, 2, 5, 0, 20, 0, 0, 90};
        moveZeroes283.moveZeroes(int1);
        for (int j : int1) {
            System.out.print(j + " ");
        }
    }

    private void moveZeroes(int[] nums) {
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[j] = nums[i];
//                if (i != j) {
//                    nums[i] = 0;
//                }
//                j++;
//            }
//        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    private void moveZeroes1(int[] nums) {
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[j] = nums[i];
//                j++;
//            }
//        }
//        for (; j < nums.length; j++) {
//            nums[j] = 0;
//        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
            }
        }



    }

}
