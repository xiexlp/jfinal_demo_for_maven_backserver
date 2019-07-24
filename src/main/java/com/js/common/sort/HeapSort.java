package com.js.common.sort;

import java.util.Arrays;

public class HeapSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 对第k个元素进行堆排序
     * @param arr
     * @param k
     *  随着不断地将第一个元素移到数组后面，这个长度会逐渐变小
     */
    public static void headSortNumber(int[] arr, int k, int length) {
        int i = (length + 1) / 2 - 1;
        while (k <= i) {
            int t = k * 2 + 1;
            if (t + 1 <= length && arr[t] < arr[t + 1]) {//如果左子结点小于右子结点，k指向右子结点
                t += 1;
            }

            if (arr[k] > arr[t])//如果子节点小于父节点，直接跳过
                break;

            swap(arr, k, t);
            k = t;
        }
    }

    public static void headSort(int[] arr) {
        //构建一个堆
        for (int j = arr.length / 2 - 1; j >= 0; j--) {
            headSortNumber(arr, j, arr.length - 1);
        }
        //进行堆排序
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, j, 0);
            headSortNumber(arr, 0, j - 1);
        }
    }


    public static void headSortNumber2(int[] arr, int k, int length) {
        int i = (length + 1) / 2 - 1;
        int temp = arr[k];
        while (k <= i) {
            int t = k * 2 + 1;
            if (t + 1 <= length && arr[t] < arr[t + 1]) {
                t += 1;
            }

            if (temp > arr[t])
                break;

            arr[k] = arr[t];
            k = t;
        }
        if(temp != arr[k]){
            arr[k] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[] { 43, 22, 21, 23, 67, 54, 78, 92, 34, 11, 36 };
        System.out.println(Arrays.toString(arr));
        System.out.println("************************************");
        headSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

