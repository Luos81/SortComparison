package com.sortcomparison;

public class BubbleSort {
    /**
     * 冒泡排序：每轮将最大元素浮至末尾，带交换标志优化
     */
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;   // 若未发生交换，已有序，提前结束
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}