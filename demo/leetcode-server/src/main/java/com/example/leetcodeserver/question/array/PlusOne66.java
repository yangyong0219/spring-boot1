package com.example.leetcodeserver.question.array;

public class PlusOne66 {
    public static void main(String[] args) {
        PlusOne66 plusOne66 = new PlusOne66();
        int[] a = new int[]{9, 9, 9, 9};
        int[] ints = plusOne66.plusOne(a);
        for (int i : ints) {
            System.out.print(i+" ");
        }

    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        //因为每次都是+1  如果这里都进位了  那说明后面所有的数据都是0了，所以只需要返回another[0]=1就可以
        int[] another = new int[digits.length + 1];
        another[0] = 1;
        return another;
    }

    public int[] plusOne1(int[] digits) {
        int len = digits.length - 1;
        for (int i = len; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i]!=0) return digits;
        }
        int[] another = new int[digits.length + 1];
        another[0] = 1;
        return another;

    }

}
