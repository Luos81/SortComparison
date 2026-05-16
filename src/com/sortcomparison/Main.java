package com.sortcomparison;
import java.io.*;
import java.util.Random;

public class Main {

    static int[] ascending;   // 百万升序
    static int[] descending;  // 百万降序
    static int[] random;      // 百万随机

    // 静态块：加载或生成百万数据
    static {
        String ascFile = "ascending.dat";
        String descFile = "descending.dat";
        String randFile = "random.dat";

        if (ArrayFileUtil.fileExists(ascFile)
                && ArrayFileUtil.fileExists(descFile)
                && ArrayFileUtil.fileExists(randFile)) {
            System.out.println("检测到数据文件，正在加载...");
            ascending = ArrayFileUtil.loadArray(ascFile);
            descending = ArrayFileUtil.loadArray(descFile);
            random = ArrayFileUtil.loadArray(randFile);
            System.out.println("加载完成。");
        } else {
            System.out.println("未找到数据文件，开始生成并保存...");
            ascending = generateAscending(1_000_000);
            descending = generateDescending(1_000_000);
            random = generateRandom(1_000_000);

            ArrayFileUtil.saveArray(ascending, ascFile);
            ArrayFileUtil.saveArray(descending, descFile);
            ArrayFileUtil.saveArray(random, randFile);
            System.out.println("生成并保存完成。");
        }
    }

    static int[] generateAscending(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        return arr;
    }

    static int[] generateDescending(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        return arr;
    }

    static int[] generateRandom(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n) + 1;
        return arr;
    }

    /**
     * 测试排序算法，自动根据算法类型选择数据量
     * O(n²) 算法在逆序/随机时使用 SMALL_SIZE，避免长时间等待
     */
    static void testSort(String algorithm, int[] original, String arrayType, boolean isSlowAlgorithm) {
        int size;
        int[] arr;

        if (isSlowAlgorithm && (arrayType.equals("降序") || arrayType.equals("随机"))) {
            // 慢速算法 + 逆序/随机 → 使用 1 万数据
            size = Math.min(10_000, original.length);
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = original[i];   // 复制前 size 个元素
            }
        } else {
            // 其他情况使用完整原始数组
            size = original.length;
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = original[i];
            }
        }

        long start = System.currentTimeMillis();
        switch (algorithm) {
            case "选择排序": SelectionSort.sort(arr); break;
            case "希尔排序": ShellSort.sort(arr); break;
            case "直接插入": Insertion.sort(arr); break;
            case "冒泡排序": BubbleSort.sort(arr); break;
            case "归并排序": MergeSort.sort(arr); break;
            case "快速排序": QuickSort.sort(arr); break;
            case "堆排序": HeapSort.sort(arr); break;
            case "基数排序": RadixSort.sort(arr); break;
        }
        long end = System.currentTimeMillis();
        double seconds = (end - start) / 1000.0;

        // 格式化输出，标注数据量
        String sizeStr = (size == 1_000_000) ? "100万" : " 1万 ";
        System.out.printf("%-12s | %-6s | %-6s | %8.3f 秒\n", algorithm, arrayType, sizeStr, seconds);
    }

    public static void main(String[] args) {
        System.out.println("===== 排序算法性能测试报告 ======");
        System.out.println("说明：慢速算法（选择/插入/冒泡）在逆序和随机时仅测试 1 万数据，避免演示超时。");
        System.out.printf("%-12s | %-6s | %-6s | %s\n", "算法", "类型", "数据量", "耗时");
        System.out.println("--------------------------------------------");

        String[] slowAlgorithms = {"选择排序", "直接插入", "冒泡排序"};
        String[] fastAlgorithms = {"希尔排序", "归并排序", "快速排序", "堆排序", "基数排序"};

        // 先测试慢速算法
        for (String alg : slowAlgorithms) {
            testSort(alg, ascending, "升序", true);
            testSort(alg, descending, "降序", true);
            testSort(alg, random, "随机", true);
            System.out.println();
        }

        // 再测试高效算法（全部使用百万数据）
        for (String alg : fastAlgorithms) {
            testSort(alg, ascending, "升序", false);
            testSort(alg, descending, "降序", false);
            testSort(alg, random, "随机", false);
            System.out.println();
        }

        // 可选：输出结果写入文件（简单控制台重定向即可，无需代码写入）
        System.out.println("测试完成，以上数据可直接用于报告。");
    }
}