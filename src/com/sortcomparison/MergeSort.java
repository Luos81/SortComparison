package com.sortcomparison;

public class MergeSort {
    public static void sort(int[] a) {
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length - 1, temp);
    }

    private static void mergeSort(int[] a, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(a, left, mid, temp);      // 排序左半
            mergeSort(a, mid + 1, right, temp); // 排序右半
            merge(a, left, mid, right, temp);   // 合并
        }
    }

    private static void merge(int[] a, int left, int mid, int right, int[] temp) {
        int i = left;      // 左子序列指针
        int j = mid + 1;   // 右子序列指针
        int t = 0;         // 临时数组指针

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }
        while (i <= mid) temp[t++] = a[i++];
        while (j <= right) temp[t++] = a[j++];

        // 拷贝回原数组
        t = 0;
        while (left <= right) {
            a[left++] = temp[t++];
        }
    }
}