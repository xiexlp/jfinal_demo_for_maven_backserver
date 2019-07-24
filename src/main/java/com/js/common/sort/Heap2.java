package com.js.common.sort;



public class Heap2 {
    //交换元素
    public static void exchange(int[] array,int i,int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //获得父节点
    public static int parentNode(int i)
    {
        return (i - 1)/2;
    }
    //获得左节点
    public static int leftNode(int i)
    {
        return 2*i + 1;
    }
    //获得右节点
    public static int rightNode(int i)
    {
        return 2*i + 2;
    }
    //最大堆
    public static void maxHeap(int[] array,int heapSize,int index)
    {
        int left = leftNode(index);
        int right = rightNode(index);
        int largeNode = index;
        if(left < heapSize && array[left] > array[largeNode])
        {
            largeNode = left;
        }
        if(right < heapSize && array[right] > array[largeNode])
        {
            largeNode = right;
        }
        if(index != largeNode)
        {
            exchange(array, index, largeNode);
            maxHeap(array,heapSize,largeNode);
        }
    }
    public static void buildHeap(int[] array)
    {
        if(array == null || array.length <= 1){
            return;
        }
        int half = array.length/2;
        for(int i=half;i>=0;i--)
        {
            maxHeap(array,array.length,i);
        }
    }
    public static void heapSort(int[] array)
    {
        if(array == null || array.length <= 1)
        {
            return;
        }
        buildHeap(array);
        for(int i=array.length -1;i>=1;i--)
        {
            exchange(array,0,i);
            maxHeap(array,i,0);
        }
    }
    public static void printHeapTree(int[] array)
    {
        for(int i=1;i<=array.length;i=i*2)
        {
            for(int k=i-1;k<2*i-1 && k<array.length;k++)
            {
                System.out.print(array[k]+" ");
            }
            System.out.println();
        }
    }
    public static void printHeap(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args)
    {
        int[] array = {7,4,5,3,2,6,9,1};
        System.out.println("执行最大堆化前，堆结构：");
        printHeapTree(array);

        buildHeap(array);

        System.out.println("执行最大堆化后，堆结构：");
        printHeapTree(array);

        heapSort(array);

        System.out.println("堆排序结果：");
        printHeap(array);
    }

}
