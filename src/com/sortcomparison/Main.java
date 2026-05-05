package com.sortcomparison;
import java.util.Random;

public class Main {

    /*
     三个数组，静态变量以全局使用
     */
    static int[] ascending;   //升序数组
    static int[] descending; //降序数组
    static int[] random;      //随机数组

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
    // 生成 1~n 的升序数组
    static int[] generateAscending(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // 生成 n~1 的降序数组
    static int[] generateDescending(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    // 生成随机数组，范围 1~n
    static int[] generateRandom(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n) + 1;
        }
        return arr;
    }

    // 主函数，先简单验证
    public static void main(String[] args) {
        // 升序数组前10个
        System.out.println("升序数组前10个：");
        for (int i = 0; i < 10; i++){
            System.out.print(ascending[i] + " ");
        }
        System.out.println("\n最后一个：" + ascending[ascending.length - 1]);

        // 降序数组前10个
        System.out.println("\n降序数组前10个：");
        for (int i = 0; i < 10; i++){
            System.out.print(descending[i] + " ");
        }
        System.out.println("\n最后一个：" + descending[descending.length - 1]);

        // 随机数组前10个
        System.out.println("\n随机数组前10个：");
        for (int i = 0; i < 10; i++){
            System.out.print(random[i] + " ");
        }

        System.out.println("\n最后一个：" + random[random.length - 1]);
    }
}
