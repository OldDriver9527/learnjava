package org.olddriver.learnalgorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 由 n - 1 趟排序组成
     * 第一趟排序，将相邻元素比较，将较大元素发在后面，遍历一次数组后，最大元素出现在数组末尾，
     * 第二趟排序，调整遍历数组范围，重复上述步骤
     * @param targetArr
     */
    public static void bubbleSort(int[] targetArr){
        for(int i = 0 ; i < targetArr.length ;i++){
            for(int j = 0 ; j < targetArr.length - 1 -i ; j++){
                if(targetArr[j] > targetArr[j+1]){
                    swap(targetArr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] targetArr,int i,int j){
        int temp = targetArr[i];
        targetArr[i] = targetArr[j];
        targetArr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {41,2,33,14,25,76,47,28,19,19};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
