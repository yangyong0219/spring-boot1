package com.example.leetcodeserver.question.array;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        ContainerWithMostWater11 container = new ContainerWithMostWater11();
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = container.containerWithMostWater1(ints);
        System.out.println(ans);
    }

    private int containerWithMostWater(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[j], height[i]);
            ans = Math.max(ans, area);
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    private int containerWithMostWater1(int[] height) {
        return 0;
    }

}
