package org.olddriver.learnAlgorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * 由 n-1 趟排序组成
     * 第一趟排序，保证 0~1 范围内元素有序，将索引为 1 的元素与左侧元素比较，当 1 位置元素小于左侧元素，两者交换，
     * 继续比较，直到 1 位置元素不小于左侧元素，比较结束
     * 第二趟排序，保证 0~2 范围内元素有序，重复上述步骤
     *
     * @param targetArr
     */
    public static void insertionSort(int[] targetArr){
        int j;
        for(int i = 1 ; i < targetArr.length ; i++){
            int temp = targetArr[i];
            for(j = i ; j > 0 && temp < targetArr[j-1] ; j--){
                    targetArr[j] = targetArr[j-1];
//                    swap(targetArr,j,j-1);
            }
            targetArr[j] = temp;
        }
    }

    public static void swap(int[] targetArr,int i,int j){
        int temp = targetArr[i];
        targetArr[i] = targetArr[j];
        targetArr[j] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {41,2,33,14,25,76,47,28,19,19};
        int[] arr = {9,8,7,6,5,4,3,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
