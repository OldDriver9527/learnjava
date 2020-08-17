package org.olddriver.learnAlgorithm.sort;

import java.util.Arrays;

public class SelectionSort {

    /**
     * 由 n -1 趟排序组成
     * 第一趟排序，假设首元素为最小元素，将最小元素与首元素后的所有元素比较，若发现小于最小元素的元素，修改最小元素索引
     * 比较一趟后，将首元素与最小元素置换，最小元素就位于数组首部
     * 第二趟排序，调整遍历数组的范围，重复上述步骤
     *
     * @param targetArr
     */
    public static void selectionSort(int[] targetArr){
        int minValueIndex = 0;
        for(int i = 0 ; i < targetArr.length - 1 ; i ++ ){
            minValueIndex = i;
            for(int j = i+1 ; j < targetArr.length ; j++){
                minValueIndex = targetArr[j] < targetArr[minValueIndex] ? j : minValueIndex;
            }
            swap(targetArr,i,minValueIndex);
        }
    }

    public static void swap(int[] targetArr,int i,int j){
        int temp = targetArr[i];
        targetArr[i] = targetArr[j];
        targetArr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {41,2,33,14,25,76,47,28,19,19};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
