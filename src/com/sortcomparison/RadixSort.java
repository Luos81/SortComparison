package com.sortcomparison;

public class RadixSort {
    /**
     * 基数排序（LSD）—— 仅适用于非负整数
     */
    public static void sort(int[] a) {
        if (a.length == 0) return;

        // 找到最大值，确定位数
        int max = a[0];
        for (int v : a) {
            if (v > max) max = v;
        }

        // 从低位到高位进行计数排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(a, exp);
        }
    }

    private static void countingSortByDigit(int[] a, int exp) {
        int n = a.length;
        int[] output = new int[n];
        int[] count = new int[10];  // 0~9

        // 统计该位上各数字出现的次数
        for (int v : a) {
            int digit = (v / exp) % 10;
            count[digit]++;
        }

        // 累加计数，确定每个数字在输出数组中的结束位置
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 从后往前遍历，保证稳定性
        for (int i = n - 1; i >= 0; i--) {
            int digit = (a[i] / exp) % 10;
            output[count[digit] - 1] = a[i];
            count[digit]--;
        }

        // 拷贝回原数组（使用手动循环完全自己实现，也可用 System.arraycopy）
        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }
}