package org.olddriver.learnjava;

import org.olddriver.learnjava.oo.Foo;

import java.util.stream.Stream;

public class PracticeCase extends Foo {
    /**
     * 阶乘
     * @param number
     * @return
     */
    public static int factorial(int number){
        if(number == 1){
            return 1;
        }else{
            return number * factorial(number - 1);
        }
    }


    public static void main(String[] args) {
        PracticeCase sub = new PracticeCase();
        sub.test();

        int[] arr = {1};
        Stream<int[]> arr1 = Stream.of(arr);
    }
}
