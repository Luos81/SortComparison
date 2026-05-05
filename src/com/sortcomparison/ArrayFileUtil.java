package com.sortcomparison;

import java.io.*;

public class ArrayFileUtil {
    /*
     ArrayFileUtil：让三个数组第一次生成后写入文件，下次启动直接读取文件，不再重新生成。
     目的：节约时间，否则给老师演示的时候会显得太low了
     */

    public static void saveArray(int[] arr, String filePath) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(filePath)))) {
            dos.writeInt(arr.length);  // 先写长度
            for (int value : arr) {
                dos.writeInt(value);
            }
        } catch (IOException e) {
            System.err.println("保存数组失败：" + e.getMessage());
        }
    }

    /**
     * 从文件加载 int 数组
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
