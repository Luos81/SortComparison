package com.sortcomparison;

public class SelectionSort {
    /**
     * 简单选择排序：每轮选出最大元素放到末尾
     */
    public static void sort(int a[]) {
        for (int pos = a.length - 1; pos > 0; pos--) {
            int max = pos;
            for (int i = 0; i < pos; i++) {
                if (a[i] > a[max]) {
                    max = i;
                }
            }
            swap(a, pos, max);
        }
    }

    private static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}