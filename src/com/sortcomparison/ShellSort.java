package com.sortcomparison;

public class ShellSort {
    /**
     * 希尔排序：使用递减增量 gap 分组进行插入排序
     */
    public static void sort(int a[]) {
        for (int gap = a.length / 2; gap >= 1; gap = gap / 2) {
            for (int low = gap; low < a.length; low++) {
                int t = a[low];
                int i = low - gap;
                while (i >= 0 && t < a[i]) {
                    a[i + gap] = a[i];
                    i -= gap;
                }
                a[i + gap] = t;
            }
        }
    }
}