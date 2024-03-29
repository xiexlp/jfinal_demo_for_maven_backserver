package com.js.common.sort;
public class TestMain {  
  
    /**  
     * @param args  
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
         Integer[] list={34,3,53,2,23,7,14,10};  
         TestMain qs=new TestMain();  
         qs.quick(list);  
         for(int i=0;i<list.length;i++){  
             System.out.print(list[i]+" ");  
         }  
         System.out.println();  
    }  
    
    
    public void quick(Integer[] str) {  
        if (str.length > 0) {    //查看数组是否为空  
            _quickSort(str, 0, str.length - 1);  
        }  
    }  
    
    
    
    public void _quickSort(Integer[] list, int low, int high) {  
        if (low < high) {  
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二  
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序  
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序  
        }  
    }  
    
    public int getMiddle(Integer[] list, int low, int high) {  
        int tmp = list[low];    //数组的第一个作为中轴  
        while (low < high) {  
            while (low < high && list[high] > tmp) {  
                high--;  
            }  
            list[low] = list[high];   //比中轴小的记录移到低端  
            while (low < high && list[low] < tmp) {  
                low++;  
            }  
            list[high] = list[low];   //比中轴大的记录移到高端  
        }  
        list[low] = tmp;              //中轴记录到尾  
        return low;                   //返回中轴的位置  
    }  
  
}  