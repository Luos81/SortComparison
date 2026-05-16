package com.sortcomparison;

public class HeapSort {
    public static void sort(int[] a) {
        // 1. 建最大堆
        heapify(a, a.length);
        // 2. 排序：依次将堆顶（最大）交换到末尾，并缩小堆调整
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, i, 0);
            down(a, 0, i);
        }
    }

    private static void heapify(int[] array, int size) {
        // 从最后一个非叶子节点开始，自底向上调整
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(array, i, size);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private static void down(int[] array, int parent, int size) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
            swap(array, parent, max);
            down(array, max, size);   // 递归调整被交换的子树
        }
    }
}