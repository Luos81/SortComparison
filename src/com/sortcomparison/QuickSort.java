package com.sortcomparison;

public class QuickSort {
    public static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            medianOfThree(a, low, high);          // 三数取中
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    /**
     * 三数取中法：将 low, mid, high 三个位置的中值放到 low 作为基准
     */
    private static void medianOfThree(int[] a, int low, int high) {
        int mid = low + (high - low) / 2;
        if (a[mid] < a[low]) swap(a, low, mid);
        if (a[high] < a[low]) swap(a, low, high);
        if (a[high] < a[mid]) swap(a, mid, high);
        // 此时 mid 位置是中值，将其与 low 交换作为基准
        swap(a, low, mid);
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && a[right] >= pivot) right--;
            while (left < right && a[left] <= pivot) left++;
            if (left < right) swap(a, left, right);
        }
        a[low] = a[left];
        a[left] = pivot;
        return left;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}