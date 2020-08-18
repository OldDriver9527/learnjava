package org.olddriver.learnalgorithm.search;

public class BinarySearch {

    public static int binarySearch(int[] sortedArray,int target){
        int leftIndex = 0;
        int rightIndex = sortedArray.length - 1;
        int middleIndex;
        while(leftIndex <= rightIndex){
            middleIndex = (leftIndex + rightIndex) / 2;
            if(sortedArray[middleIndex] == target){
                return middleIndex;
            }else if(sortedArray[middleIndex] > target){
                rightIndex = middleIndex -1;
            }else{
                leftIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int index = binarySearch(arr,5);
        System.out.println(index);
    }

}
