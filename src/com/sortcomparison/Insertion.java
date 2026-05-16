package com.sortcomparison;

public class Insertion {
    /**
     * 直接插入排序（迭代实现）
     */
    public static void sort(int a[]) {
        int n = a.length;
        for (int low = 1; low < n; low++) {
            int t = a[low];          // 待插入元素
            int i = low - 1;
            // 在已排序区间 [0, low-1] 中从右向左寻找插入位置
            while (i >= 0 && t < a[i]) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = t;            // 插入到正确位置
        }
    }
}