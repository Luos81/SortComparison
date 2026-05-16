package com.sortcomparison;

import java.io.*;

public class ArrayFileUtil {
    /**
     * 将整型数组保存为二进制文件
     * 格式：数组长度 (int) + 依次每个元素 (int)
     */
    public static void saveArray(int[] arr, String filePath) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(filePath)))) {
            dos.writeInt(arr.length);
            for (int value : arr) {
                dos.writeInt(value);
            }
        } catch (IOException e) {
            System.err.println("保存数组失败：" + e.getMessage());
        }
    }

    /**
     * 从二进制文件加载整型数组
     */
    public static int[] loadArray(String filePath) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(filePath)))) {
            int length = dis.readInt();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = dis.readInt();
            }
            return arr;
        } catch (IOException e) {
            System.err.println("加载数组失败：" + e.getMessage());
            return null;
        }
    }

    /**
     * 判断文件是否存在
     */
    public static boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }
}