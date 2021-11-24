package org.olddriver.learnjava;

import org.junit.Test;

public class PracticeCase {

    /**
     * 大数乘法
     *
     * @return
     */
    @Test
    public void testMultiply() {
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
     *
     * @return
     */
    @Test
    public void testBigNumFactorial() {

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
     *
     * @return
     */
    @Test
    public void testBigNumAdd() {
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

}
