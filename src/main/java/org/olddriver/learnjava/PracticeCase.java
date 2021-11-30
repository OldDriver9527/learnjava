package org.olddriver.learnjava;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PracticeCase {

    /**
     * 合并两个有序数组
     * 遍历其中一个数组
     * 使用二分查找方式，确定当前元素应该插入的位置，插入元素后继续遍历
     * A长度很大，可以容纳B中所有元素
     *
     * 二分查找
     * 定义left，right，mid三指针
     * left指向首元素，right指向尾元素，mid = (left + right)/2
     * 比较mid元素和目标元素
     * 当 目标元素 < mid元素  right指针左移，right = mid-1
     * 当 mid元素 <目标元素   left指针左移，left = mid+1
     * 继续比较，直到 right < left
     *
     * @param A 数组A
     * @param m 数组中元素个数
     * @param B 数组B
     * @param n 数组中元素个数
     */
    public void mergeArray(int A[], int m, int B[], int n){
        int AEleNum = m;
        int left = 0 , right = 0 , mid = 0;
        for(int i = 0 ; i < n ; i++){
            left = 0;
            right = AEleNum -1;
            mid = (left + right) /2;
            while(left <= right){
                if(A[mid] == B[i]){
                    left = mid;
                    break;
                }else if(A[mid] < B[i]){
                    left = mid + 1;
                    mid = (left + right) /2;
                }else{
                    right = mid - 1;
                    mid = (left + right) /2;
                }
            }
            if(right < 0){
                add(A,0,B[i],AEleNum);
                AEleNum++;
            }else if(left == AEleNum){
                add(A,left,B[i],AEleNum);
                AEleNum++;
            }else{
                add(A,left,B[i],AEleNum);
                AEleNum++;
            }
        }
    }
    private void add(int arr[],int index,int ele,int eleNum){
        if(index == eleNum){
            arr[index] = ele;
        }else{
            for(int i = eleNum -1; i >= index ; i--){
                arr[i+1] = arr[i];
            }
            arr[index] = ele;
        }
    }

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转列表
     * 使用两个引用分别指向当前节点，当前节点前趋
     * 若当前节点不为null
     * 临时记录当前节点的指针域
     * 将当前节点指针域覆盖，覆盖为当前节点前趋
     * 当前节点前趋后移
     * 当前节点后移
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode temp = null;

        while(current != null){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }


    /**
     * 大数乘法
     * 使用字节数组反向存储大数，每一位对应字节数组中一个元素
     * 遍历其中一个数组，将数组中的当前位与另一个数组中每一位相乘，相乘结果累加到临时数组的对应位上
     * 遍历完毕后，处理临时数组中每一位
     * 先处理非最高位，计算当前位和进位
     * 最后处理最高位，最高位的进位可以不止一位
     *
     * @return
     */
    @Test
    public void bigNumMultiply() {
        String firstValue = "123123123";
        String secondValue = "323232323232";

        byte[] firstArr = new byte[1000];
        byte[] secondArr = new byte[1000];
        int[] sumArr = new int[1000];

        int digit = secondValue.length();
        StringBuilder sb = new StringBuilder();

        for (int i = firstValue.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = firstValue.charAt(i);
            firstArr[j] = Byte.valueOf(String.valueOf(c).toString()).byteValue();
        }

        for (int i = secondValue.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = secondValue.charAt(i);
            secondArr[j] = Byte.valueOf(String.valueOf(c).toString()).byteValue();
        }

        //对长度较短的字符串高位补0，使两字符串长度相等
        if (Integer.compare(firstValue.length(), secondValue.length()) > 0) {
            for (int i = secondArr.length; i < firstArr.length; i++) {
                secondArr[i] = 0;
            }
        } else if (Integer.compare(firstValue.length(), secondValue.length()) == 0) {
        } else {
            for (int i = firstValue.length(); i < secondValue.length(); i++) {
                firstArr[i] = 0;
            }
        }

        //在两数组最后添加特殊值，作为结束标记
        firstArr[Math.max(firstValue.length(), secondValue.length())] = -1;
        secondArr[Math.max(firstValue.length(), secondValue.length())] = -1;


        for(int i = 0; i < firstArr.length && Byte.compare(firstArr[i], (byte) -1) != 0; i++){
            for(int j = 0 ; j < secondArr.length && Byte.compare(secondArr[j], (byte) -1) != 0 ;j++){
                sumArr[j] += firstArr[i]* (int)Math.pow(10.0,i) * secondArr[j];
            }
        }

        for(int i = 0 ; i < digit -1 ; i++){
            sumArr[i+1] += sumArr[i]/10;
            sumArr[i] = sumArr[i] % 10;
        }

        while(sumArr[digit -1] > 9){
            sumArr[digit] += sumArr[digit -1]/10;
            sumArr[digit -1] %= 10;
            digit++;
        }

        for(int i = digit -1 ; i >= 0 ; i--){
            sb.append(sumArr[i]);
        }

        System.out.println(sb.toString());
    }


    /**
     * 阶乘
     * 阶乘结果用整型数组反向存储，每一位对应整型数组中一个元素
     * 计算第n阶阶乘时
     * 使用n乘以整型数组中每个元素，再对数组中的每个元素进行处理
     * 先处理非最高位，计算当前位和进位
     * 最后处理最高位，最高位的进位可以不止一位
     *
     * @return
     */
    @Test
    public void bigNumFactorial() {

        String bigNum = "50";
        int bounds= Integer.valueOf(bigNum);
        final int MAX_LENGTH = 10000;
        int[] factorial = new int[MAX_LENGTH];
        factorial[0] = 1;
        int digit = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 2 ; i <= bounds ; i++){
            //数组中每位数字 乘以 阶数
            for(int j = 0; j < factorial.length && j < digit ; j++){
                factorial[j] *= i;
            }

            //对非最高位进行处理，计算进位，当前位
            for(int j = 0; j < factorial.length && j < digit -1 ; j++){
                if( factorial[j] > 9 ){
                    factorial[j+1] += factorial[j] / 10;
                    factorial[j] %= 10;
                }
            }

            //对最高位进行处理
            while(factorial[digit - 1] > 9){
                factorial[digit] += factorial[digit - 1] / 10;
                factorial[digit - 1] %= 10;
                digit++;
            }

        }

        for(int i = digit -1 ; i >= 0 ; i--){
             sb.append(factorial[i]);
        }

        System.out.println(sb.toString());
    }

    /**
     * 大数加法
     * 将大数使用字节数组反向存储，每一位对应字节数组中一个元素
     * 两个数组对应位计算当前位及进位
     * 计算的结果存入新数组
     * @return
     */
    @Test
    public void bigNumAdd() {
        String firstValue = "888888888888888888888888888888";
        String secondValue = "999999999999999999999999";
        StringBuilder sb = new StringBuilder();
        final int MAX_LENGTH = 1000;
        byte[] firstArr = new byte[MAX_LENGTH + 1];
        byte[] secondArr = new byte[MAX_LENGTH + 1];
        byte[] sumArr = new byte[MAX_LENGTH + 2];
        int index = 0;
        //进位
        int up = 0;
        //对应位相加临时结果
        int temp = 0;

        for (int i = firstValue.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = firstValue.charAt(i);
            firstArr[j] = Byte.valueOf(String.valueOf(c).toString()).byteValue();
        }

        for (int i = secondValue.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = secondValue.charAt(i);
            secondArr[j] = Byte.valueOf(String.valueOf(c).toString()).byteValue();
        }

        //对长度较短的字符串高位补0，使两字符串长度相等
        if (Integer.compare(firstValue.length(), secondValue.length()) > 0) {
            for (int i = secondArr.length; i < firstArr.length; i++) {
                secondArr[i] = 0;
            }
        } else if (Integer.compare(firstValue.length(), secondValue.length()) == 0) {
        } else {
            for (int i = firstValue.length(); i < secondValue.length(); i++) {
                firstArr[i] = 0;
            }
        }

        //在两数组最后添加特殊值，作为结束标记
        firstArr[Math.max(firstValue.length(), secondValue.length())] = -1;
        secondArr[Math.max(firstValue.length(), secondValue.length())] = -1;


        for (index = 0; index < firstArr.length && Byte.compare((byte) -1, firstArr[index]) != 0; index++) {
            temp = firstArr[index] + secondArr[index] + up;
            //计算进位
            up = temp / 10;
            //计算当前位结果
            sumArr[index] = (byte) (temp % 10);
        }

        //判断最高位相加后是否存在进位
        if (up == 0) {
            for (int i = index - 1; i >= 0; i--) {
                sb.append(sumArr[i]);
            }
        } else {
            sumArr[index] = (byte) up;
            for (int i = index; i >= 0; i--) {
                sb.append(sumArr[i]);
            }
        }

        System.out.println(sb.toString());
    }



    @Test
    public void testSolve () {
        int[] nums = {10,1};
        List<String> numList = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            numList.add(String.valueOf(nums[i]));
        }

        Collections.sort(numList,(left,right)->{
            if(left.length() == right.length()){
                return -left.compareTo(right);
            }else{
                if(left.startsWith(right) || right.startsWith(left)){
                    String one = left+right;
                    String other = right+left;
                    return -one.compareTo(other);
                }else{
                    return -left.compareTo(right);
                }
            }
        });

        BigInteger bigInteger = new BigInteger("00");
        System.out.println(bigInteger);

        System.out.println(numList);


        System.out.println("10".compareTo("1"));
    }



}
