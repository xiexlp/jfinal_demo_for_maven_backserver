package com.js.common.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortInteger {
  
      static List<Integer> unSortItems = Arrays.asList(11, 2, 3, 1, 9, 5, 1, 10);
      static List<Integer> sortItems = new ArrayList<Integer>();
  
      static void sort(List<Integer> items) {
          int midIndex = items.size() / 2; //取集合中间的数作为比较数.
          int midValue = items.get(midIndex);
         List<Integer> lowLst = new ArrayList<Integer>(); //创建两个集合保存比中间数小的和大的数.
         List<Integer> highLst = new ArrayList<Integer>();
         for (int j = 0; j < items.size(); j++) {
             if (j == midIndex) //略过自己
                 continue;
             Integer curValue = items.get(j);
            if (curValue <= midValue) {
               lowLst.add(curValue);
             }
             if (curValue > midValue) {
                 highLst.add(curValue);
             }
         }
         //把中间数放到较小的集合里
         if (lowLst.size() < highLst.size())
            lowLst.add(midValue);
         else
            highLst.add(midValue); 
        //拆封到只剩一个数时候结束迭代,并保存结果值到sortItems.
         if (items.size() <= 1) {
             sortItems.addAll(items);
             return;
         }
         //分别迭代大小数集合
        QuickSortInteger.sort(lowLst);
         QuickSortInteger.sort(highLst);

    }
 
     public static void main(String[] args) {
         QuickSortInteger.sort(QuickSortInteger.unSortItems);
         System.out.println(QuickSortInteger.sortItems);
     }
 }