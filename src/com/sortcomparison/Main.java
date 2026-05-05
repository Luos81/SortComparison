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
        // 生成函数我们稍后实现
        ascending = generateAscending(1000000);
        descending = generateDescending(1000000);
        random = generateRandom(1000000);
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
