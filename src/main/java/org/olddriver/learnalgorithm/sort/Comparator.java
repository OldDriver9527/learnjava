package org.olddriver.learnalgorithm.sort;

import java.util.Arrays;

public class Comparator {
    public static void selectionSortComparator(){
        int testTime = 100;
        int maxLength = 100;
        int maxValue = 200;
        int[] temp = null;
        for(int i = 0 ; i < testTime ; i++ ){
            temp = generateRandomArray(maxLength,maxValue);
            int[] tempCopy = Arrays.copyOf(temp,temp.length);
            Arrays.sort(tempCopy);
            System.out.println(Arrays.toString(tempCopy));
            SelectionSort.selectionSort(temp);
            System.out.println(Arrays.toString(temp));
            System.out.println("----------------------------------------");
            if(!Arrays.equals(temp,tempCopy)){
                System.out.println("error");
                break;
            }
        }
    }



    public static int[] generateRandomArray(int maxLength,int maxValue){
        //Math.random() 产生[0,1) 范围内随机浮点数
        //Math.random()*N 产生[0,N) 范围内随机浮点数
        //(int)(Math.random()*N) 产生[0,N-1] 范围内随机整数

        int[] randomArray = new int[(int) (Math.random()*(maxLength+1))];
        for(int i = 0 ; i < randomArray.length ; i++){
            randomArray[i] = (int)(Math.random()*(maxValue+1)) - (int)(Math.random()*(maxValue+1));
        }
        return randomArray;
    }

    public static void main(String[] args) {
        selectionSortComparator();
    }
}
