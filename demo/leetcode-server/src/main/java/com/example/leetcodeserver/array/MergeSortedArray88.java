package com.example.leetcodeserver.array;

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3, 0, 0, 0, 0, 0};
        int[] a2 = new int[]{2, 5, 7, 9, 88};
        MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
        mergeSortedArray88.merge(a1, 3, a2, 5);
        for (int i : a1) {
            System.out.print(i+" ");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //由于两个数组都是排序的，所以从后往前遍历两个数组，遇到比较大的就放在1的末尾
        int len1 = m - 1;
        int len2 = n - 1;
        int total = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            if (nums1[len1] > nums2[len2]) {
                nums1[total] = nums1[len1];
                len1--;
            } else {
                nums1[total] = nums2[len2];
                len2--;
            }
            total--;
        }
        //这里有两种情况，如果是len1先完了，那么nums2中还有数据，所以需要将nums2中的数据拷贝到nums1前面
        for (int i = 0; i <= len2; i++) {
            nums1[i] = nums2[i];
        }

    }

    public void merg1(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;
        while (len1 >= 0 && len2 >= 0) {
            if (nums1[len1] > nums2[len2]) {
                nums1[total] = nums1[len1];
                len1--;
            } else {
                nums1[total] = nums2[len2];
                len2--;
            }
            total--;
        }
        //如果nums1先完了 那么此时还剩下nums2 没有被添加进去，所以需要将nums2中的数据copy到nums1中
        for (int i = 0; i <= len2; i++) {
            nums1[i] = nums2[i];
        }

    }

}
